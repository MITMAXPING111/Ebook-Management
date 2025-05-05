package com.example.ebook.service.permission;

import com.example.ebook.model.requestDTO.PermissionIdRequetsDTO;
import com.example.ebook.model.requestDTO.PermissionRequetsDTO;
import com.example.ebook.util.RestResponse;

public interface PermissionService {
    RestResponse findAll();

    RestResponse findById(PermissionIdRequetsDTO permissionId);

    RestResponse createOrUpdate(PermissionRequetsDTO req);

    RestResponse deleteById(PermissionIdRequetsDTO permissionId);
}
