package com.su.hydrangea.domain.region.entity;

import com.su.hydrangea.domain.region.entity.id.RegionInfoId;
import org.springframework.data.repository.CrudRepository;

public interface RegionInfoRepository extends CrudRepository<RegionInfo, RegionInfoId> {
}
