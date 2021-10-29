package com.su.hydrangea.domain.event.service;

import com.su.hydrangea.domain.event.dto.EventDto;
import com.su.hydrangea.domain.event.entity.Event;
import com.su.hydrangea.domain.event.repository.EventRepository;
import com.su.hydrangea.domain.place.dto.PlaceDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;

    public List<EventDto.Response> getEventList(@Valid @RequestBody EventDto.Request request) {
        List<Event> eventList = eventRepository.findByLocationLatBetweenAndLocationLon(
                request.getLatitude1(),
                request.getLatitude2(),
                request.getLongitude1(),
                request.getLongitude2());

        return eventList.stream().map(
                event -> {
                    GeoPoint geoPoint = event.getLocation();
                    return new EventDto.Response(
                            event.getName(),
                            event.getImage(),
                            geoPoint.getLat(),
                            geoPoint.getLon(),
                            event.getStartDate(),
                            event.getEndDate()
                    );
                }
        ).collect(Collectors.toList());
    }

}
