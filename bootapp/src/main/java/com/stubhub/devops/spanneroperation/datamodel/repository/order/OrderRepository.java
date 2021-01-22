package com.stubhub.devops.spanneroperation.datamodel.repository.order;

import com.stubhub.devops.spanneroperation.datamodel.entity.Order;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author: Longgui Wang
 * @Date: 2021/1/18 10:45 AM
 */

@Repository
public interface OrderRepository extends CrudRepository<Order,Long> {

    @Query(value = "select o.order_guid,o.buyer_guid,o.order_id,o.order_status_code from orders o where o.order_id=:orderId",
            nativeQuery = true)
    Order findByOrderId(@Param("orderId") Long orderId);

    @Modifying
    @Query(value = "update Order o set " +
            "o.orderStatusCode = :#{#order.orderStatusCode} " +
            "where o.orderId = :#{#order.orderId}")
    int update(@Param(value = "order") Order order);
}
