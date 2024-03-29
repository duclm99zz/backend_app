package com.project.shopapp.services;

import com.project.shopapp.dtos.OrderDTO;
import com.project.shopapp.responses.OrderResponse;

import java.util.List;

public interface IOrderService {
    OrderResponse createOrder(OrderDTO orderDto) throws Exception;

    OrderResponse getOrder(Long id);

    OrderResponse updateOrder(Long id, OrderDTO orderDto);

    void deleteOrder(Long id);

    List<OrderResponse> getAllOrders(Long userID);
}
