package com.example.ebook.model.reponseDTO;

import lombok.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HistoryResponseDTO {
    private Long id;
    private Long userId;
    private Long bookId;
    private Float progress;
    private LocalDateTime lastReadAt;

}
