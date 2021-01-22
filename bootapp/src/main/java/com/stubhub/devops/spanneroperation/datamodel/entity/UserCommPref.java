package com.stubhub.devops.spanneroperation.datamodel.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author: Longgui Wang
 * @Date: 2021/1/21 10:38 AM
 */

@Entity
@Table(name = "USR_COMM_PREF")
@Data
@DynamicUpdate
public class UserCommPref {

    @Id
    @Column(name = "usr_comm_pref_id")
    private String refId;

    @Column(name = "usr_guid")
    private String userGuid;

    @Column(name = "domain_id")
    private Long domainId;

    @Column(name = "created_by")
    private String createdBy;
    
}
