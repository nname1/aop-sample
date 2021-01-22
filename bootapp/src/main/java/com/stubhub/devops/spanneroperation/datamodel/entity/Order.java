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
    @Column(name = "order_guid")
    private String orderGuid;

    @Column(name = "buyer_guid")
    private String buyerGuid;

    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "order_status_code")
    private Long orderStatusCode;

}
