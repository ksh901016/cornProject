package com.corn.toyproject.core.api.domain.band.service;

import com.corn.toyproject.core.api.domain.band.entity.BandCommonResponse;
import com.corn.toyproject.core.api.domain.band.entity.BandPostingRequest;
import com.corn.toyproject.core.api.domain.band.entity.PostingDTO;
import com.corn.toyproject.core.api.domain.band.repository.TokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BandService {
    private final BandApiService apiService;
    private boolean isLoading = false;
    private boolean isInfinite = false;

    public BandCommonResponse getBandList(){
        return apiService.getBandList(TokenRepository.accessTokenResponse.getAccessToken());
    }

    @Async
    public void post(PostingDTO postingDTO) throws InterruptedException {
        BandPostingRequest bandPostingRequest = new BandPostingRequest();
        bandPostingRequest.setAccessToken(TokenRepository.accessTokenResponse.getAccessToken());
        bandPostingRequest.setContent(postingDTO.getContent());
        this.isInfinite = postingDTO.isInfinite();
        do{
            isLoading = true;
            int count = 0 ;
            for (String bandKey : postingDTO.getBandKeyList()) {
                count++;
                bandPostingRequest.setBandKey(bandKey);
                apiService.post(bandPostingRequest);
                if (count == 10) {
                    Thread.sleep(60000);
                    count = 0;
                }
            }
            Thread.sleep(60000);
        }while(true);
        //isLoading = false;
    }

    public BandCommonResponse getBandUser(){
        return apiService.getBandUser(TokenRepository.accessTokenResponse.getAccessToken());
    }

    public boolean isLoading() {
        return isLoading;
    }

    public void setInfinite(boolean infinite) {
        isInfinite = infinite;
    }
}
