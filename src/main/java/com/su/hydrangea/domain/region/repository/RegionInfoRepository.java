package com.su.hydrangea.domain.region.repository;

import com.su.hydrangea.domain.region.entity.RegionInfo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RegionInfoRepository extends CrudRepository<RegionInfo, String> {

    List<RegionInfo> findAll();

}
