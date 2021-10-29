package com.su.hydrangea.domain.user.service;

import com.su.hydrangea.domain.user.dto.BookmarkAddDto;
import com.su.hydrangea.domain.user.dto.BookmarkDeleteDto;
import com.su.hydrangea.domain.user.entity.Bookmark;
import com.su.hydrangea.domain.user.entity.User;
import com.su.hydrangea.domain.user.excpetion.UserNotFoundException;
import com.su.hydrangea.domain.user.repository.BookmarkRepository;
import com.su.hydrangea.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class BookmarkService {

    private final UserRepository userRepository;
    private final BookmarkRepository bookmarkRepository;

    public void addBookmark(@RequestBody BookmarkAddDto.Request request, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(UserNotFoundException::new);

        Bookmark bookmark = Bookmark.builder()
                .latitude(request.getLatitude())
                .longitude(request.getLongitude())
                .user(user)
                .build();
        bookmarkRepository.save(bookmark);
    }

    public void deleteBookmark(@RequestBody BookmarkDeleteDto.Request request, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(UserNotFoundException::new);

        bookmarkRepository.deleteByLongitudeAndLatitudeAndUser(request.getLatitude(), request.getLongitude(), user);
    }

}
