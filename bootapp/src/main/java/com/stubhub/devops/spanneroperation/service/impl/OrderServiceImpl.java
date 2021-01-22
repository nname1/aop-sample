package com.stubhub.devops.spanneroperation.service.impl;

import com.stubhub.devops.spanneroperation.datamodel.entity.Order;
import com.stubhub.devops.spanneroperation.datamodel.repository.order.OrderRepository;
import com.stubhub.devops.spanneroperation.service.intf.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Longgui Wang
 * @Date: 2021/1/18 10:45 AM
 */

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void updateOrderStatus(Long orderId, Long statusCode) {
        Order order = getOrderById(orderId);
        order.setOrderStatusCode(statusCode);
        orderRepository.save(order);
    }

    @Override
    public Order getOrderById(Long orderId) {
        System.out.println(orderId);
        return orderRepository.findByOrderId(orderId);
    }
}
