package com.example.ebook.model.requestDTO;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewRequestDTO {
    private Long userId;
    private Long bookId;
    private Integer rating;
    private String comment;
}
