package com.example.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ParamHome {
    private String ins_name;
    private int ins_id;
    private String parameter_type_name;
    private String manufact;
    private String ins_model;
    private int status;

}
