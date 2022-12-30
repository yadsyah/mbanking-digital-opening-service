package id.co.diansetiyadi.digitalopeningservice.dto.request;

import id.co.diansetiyadi.digitalopeningservice.util.AddressTypeEnum;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Address {

    private String addressFull;
    private String postCode;
    private String provinceCode;
    private AddressTypeEnum addressTypeEnum;
}
