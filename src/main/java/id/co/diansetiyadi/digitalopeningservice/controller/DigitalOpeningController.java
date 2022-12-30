package id.co.diansetiyadi.digitalopeningservice.controller;

import id.co.diansetiyadi.digitalopeningservice.dto.request.ValidationApplyOpeningRequest;
import id.co.diansetiyadi.digitalopeningservice.dto.response.BaseResponse;
import id.co.diansetiyadi.digitalopeningservice.service.DigitalOpeningService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@Slf4j
public class DigitalOpeningController {


    private final DigitalOpeningService digitalOpeningService;

    @Autowired
    public DigitalOpeningController(DigitalOpeningService digitalOpeningService) {
        this.digitalOpeningService = digitalOpeningService;
    }

    @PostMapping("/validation")
    @ResponseBody
    public Mono<BaseResponse> validationApply(@RequestBody @Valid ValidationApplyOpeningRequest validationApplyOpeningRequest) {
        return Mono.just(BaseResponse.builder()
                        .responseCode("00")
                        .traceId(UUID.randomUUID().toString())
                        .message("Success")
                        .data(digitalOpeningService.validationApply(validationApplyOpeningRequest))
                .build());
    }
}
