package com.example.ebook.model.reponseDTO;

import lombok.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewResponseDTO {
    private Long id;
    private Long userId;
    private Long bookId;
    private Integer rating;
    private String comment;
    private LocalDateTime reviewDate;
}
