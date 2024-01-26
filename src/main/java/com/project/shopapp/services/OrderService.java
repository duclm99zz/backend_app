package com.project.shopapp.services;

import com.project.shopapp.dtos.OrderDTO;
import com.project.shopapp.exceptions.DataNotFoundException;
import com.project.shopapp.models.Order;
import com.project.shopapp.models.OrderStatus;
import com.project.shopapp.models.User;
import com.project.shopapp.repositories.OrderRepository;
import com.project.shopapp.repositories.UserRepository;
import com.project.shopapp.responses.OrderResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService implements IOrderService {

    private final UserRepository userRepository;
    private final OrderRepository orderRepository;
//    private final ModelMapper modelMapper;
public OrderResponse createOrder(OrderDTO orderDto) throws Exception {
    return null;
}

//    @Override
//    public OrderResponse createOrder(OrderDTO orderDto) throws Exception {
//        // check if user's id is existing
//        User user = userRepository
//                .findById(orderDto.getUserId())
//                .orElseThrow(() -> new DataNotFoundException("Can not find user with id " + orderDto.getUserId()));
//
//        //  ---------- convert orderDTO -> order -----------
//        // 1. Tạo một luồng ánh xạ riêng để kiểm soát việc ánh xạ
//        modelMapper.typeMap(OrderDTO.class, Order.class)
//                .addMappings(mapper -> mapper.skip(Order::setId));
//
//        // 2.Cập nhật các truờng của đơn hàng từ orderDTO
//        Order order = new Order();
//        modelMapper.map(orderDto, order);
//        order.setUser(user);
//        order.setOrderDate(new Date());
//        order.setStatus(OrderStatus.PENDING);
//
//        // Check shipping date
//        LocalDate shippingDate = orderDto.getShippingDate() == null ? LocalDate.now() : orderDto.getShippingDate();
//        if (shippingDate.isBefore(LocalDate.now())) {
//            throw new DataNotFoundException("Date must be at least today!");
//        }
//        order.setShippingDate(shippingDate);
//        order.setIsActive(true);
//        orderRepository.save(order);
//
//        return modelMapper.map(order, OrderResponse.class);
//    }

    @Override
    public OrderResponse getOrder(Long id) {
        return null;
    }

    @Override
    public OrderResponse updateOrder(Long id, OrderDTO orderDto) {
        return null;
    }

    @Override
    public void deleteOrder(Long id) {

    }

    @Override
    public List<OrderResponse> getAllOrders(Long userID) {

        return null;
    }
}
