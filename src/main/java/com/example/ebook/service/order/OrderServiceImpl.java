package com.example.ebook.service.order;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.ebook.model.Book;
import com.example.ebook.model.Order;
import com.example.ebook.model.reponseDTO.OrderResponseDTO;
import com.example.ebook.model.requestDTO.OrderRequestDTO;
import com.example.ebook.repository.BookRepository;
import com.example.ebook.repository.OrderRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final BookRepository bookRepository;

    @Override
    public OrderResponseDTO createOrder(OrderRequestDTO request) {
        Book book = bookRepository.findById(request.getBookId())
                .orElseThrow(() -> new EntityNotFoundException("Book not found with id: " + request.getBookId()));

        Order order = new Order();
        order.setUserId(request.getUserId());
        order.setBook(book);
        order.setQuantity(request.getQuantity());
        order.setTotalPrice(book.getPrice().multiply(BigDecimal.valueOf(request.getQuantity())));
        order.setOrderDate(LocalDateTime.now());
        order.setStatus(request.getStatus() != null ? request.getStatus() : "PENDING");

        Order saved = orderRepository.save(order);
        return mapToResponse(saved);
    }

    @Override
    public List<OrderResponseDTO> getAllOrders() {
        return orderRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public OrderResponseDTO getOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Order not found with id: " + id));
        return mapToResponse(order);
    }

    @Override
    public OrderResponseDTO updateOrder(Long id, OrderRequestDTO request) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Order not found with id: " + id));

        Book book = bookRepository.findById(request.getBookId())
                .orElseThrow(() -> new EntityNotFoundException("Book not found with id: " + request.getBookId()));

        order.setUserId(request.getUserId());
        order.setBook(book);
        order.setQuantity(request.getQuantity());
        order.setTotalPrice(book.getPrice().multiply(BigDecimal.valueOf(request.getQuantity())));
        order.setStatus(request.getStatus());

        Order updated = orderRepository.save(order);
        return mapToResponse(updated);
    }

    @Override
    public void deleteOrder(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Order not found with id: " + id));
        orderRepository.delete(order);
    }

    private OrderResponseDTO mapToResponse(Order order) {
        OrderResponseDTO response = new OrderResponseDTO();
        response.setId(order.getId());
        response.setUserId(order.getUserId());
        response.setBookId(order.getBook().getId());
        response.setQuantity(order.getQuantity());
        response.setTotalPrice(order.getTotalPrice());
        response.setOrderDate(order.getOrderDate());
        response.setStatus(order.getStatus());
        return response;
    }
}
