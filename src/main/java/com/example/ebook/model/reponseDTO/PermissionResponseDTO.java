package com.example.ebook.model.reponseDTO;

import java.time.LocalDateTime;

import com.example.ebook.constants.PermissionEnum;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PermissionResponseDTO {
    private Integer id;
    private PermissionEnum name;
    private String createBy;
    private LocalDateTime createAt;
    private String updateBy;
    private LocalDateTime updateAt;
}
