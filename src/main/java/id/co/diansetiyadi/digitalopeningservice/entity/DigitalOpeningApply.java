package id.co.diansetiyadi.digitalopeningservice.entity;


import id.co.diansetiyadi.digitalopeningservice.util.StatusApplyEnum;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DigitalOpeningApply extends BaseEntity {

    private String cif;
    private String reffCode;
    private String dataApply;
    private StatusApplyEnum status;
    private String listProductApply;
}
