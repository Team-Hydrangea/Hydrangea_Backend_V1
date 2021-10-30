package com.su.hydrangea.domain.region.service;

import com.su.hydrangea.domain.place.repository.ElasticPlaceRepository;
import com.su.hydrangea.domain.region.dto.RegionInfoDto;
import com.su.hydrangea.domain.region.dto.SafeRegionDto;
import com.su.hydrangea.domain.region.entity.RegionInfo;
import com.su.hydrangea.domain.region.repository.CustomRegionRepositoryImpl;
import com.su.hydrangea.domain.region.repository.RegionInfoRepository;
import com.su.hydrangea.domain.user.repository.BookmarkRepository;
import com.su.hydrangea.domain.user.repository.CustomStarScoreRepositoryImpl;
import com.su.hydrangea.global.security.AuthenticationFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RegionService {

    private final CustomRegionRepositoryImpl customRegionRepository;
    private final RegionInfoRepository regionInfoRepository;
    private final ElasticPlaceRepository placeRepository;
    private final CustomStarScoreRepositoryImpl customStarScoreRepository;
    private final AuthenticationFacade authenticationFacade;
    private final BookmarkRepository bookmarkRepository;

    public List<SafeRegionDto.Response> getSafeRegion(Pageable pageable) {
        RegionInfo regionInfo = customRegionRepository.getSafeRandomRegion();
        return placeRepository.findByTitleContaining(regionInfo.getName(), pageable)
                .stream().map(
                        place -> new SafeRegionDto.Response(
                                place.getTitle(),
                                place.getNumber(),
                                place.getImage(),
                                place.getLatitude(),
                                place.getLongitude(),
                                place.getAddr1(),
                                place.getAddr2(),
                                customStarScoreRepository.getAvg(
                                        place.getLatitude(),
                                        place.getLongitude()
                                ),
                                authenticationFacade.isLogin() && bookmarkRepository.existsByUserIdAndLongitudeAndLatitude(
                                        authenticationFacade.getId(),
                                        place.getLongitude(),
                                        place.getLatitude())
                        )
                ).collect(Collectors.toList());

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
