package com.example.ebook.service.order;

import java.util.List;

import com.example.ebook.model.reponseDTO.OrderResponseDTO;
import com.example.ebook.model.requestDTO.OrderRequestDTO;

public interface OrderService {
    OrderResponseDTO createOrder(OrderRequestDTO request);

    OrderResponseDTO getOrderById(Long id);

    List<OrderResponseDTO> getAllOrders();

    OrderResponseDTO updateOrder(Long id, OrderRequestDTO request);

    void deleteOrder(Long id);

}
