package id.co.diansetiyadi.digitalopeningservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Setter
@Getter
@MappedSuperclass
public abstract class BaseEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name = "created_date")
    @CreatedDate
    private Date createdDate;
    @Column(name = "updatedDate")
    private String updatedDate;
    @Column(name = "created_by", length = 50)
    private String createdBy;
    @Column(name = "updated_by", length = 50)
    private String updatedBy;
}
