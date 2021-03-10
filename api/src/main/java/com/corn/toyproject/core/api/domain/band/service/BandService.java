package com.corn.toyproject.core.api.domain.band.service;

import com.corn.toyproject.core.api.domain.band.entity.BandCommonResponse;
import com.corn.toyproject.core.api.domain.band.repository.TokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BandService {
    private final BandApiService apiService;

    public BandCommonResponse getBandList(){
        return apiService.getBandList(TokenRepository.accessTokenResponse.getAccessToken());
    }
}
