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
        return new SafeRegionDto.Response(regionInfo.getName());
    }

    public List<RegionInfoDto.Response> getRegionInfo() {

        return regionInfoRepository.findAll().stream()
                .map(regionInfo -> {
                    long confirmCaseCount = regionInfo.getConfirmCaseCount();
                    long vaccinateCaseCount = regionInfo.getVaccinateCaseCount();
                    long population = regionInfo.getPopulation();
                    double score =
                            ((double)vaccinateCaseCount/(double)population)*20 +
                                    ((double)(population-30*(5*regionInfo.getDeadCaseCount() + confirmCaseCount)))/population*80;
                    return new RegionInfoDto.Response(
                            regionInfo.getName(),
                            confirmCaseCount,
                            vaccinateCaseCount,
                            population,
                            score
                    );
                }).collect(Collectors.toList());

    }
}
