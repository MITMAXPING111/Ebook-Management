package com.example.ebook.service.role;

import com.example.ebook.model.requestDTO.RoleIdRequestDTO;
import com.example.ebook.model.requestDTO.RoleRequestDTO;
import com.example.ebook.util.RestResponse;

public interface RoleService {
    RestResponse findAll();

    RestResponse findById(RoleIdRequestDTO roleIdRequestDTO);

    RestResponse createOrUpdate(RoleRequestDTO req);

    RestResponse deleteById(RoleIdRequestDTO roleIdRequestDTO);
}
