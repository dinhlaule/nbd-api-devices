package com.example.backend.repository;

import com.example.backend.entity.Instrumentation_param;
import com.example.backend.entity.ParamHome;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public interface Instrumentation_paramRepository extends JpaRepository<Instrumentation_param,Integer> {


    @Query("select new  com.example.backend.entity.ParamHome(i.ins_name,i.ins_id,pt.parameter_type_name,i.manufact,i.ins_model,i.status) from Instrumentation_param ip, Parameter_type  pt, Instrumentation i where ((i.ins_id = ip.ins_param_id) and(ip.ins_param_id=pt.parameter_type_id)) ")
        public List<ParamHome> homeResponse();
}
