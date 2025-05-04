package com.example.ebook.model.requestDTO;

import java.time.LocalDateTime;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HistoryRequestDTO {
    private Long userId;
    private Long bookId;
    private Float progress;
    private LocalDateTime lastReadAt;
}
