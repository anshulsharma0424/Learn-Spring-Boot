package com.userordermanagement.mapper;

import com.userordermanagement.dto.OrderDTO;
import com.userordermanagement.entity.Order;
import com.userordermanagement.entity.User;

public class OrderMapper {
    // Convert OrderDTO to Order Entity
    public static Order toOrderEntity(OrderDTO orderDTO, User user) {
        if (orderDTO == null) return null;

        Order order = new Order();

        order.setId(orderDTO.getId());
        order.setProduct(orderDTO.getProduct());
        order.setQuantity(orderDTO.getQuantity());
        order.setPrice(orderDTO.getPrice());
        order.setOrderDate(orderDTO.getOrderDate());
        order.setUser(user);

        return order;
    }

    // Convert Order Entity to OrderDTO
    public static OrderDTO toOrderDTO(Order order) {
        if (order == null) return null;
        OrderDTO orderDTO = new OrderDTO();
        return new OrderDTO(
          order.getId(),
          order.getProduct(),
          order.getQuantity(),
          order.getPrice(),
          order.getOrderDate(),
          order.getUser() != null ? order.getUser().getId() : null
        );
    }
}
