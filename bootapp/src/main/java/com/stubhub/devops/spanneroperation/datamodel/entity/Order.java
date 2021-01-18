package com.stubhub.devops.spanneroperation.datamodel.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.*;

/**
 * @Author: Longgui Wang
 * @Date: 2021/1/18 10:45 AM
 */

@Entity
@Table(name = "ORDERS")
@Data
@DynamicUpdate
public class Order {

    @Id
    @Column(name = "ORDER_GUID")
    private String orderGuid;

    @Column(name = "BUYER_GUID")
    private String buyerGuid;

    @Column(name = "ORDER_ID")
    private Long orderId;

    @Column(name = "ORDER_STATUS_CODE")
    private Long orderStatusCode;

}
