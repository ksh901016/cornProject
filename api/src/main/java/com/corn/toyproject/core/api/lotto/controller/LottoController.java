package com.corn.toyproject.core.api.lotto.controller;

import com.corn.toyproject.core.api.common.entity.Response;
import com.corn.toyproject.core.api.common.entity.SuccessResponse;
import com.corn.toyproject.core.api.lotto.service.LottoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/lotto")
@RequiredArgsConstructor
public class LottoController {
    private final LottoService lottoService;

    @GetMapping("/{count}")
    public Response getLottoNumberList(@PathVariable int count){
        return new SuccessResponse(lottoService.getLottoNumberList(count));
    }
}
