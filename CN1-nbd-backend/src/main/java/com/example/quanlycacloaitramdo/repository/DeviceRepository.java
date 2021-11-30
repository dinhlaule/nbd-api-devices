package com.example.quanlycacloaitramdo.repository;

import com.example.quanlycacloaitramdo.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {
    @Query(value = "SELECT * FROM OBJECT_TYPE WHERE (UPPER(object_TYPE) like %?1% and UPPER(object_TYPE_SHORTNAME) like %?2% and is_AUTO like %?3%)", nativeQuery = true)
    List<Device> findByContain(String object_TYPE, String object_TYPE_SHORTNAME, String is_AUTO);

    @Query(value = "SELECT COUNT(1) FROM object_type WHERE object_type = ?1 ", nativeQuery = true)
    Long findByObjectTYPE(String object_TYPE);
}
