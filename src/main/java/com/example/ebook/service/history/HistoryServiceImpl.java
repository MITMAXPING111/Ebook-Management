package com.example.ebook.service.history;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.ebook.model.Book;
import com.example.ebook.model.History;
import com.example.ebook.model.reponseDTO.HistoryResponseDTO;
import com.example.ebook.model.requestDTO.HistoryRequestDTO;
import com.example.ebook.repository.BookRepository;
import com.example.ebook.repository.HistoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HistoryServiceImpl implements HistoryService {
    private final HistoryRepository historyRepository;
    private final BookRepository bookRepository;

    @Override
    public HistoryResponseDTO createHistory(HistoryRequestDTO request) {
        Book book = bookRepository.findById(request.getBookId())
                .orElseThrow(() -> new RuntimeException("Book not found"));

        History history = History.builder()
                .userId(request.getUserId())
                .book(book)
                .progress(request.getProgress())
                .lastReadAt(request.getLastReadAt())
                .build();

        return mapToDTO(historyRepository.save(history));
    }

    @Override
    public HistoryResponseDTO getHistoryById(Long id) {
        History history = historyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("History not found"));
        return mapToDTO(history);
    }

    @Override
    public List<HistoryResponseDTO> getAllHistories() {
        return historyRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public HistoryResponseDTO updateHistory(Long id, HistoryRequestDTO request) {
        History history = historyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("History not found"));

        Book book = bookRepository.findById(request.getBookId())
                .orElseThrow(() -> new RuntimeException("Book not found"));

        history.setUserId(request.getUserId());
        history.setBook(book);
        history.setProgress(request.getProgress());
        history.setLastReadAt(request.getLastReadAt());

        return mapToDTO(historyRepository.save(history));
    }

    @Override
    public void deleteHistory(Long id) {
        historyRepository.deleteById(id);
    }

    private HistoryResponseDTO mapToDTO(History history) {
        HistoryResponseDTO dto = new HistoryResponseDTO();
        dto.setId(history.getId());
        dto.setUserId(history.getUserId());
        dto.setBookId(history.getBook().getId());
        dto.setProgress(history.getProgress());
        dto.setLastReadAt(history.getLastReadAt());
        return dto;
    }

}
