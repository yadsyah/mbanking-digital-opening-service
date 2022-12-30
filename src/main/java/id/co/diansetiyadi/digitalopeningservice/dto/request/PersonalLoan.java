package id.co.diansetiyadi.digitalopeningservice.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PersonalLoan {

    private String amount;
    private String tenor;
    private String purposeLoan;
}
