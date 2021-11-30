package com.example.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "PARAMETER_TYPE")
public class Parameter_type {
    @Id
    @Column(name = "PARAMETER_TYPE_ID",nullable = false)
    private int parameter_type_id;

    @Column(name = "PARAMETER_TYPE_NAME")
    private String parameter_type_name;

    @Column(name = "PARAMETER_TYPE_DESCRIPTION")
    private String parameter_type_description;

    @Column(name = "UNIT_ID")
    private int unit_id;

    @Column(name = "PARAMETER_TYPE_CODE")
    private String parameter_type_code;

    @Column(name = "CUSTOM_POSITION_ID")
    private int custom_position_id;

    @Column(name = "FEATURES")
    private String features;

    @Column(name = "METEOR_POSITION_ID")
    private int meteor_position_id;

    @OneToMany(mappedBy = "parameter_type", cascade = CascadeType.ALL)
    private Collection<Instrumentation_param> instrumentation_params;
}
