package com.example.quanlycacloaitramdo.repository;

import com.example.quanlycacloaitramdo.entity.LogsAction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogsActionRepository extends JpaRepository<LogsAction, Long> {

}
