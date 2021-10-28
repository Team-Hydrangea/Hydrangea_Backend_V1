package com.su.hydrangea.domain.region.repository;

import com.su.hydrangea.domain.region.entity.RegionInfo;
import com.su.hydrangea.domain.region.entity.id.RegionInfoId;
import org.springframework.data.repository.CrudRepository;

public interface RegionInfoRepository extends CrudRepository<RegionInfo, RegionInfoId> {
}
