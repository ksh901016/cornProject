package com.corn.toyproject.core.api.domain.band.controller;

import com.corn.toyproject.core.api.common.entity.Response;
import com.corn.toyproject.core.api.common.entity.SuccessResponse;
import com.corn.toyproject.core.api.domain.band.entity.BandPostingRequest;
import com.corn.toyproject.core.api.domain.band.entity.PostingDTO;
import com.corn.toyproject.core.api.domain.band.service.BandService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class BandController {
    private final BandService bandService;

    @GetMapping("/api/bands")
    public Response getBandList(){
        return new SuccessResponse(bandService.getBandList());
    }

    @PostMapping("/api/band/post")
    public Response post(@RequestBody PostingDTO postingDTO) throws InterruptedException {
        log.debug("postingDTO : {}", postingDTO);
        bandService.post(postingDTO);
        return new SuccessResponse(null);
    }

    @GetMapping("/api/band/user")
    public Response getBandUser(){
        return new SuccessResponse(bandService.getBandUser());
    }

    @GetMapping("/api/band/isLoading")
    public Response isLoading(){
        return new SuccessResponse(bandService.isLoading());
    }

    @PostMapping("/api/band/stop")
    public Response stop(){
        bandService.setInfinite(false);
        return new SuccessResponse(null);
    }
}
