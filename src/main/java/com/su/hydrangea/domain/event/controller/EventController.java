package com.su.hydrangea.domain.event.controller;

import com.su.hydrangea.domain.event.dto.EventDto;
import com.su.hydrangea.domain.event.service.EventService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/event")
public class EventController {

    private final EventService eventService;

    @GetMapping
    @ApiOperation(value = "좌표 안에 있는 축제", notes = "입력한 좌표 안에 있는 축제 리스트를 가져옵니다")
    public List<EventDto.Response> getEventList(@Valid @RequestBody EventDto.Request request) {
        return eventService.getEventList(request);
    }

}
