package com.corn.toyproject.core.api.domain.band.service;

import com.corn.toyproject.core.api.domain.band.entity.BandCommonResponse;
import com.corn.toyproject.core.api.domain.band.entity.BandPostingRequest;
import com.corn.toyproject.core.api.domain.band.entity.PostingDTO;
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

    public void post(PostingDTO postingDTO) throws InterruptedException {
        BandPostingRequest bandPostingRequest = new BandPostingRequest();
        bandPostingRequest.setAccessToken(TokenRepository.accessTokenResponse.getAccessToken());
        bandPostingRequest.setContent(postingDTO.getContent());
        while(true) {
            for (String bandKey : postingDTO.getBandKeyList()) {
                bandPostingRequest.setBandKey(bandKey);
                apiService.post(bandPostingRequest);
            }
            Thread.sleep(10000);
        }
    }
}
