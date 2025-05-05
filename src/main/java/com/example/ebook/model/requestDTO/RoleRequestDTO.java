package com.example.ebook.model.requestDTO;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import com.example.ebook.constants.RoleEnum;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleRequestDTO {
    private Integer id;
    @Enumerated(EnumType.STRING)
    private RoleEnum name;
    private Set<PermissionIdRequetsDTO> permissionIdRequetsDTOs = new HashSet<>();
    private String createBy;
    private LocalDateTime createAt;
    private String updateBy;
    private LocalDateTime updateAt;
}
