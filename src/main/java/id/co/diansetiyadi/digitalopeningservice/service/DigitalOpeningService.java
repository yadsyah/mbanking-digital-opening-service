package id.co.diansetiyadi.digitalopeningservice.service;


import id.co.diansetiyadi.digitalopeningservice.dto.request.InquiryDigitalOpeningApplyRequest;
import id.co.diansetiyadi.digitalopeningservice.dto.request.SubmitApplyOpeningRequest;
import id.co.diansetiyadi.digitalopeningservice.dto.request.ValidationApplyOpeningRequest;
import id.co.diansetiyadi.digitalopeningservice.dto.response.InquiryDigitalOpeningApplyResponse;
import id.co.diansetiyadi.digitalopeningservice.dto.response.SubmitApplyOpeningResponse;
import id.co.diansetiyadi.digitalopeningservice.dto.response.ValidationApplyOpeningResponse;

import java.util.List;

public interface DigitalOpeningService {

    void sendNotification();
    SubmitApplyOpeningResponse submitApplication(SubmitApplyOpeningRequest request);
    ValidationApplyOpeningResponse validationApply(ValidationApplyOpeningRequest request);
    List<InquiryDigitalOpeningApplyResponse> inquiryDigitalOpeningApply(InquiryDigitalOpeningApplyRequest request);


}
