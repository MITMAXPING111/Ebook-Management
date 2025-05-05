package com.example.ebook.model.requestDTO;

import java.time.LocalDateTime;

import com.example.ebook.constants.PermissionEnum;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PermissionRequetsDTO {
    private Integer id;
    @Enumerated(EnumType.STRING)
    private PermissionEnum name;
    private String createBy;
    private LocalDateTime createAt;
    private String updateBy;
    private LocalDateTime updateAt;
}
