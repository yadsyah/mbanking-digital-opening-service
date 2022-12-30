package id.co.diansetiyadi.digitalopeningservice.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public abstract class BaseEntity {

    private String id;
    private Date createdDate;
    private String updatedDate;
    private String createdBy;
    private String updatedBy;
}
