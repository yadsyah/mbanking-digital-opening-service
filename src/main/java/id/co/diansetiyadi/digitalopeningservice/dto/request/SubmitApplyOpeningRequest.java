package id.co.diansetiyadi.digitalopeningservice.dto.request;


import id.co.diansetiyadi.digitalopeningservice.util.GenderEnum;
import id.co.diansetiyadi.digitalopeningservice.util.ReligionEnum;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class SubmitApplyOpeningRequest extends BaseRequest {

    private String cif;
    private boolean isExistBank;
    private String noKTP;
    private String noNPWP;
    private List<Product> productList;
    private String fullName;
    private String motherName;
    private List<Address> addressList;
    private ReligionEnum religionEnum;
    private GenderEnum genderEnum;
    private String birthDate;
    private String age;
    private PersonalLoan personalLoan;


    public boolean getIsExistBank() {
        return isExistBank;
    }

    public void setIsExistBank(boolean existBank) {
        isExistBank = existBank;
    }
}
