package com.stubhub.devops.spanneroperation.controller;

import com.stubhub.devops.spanneroperation.datamodel.entity.Order;
import com.stubhub.devops.spanneroperation.datamodel.entity.OrderUpdatePojo;
import com.stubhub.devops.spanneroperation.service.intf.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import static org.springframework.http.HttpStatus.OK;

/**
 * @Author: Longgui Wang
 * @Date: 2021/1/18 10:45 AM
 */

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/order/get", method = RequestMethod.GET)
    @ResponseStatus(OK)
    @ResponseBody
    public Order getOrder(@RequestParam("orderId") String orderId){
        try {
            Long id = Long.valueOf(orderId);
            Order order = orderService.getOrderById(id);
            return order;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value = "/order/update", headers="Content-Type=application/json", method = RequestMethod.PUT)
    @ResponseStatus(OK)
    @ResponseBody
    public int getOrder(@RequestBody OrderUpdatePojo orderUpdatePojo){
        try {
            Long id = Long.valueOf(orderUpdatePojo.getOrderId());
            Long statusCode = Long.valueOf(orderUpdatePojo.getOrderStatusCode());
            orderService.updateOrderStatus(id,statusCode);
            return 1;
        } catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

}
