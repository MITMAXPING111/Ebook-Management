package com.example.ebook.service.message;

import java.util.List;

import com.example.ebook.model.reponseDTO.MessageResponseDTO;
import com.example.ebook.model.requestDTO.MessageRequestDTO;

public interface MessageService {
    MessageResponseDTO sendMessage(MessageRequestDTO request);

    MessageResponseDTO getMessageById(Long id);

    List<MessageResponseDTO> getAllMessages();

    MessageResponseDTO updateMessage(Long id, MessageRequestDTO request);

    void deleteMessage(Long id);

}
