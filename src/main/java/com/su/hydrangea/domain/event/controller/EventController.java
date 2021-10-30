package com.su.hydrangea.domain.event.controller;

import com.su.hydrangea.domain.event.dto.EventDto;
import com.su.hydrangea.domain.event.service.EventService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/event")
public class EventController {

    private final EventService eventService;

    @PostMapping("/all")
    @ApiOperation(value = "좌표 안에 있는 축제", notes = "입력한 좌표 안에 있는 축제 리스트를 가져옵니다")
    public List<EventDto.Response> getEventList(@RequestBody EventDto.Request request) {
        return eventService.getEventList(request);
    }

}
