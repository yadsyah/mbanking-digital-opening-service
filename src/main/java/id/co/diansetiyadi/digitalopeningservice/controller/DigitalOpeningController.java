package id.co.diansetiyadi.digitalopeningservice.controller;

import id.co.diansetiyadi.digitalopeningservice.dto.request.SubmitApplyOpeningRequest;
import id.co.diansetiyadi.digitalopeningservice.dto.request.ValidationApplyOpeningRequest;
import id.co.diansetiyadi.digitalopeningservice.dto.response.BaseResponse;
import id.co.diansetiyadi.digitalopeningservice.service.DigitalOpeningService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.UUID;

@RestController
public class DigitalOpeningController {

    private final DigitalOpeningService digitalOpeningService;

    @Autowired
    public DigitalOpeningController(DigitalOpeningService digitalOpeningService) {
        this.digitalOpeningService = digitalOpeningService;
    }

    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Validation Apply Digital Opening") })
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

    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Submit Apply Digital Opening") })
    @PostMapping("/submit-apply")
    @ResponseBody
    public Mono<BaseResponse> submitApply(@RequestBody @Valid SubmitApplyOpeningRequest request) {
        return Mono.just(BaseResponse.builder()
                        .responseCode("00")
                        .traceId(UUID.randomUUID().toString())
                        .message("Success")
                        .data(digitalOpeningService.submitApplication(request))
                .build());
    }
}
