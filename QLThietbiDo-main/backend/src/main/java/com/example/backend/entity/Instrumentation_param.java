package com.example.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.mapping.List;

import javax.persistence.*;
import java.util.Date;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "INSTRUMENTATION_PARAM")
public class Instrumentation_param {
    @Id
    @Column(name = "INS_PARAM_ID",nullable = false)
    private int ins_param_id;

    @ManyToOne
    @JoinColumn(name = "INS_ID",referencedColumnName = "INS_ID")
    private Instrumentation instrumentation;

    @ManyToOne
    @JoinColumn(name = "PARAM_ID", referencedColumnName = "PARAMETER_TYPE_ID")
    private Parameter_type parameter_type;

    @Column(name = "STATUS" , nullable = false)
    private int status;

    @Column(name = "CREATED_DATE" , nullable = false)
    private Date created_date;

    @Column(name = "CREATED_USER" , nullable = false)
    private String created_user;

    @Column(name = "UPDATED_DATE")
    private Date updated_date;

    @Column(name = "UPDATE_USER")
    private String update_user;





}
