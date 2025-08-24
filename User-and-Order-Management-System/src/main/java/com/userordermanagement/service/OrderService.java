package com.userordermanagement.service;

import com.userordermanagement.dto.OrderDTO;
import com.userordermanagement.dto.UserDTO;
import com.userordermanagement.entity.Order;
import com.userordermanagement.entity.User;
import com.userordermanagement.exception.OrderNotFoundException;
import com.userordermanagement.exception.UserNotFoundException;
import com.userordermanagement.mapper.OrderMapper;
import com.userordermanagement.repository.OrderRepository;
import com.userordermanagement.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderService {
    public OrderRepository orderRepository;
    public UserRepository userRepository;

    // Create new order
    public OrderDTO createOrder(OrderDTO orderDTO){
        User user = userRepository.findById(orderDTO.getUserId()).orElseThrow(() -> new UserNotFoundException("User with ID: " + orderDTO.getUserId() + " not found"));

        if (orderDTO.getOrderDate()!=null){
            orderDTO.setOrderDate(LocalDateTime.now());
        }

        Order order = OrderMapper.toOrderEntity(orderDTO,user);
        order = orderRepository.save(order);
        return OrderMapper.toOrderDTO(order);
    }

    // Get all orders
    public List<OrderDTO> getAllOrders(){
        List<Order> orders = orderRepository.findAll();
        return orders.stream().map(OrderMapper::toOrderDTO).collect(Collectors.toList());
    }

    // Get order by orderId
    public OrderDTO getOrderById(Long id){
        Order order = orderRepository.findById(id).orElseThrow(() -> new OrderNotFoundException("Order with ID: " + id + " not found"));
        return OrderMapper.toOrderDTO(order);
    }

    // Get order by userId
    public List<OrderDTO> getOrdersByUserId(Long userId){
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User with ID: " + userId + " not found"));
        List<Order> orders = orderRepository.findByUser(user);
        return orders.stream().map(OrderMapper::toOrderDTO).collect(Collectors.toList());
    }

    // Update order
    public OrderDTO updateOrder(Long id, OrderDTO orderDTO) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new OrderNotFoundException("Order with id: " + id + " not found"));
        User user = userRepository.findById(orderDTO.getUserId()).orElseThrow(() -> new UserNotFoundException("User with id: " + orderDTO.getUserId() + " not found"));

        order.setProduct(orderDTO.getProduct());
        order.setQuantity(orderDTO.getQuantity());
        order.setPrice(orderDTO.getPrice());
        order.setOrderDate(orderDTO.getOrderDate());
        order.setUser(user);

        order = orderRepository.save(order);
        return OrderMapper.toOrderDTO(order);
    }

    // Delete order
    public String deleteOrder(Long id) {
        orderRepository.deleteById(id);
        return "Order with id: " + id + " has been deleted successfully";
    }
}
