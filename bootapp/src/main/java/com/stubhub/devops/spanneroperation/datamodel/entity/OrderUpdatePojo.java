package com.stubhub.devops.spanneroperation.datamodel.entity;

import lombok.Data;

/**
 * @Author: Longgui Wang
 * @Date: 2021/1/18 10:45 AM
 */

@Data
public class OrderUpdatePojo {

    private Long orderId;
    private Long orderStatusCode;
}
