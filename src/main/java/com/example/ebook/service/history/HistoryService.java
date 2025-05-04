package com.example.ebook.service.history;

import java.util.List;

import com.example.ebook.model.reponseDTO.HistoryResponseDTO;
import com.example.ebook.model.requestDTO.HistoryRequestDTO;

public interface HistoryService {
    HistoryResponseDTO createHistory(HistoryRequestDTO request);

    HistoryResponseDTO getHistoryById(Long id);

    List<HistoryResponseDTO> getAllHistories();

    HistoryResponseDTO updateHistory(Long id, HistoryRequestDTO request);

    void deleteHistory(Long id);

}
