package com.su.hydrangea.domain.user.service;

import com.su.hydrangea.domain.place.entity.Place;
import com.su.hydrangea.domain.place.repository.ElasticPlaceRepository;
import com.su.hydrangea.domain.user.dto.BookmarkAddDto;
import com.su.hydrangea.domain.user.dto.BookmarkDto;
import com.su.hydrangea.domain.user.dto.BookmarkRandomDto;
import com.su.hydrangea.domain.user.entity.Bookmark;
import com.su.hydrangea.domain.user.entity.User;
import com.su.hydrangea.domain.user.excpetion.UserNotFoundException;
import com.su.hydrangea.domain.user.repository.BookmarkRepository;
import com.su.hydrangea.domain.user.repository.CustomBookmarkRepositoryImpl;
import com.su.hydrangea.domain.user.repository.CustomStarScoreRepositoryImpl;
import com.su.hydrangea.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookmarkService {

    private final UserRepository userRepository;
    private final BookmarkRepository bookmarkRepository;
    private final ElasticPlaceRepository placeRepository;
    private final CustomBookmarkRepositoryImpl customBookmarkRepository;
    private final CustomStarScoreRepositoryImpl customStarScoreRepository;

    @Transactional
    public void addBookmark(BookmarkAddDto.Request request, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(UserNotFoundException::new);

        if (bookmarkRepository.existsByUserIdAndLongitudeAndLatitude(userId, request.getLongitude(), request.getLatitude())) {
            bookmarkRepository.deleteByLongitudeAndLatitudeAndUser(request.getLongitude(), request.getLatitude(), user);
        } else {
            Bookmark bookmark = Bookmark.builder()
                    .latitude(request.getLatitude())
                    .longitude(request.getLongitude())
                    .user(user)
                    .build();
            bookmarkRepository.save(bookmark);
        }
    }

    public BookmarkDto.Response getBookmarkList(Pageable pageable, long userId) {
        Page<Bookmark> bookmarkList = bookmarkRepository.findByUserId(userId, pageable);
        List<BookmarkDto.Content> contents = new ArrayList<>();

        for (Bookmark bookmark : bookmarkList.getContent()) {
            Place place = placeRepository.findByLongitudeAndLatitude(bookmark.getLongitude(), bookmark.getLatitude())
                            .orElseThrow(UserNotFoundException::new);

            BookmarkDto.Content content = BookmarkDto.Content.builder()
                    .image(place.getImage())
                    .latitude(bookmark.getLatitude())
                    .longitude(bookmark.getLongitude())
                    .number(place.getNumber())
                    .title(place.getTitle())
                    .address(place.getAddr1())
                    .detailAddress(place.getAddr2())
                    .build();

            contents.add(content);
        }

        return new BookmarkDto.Response(bookmarkList.getTotalPages(), contents);
    }

    public BookmarkRandomDto.Response getRandomBookmarkPlace(long userId) {
        if (bookmarkRepository.existsByUserId(userId)) {
            throw new UserNotFoundException();
        }
        Bookmark bookmark = customBookmarkRepository.getRandomBookmark(userId);
        Place place = placeRepository.findByLongitudeAndLatitude(bookmark.getLongitude(), bookmark.getLatitude())
                .orElseThrow(UserNotFoundException::new);

        return BookmarkRandomDto.Response
                .builder()
                .image(place.getImage())
                .latitude(bookmark.getLatitude())
                .longitude(bookmark.getLongitude())
                .number(place.getNumber())
                .title(place.getTitle())
                .address(place.getAddr1())
                .detailAddress(place.getAddr2())
                .starScore(customStarScoreRepository.getAvg(
                        place.getLatitude(),
                        place.getLongitude()
                ))
                .build();
    }

}
