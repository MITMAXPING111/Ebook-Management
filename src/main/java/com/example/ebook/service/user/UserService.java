package com.example.ebook.service.user;

import com.example.ebook.model.requestDTO.UserIdRequestDTO;
import com.example.ebook.model.requestDTO.UserRequestDTO;
import com.example.ebook.util.RestResponse;

public interface UserService {
    RestResponse findAll();

    RestResponse findById(UserIdRequestDTO userIdRequestDTO);

    RestResponse createOrUpdate(UserRequestDTO req);

    RestResponse deleteById(UserIdRequestDTO userId);
}
