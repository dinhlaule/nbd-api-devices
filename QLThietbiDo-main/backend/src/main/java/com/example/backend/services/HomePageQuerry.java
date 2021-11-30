package com.example.backend.services;

import com.example.backend.entity.Instrumentation_param;
import com.example.backend.entity.ParamHome;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class HomePageQuerry {
    @PersistenceContext
    private EntityManager em ;

    public List<Object[]> paraHome(){
    return em.createNativeQuery("select i.ins_name,i.ins_id,pt.parameter_type_name,i.manufact,i.ins_model,i.status from Instrumentation_param ip, Parameter_type  pt, Instrumentation i where ((i.ins_id = ip.ins_param_id) and(ip.ins_param_id=pt.parameter_type_id))", Instrumentation_param.class).getResultList();

    }
}
