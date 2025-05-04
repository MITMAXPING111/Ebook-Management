package com.example.ebook.model.requestDTO;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderRequestDTO {
    private Long userId;
    private Long bookId;
    private Integer quantity;
    private String status;
}
