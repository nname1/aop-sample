package com.stubhub.devops.spanneroperation.service.intf;

import com.stubhub.devops.spanneroperation.datamodel.entity.Order;

/**
 * @Author: Longgui Wang
 * @Date: 2021/1/18 10:45 AM
 */

public interface OrderService {

    public void updateOrderStatus(Long orderId,Long statusCode);

    public Order getOrderById(Long orderId);
}
