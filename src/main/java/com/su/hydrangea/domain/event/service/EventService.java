package com.su.hydrangea.domain.event.service;

import com.su.hydrangea.domain.event.dto.EventDto;
import com.su.hydrangea.domain.event.entity.Event;
import com.su.hydrangea.domain.event.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;

    public EventDto.Response getEventList(EventDto.Request request, Pageable pageable) {
        Page<Event> eventList = eventRepository.findByLatitudeBetweenAndLongitudeBetween(
                request.getLatitude1(),
                request.getLatitude2(),
                request.getLongitude1(),
                request.getLongitude2(),
                pageable);

        return new EventDto.Response(
                eventList.getTotalElements(),
                eventList.stream().map(
                event -> {
                    return new EventDto.Content(
                            event.getName(),
                            event.getImage(),
                            event.getLatitude(),
                            event.getLongitude(),
                            event.getStartDate(),
                            event.getEndDate()
                    );
                }).collect(Collectors.toList())
        );
    }

}
