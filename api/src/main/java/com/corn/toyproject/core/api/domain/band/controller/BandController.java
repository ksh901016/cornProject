package com.corn.toyproject.core.api.domain.band.controller;

import com.corn.toyproject.core.api.common.entity.Response;
import com.corn.toyproject.core.api.common.entity.SuccessResponse;
import com.corn.toyproject.core.api.domain.band.service.BandService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BandController {
    private final BandService bandService;

    @GetMapping("/api/bands")
    public Response getBandList(){
        return new SuccessResponse(bandService.getBandList());
    }
}
