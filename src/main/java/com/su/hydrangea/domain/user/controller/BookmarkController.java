package com.su.hydrangea.domain.user.controller;

import com.su.hydrangea.domain.user.dto.BookmarkAddDto;
import com.su.hydrangea.domain.user.dto.BookmarkDeleteDto;
import com.su.hydrangea.domain.user.dto.BookmarkDto;
import com.su.hydrangea.domain.user.service.BookmarkService;
import com.su.hydrangea.global.security.AuthenticationFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bookmark")
public class BookmarkController {

    private final BookmarkService bookmarkService;
    private final AuthenticationFacade authenticationFacade;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addBookmark(@RequestBody BookmarkAddDto.Request request) {
        bookmarkService.addBookmark(request,authenticationFacade.getId());
    }

    @GetMapping
    public BookmarkDto.Response getBookmarkList(@RequestParam("page") int page, @RequestParam("size") int size) {
        return bookmarkService.getBookmarkList(PageRequest.of(page, size), authenticationFacade.getId());
    }

}
