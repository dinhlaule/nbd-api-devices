package com.example.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.awt.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "INSTRUMENTATIONS")
public class Instrumentation {
    @Id
    @Column(name = "INS_ID",nullable = false)
    private int ins_id;

    @Column(name = "INS_NAME", nullable = false)
    private String ins_name;

    @Column(name = "INS_CODE",nullable = false)
    private String ins_code;

    @Column(name = "MANUFACT",nullable = false)
    private String manufact;

    @Column(name = "INS_MODEL",nullable = false)
    private String ins_model;

    @Column(name = "CREATED_DATE",nullable = false)
    private Date created_date;

    @Column(name = "CREATED_USER",nullable = false)
    private String created_user;

    @Column(name = "UPDATED_DATE",nullable = true)
    private Date updated_date;

    @Column(name = "UPDATED_USER")
    private String updated_user;

    @Column(name = "STATUS",nullable = false)
    private int status;

    @Column(name = "IS_CONTROL_ENABLE")
    private int is_control_enable;

    @Column(name = "IS_OBSERVABLE")
    private int is_observable;

    @OneToMany(mappedBy = "instrumentation", cascade = CascadeType.ALL)
    private Collection<Instrumentation_param> instrumentation_param;

}
