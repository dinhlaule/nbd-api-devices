package com.example.backend.repository;

import com.example.backend.entity.Parameter_type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Parameter_typeRepository extends JpaRepository<Parameter_type,Integer> {
}
