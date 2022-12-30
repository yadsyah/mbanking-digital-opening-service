package id.co.diansetiyadi.digitalopeningservice.dto.request;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ValidationApplyOpeningRequest extends BaseRequest {

    private String cif;
    private boolean isExistBank;
    private String noKTP;
    private String noNPWP;
    private List<Product> detailProduct;
    private String fullName;
    private String motherName;
}
