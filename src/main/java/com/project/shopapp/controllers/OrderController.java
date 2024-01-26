package com.project.shopapp.controllers;

import com.project.shopapp.dtos.OrderDTO;
import com.project.shopapp.responses.OrderResponse;
import com.project.shopapp.services.OrderService;
import com.project.shopapp.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final UserService userService;

    // CREATE AN ORDER
    @PostMapping("")
    public ResponseEntity<?> createOrder(@Valid @RequestBody OrderDTO orderDto, BindingResult result) {
        // BindingResult là nơi Spring chứa kết quả của việc xác thực dữ liệu
        try {
            if (result.hasErrors()) {
                List<String> errorMessage = result.getFieldErrors().stream().map(FieldError::getDefaultMessage).toList();
                return ResponseEntity.badRequest().body(errorMessage);
            }

            OrderResponse orderResponse = orderService.createOrder(orderDto);
            return ResponseEntity.ok(orderResponse);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // GET ORDERS BY USER_ID
    @GetMapping("/users/{user_id}")
    public ResponseEntity<?> getAllOrders(@Valid @PathVariable("user_id")  Long userId) {

        try {
            orderService.getAllOrders(userId);
            return ResponseEntity.ok().body("Get Order Successful");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // UPDATE AN ORDER
    @PutMapping("/{id}")
    public ResponseEntity<String> updateOrder (@Valid @PathVariable("id") Long orderId ) {
        return ResponseEntity.ok().body("Update an order successful");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrder (@Valid @PathVariable("id") Long orderId ) {
        return ResponseEntity.ok().body("Delete an order successful");
    }
}
