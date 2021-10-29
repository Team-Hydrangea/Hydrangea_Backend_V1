package com.su.hydrangea.domain.region.service;

import com.su.hydrangea.domain.region.dto.RegionInfoDto;
import com.su.hydrangea.domain.region.dto.SafeRegionDto;
import com.su.hydrangea.domain.region.entity.RegionInfo;
import com.su.hydrangea.domain.region.repository.CustomRegionRepositoryImpl;
import com.su.hydrangea.domain.region.repository.RegionInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RegionService {

    private final CustomRegionRepositoryImpl customRegionRepository;
    private final RegionInfoRepository regionInfoRepository;

    public SafeRegionDto.Response getSafeRegion() {
        RegionInfo regionInfo = customRegionRepository.getSafeRandomRegion();
        return new SafeRegionDto.Response(regionInfo.getId().getName());
    }

    public RegionInfoDto.Response getRegionInfo() {

//        return regionInfoRepository.findAll().stream()
//                .map(regionInfo -> {
//                    return new RegionInfoDto(
//                            regionInfo.getId().getName(),
//
//                    )
//                }).collect(Collectors.toList());

    }
}
