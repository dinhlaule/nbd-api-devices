package com.example.backend.controller;

import com.example.backend.entity.Instrumentation;
import com.example.backend.entity.Instrumentation_param;
import com.example.backend.entity.ParamHome;
import com.example.backend.repository.InstrumentationRepository;
import com.example.backend.repository.Instrumentation_paramRepository;
import com.example.backend.services.HomePageQuerry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:8080/")
public class Controller {

    @Autowired
    private Instrumentation_paramRepository instrumentation_paramRepository;

   @GetMapping("/all")
   public List<ParamHome> fetchHomePara(){ return instrumentation_paramRepository.homeResponse() ;}
}
