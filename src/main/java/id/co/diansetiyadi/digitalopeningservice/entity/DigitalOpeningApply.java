package id.co.diansetiyadi.digitalopeningservice.entity;


import id.co.diansetiyadi.digitalopeningservice.util.StatusApplyEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "digital_opening_apply")
//@MappedSuperclass
public class DigitalOpeningApply {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name = "cif", length = 16)
    private String cif;
    @Column(name = "reff_code", length = 20)
    private String reffCode;
    @Column(name = "data_apply", columnDefinition = "text")
    @Lob
    private String dataApply;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StatusApplyEnum status;
    @Column(name = "list_product_apply", length = 100)
    private String listProductApply;
    @Column(name = "deviceId", length = 50)
    private String deviceId;
}
