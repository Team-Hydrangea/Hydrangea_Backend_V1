package com.su.hydrangea.domain.region.service;

import com.su.hydrangea.domain.region.dto.SafeRegionDto;
import com.su.hydrangea.domain.region.entity.RegionInfo;
import com.su.hydrangea.domain.region.repository.CustomRegionRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegionService {

    private final CustomRegionRepositoryImpl customRegionRepository;

    public SafeRegionDto.Response getSafeRegion() {
        RegionInfo regionInfo = customRegionRepository.getSafeRandomRegion();
        return new SafeRegionDto.Response(regionInfo.getId().getName());
    }

}
