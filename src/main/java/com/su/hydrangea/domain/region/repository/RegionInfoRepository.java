package com.su.hydrangea.domain.region.repository;

import com.su.hydrangea.domain.region.entity.RegionInfo;
import com.su.hydrangea.domain.region.entity.id.RegionInfoId;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RegionInfoRepository extends CrudRepository<RegionInfo, RegionInfoId> {

    List<RegionInfo> findAll();

}
