package id.co.diansetiyadi.digitalopeningservice.dto.response;

import id.co.diansetiyadi.digitalopeningservice.util.StatusApplyEnum;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class InquiryDigitalOpeningApplyResponse {

    private String reffCode;
    private StatusApplyEnum statusApply;
    private String listProduct;
    private String cif;
}
