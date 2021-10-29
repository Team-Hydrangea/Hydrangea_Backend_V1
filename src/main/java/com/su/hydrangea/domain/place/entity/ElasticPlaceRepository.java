package com.su.hydrangea.domain.place.entity;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ElasticPlaceRepository extends ElasticsearchRepository<Place, String> {
}
