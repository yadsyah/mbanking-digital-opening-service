package id.co.diansetiyadi.digitalopeningservice.repository;

import id.co.diansetiyadi.digitalopeningservice.entity.DigitalOpeningApply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DigitalOpeningApplyRepository extends JpaRepository<DigitalOpeningApply, String> {

    @Query("SELECT doa FROM DigitalOpeningApply doa WHERE doa.deviceId=:deviceId")
    List<DigitalOpeningApply> findByDeviceId(String deviceId);
}
