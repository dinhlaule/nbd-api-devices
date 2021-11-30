package com.example.backend.repository;

import com.example.backend.entity.Instrumentation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstrumentationRepository extends JpaRepository<Instrumentation,Integer> {

}
