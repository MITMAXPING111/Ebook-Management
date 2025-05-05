package com.example.ebook.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ebook.model.reponseDTO.HistoryResponseDTO;
import com.example.ebook.model.requestDTO.HistoryRequestDTO;
import com.example.ebook.service.history.HistoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/histories")
@RequiredArgsConstructor
public class HistoryController {
    private final HistoryService historyService;

    @PostMapping
    public ResponseEntity<HistoryResponseDTO> create(@RequestBody HistoryRequestDTO request) {
        return ResponseEntity.ok(historyService.createHistory(request));
    }

    @GetMapping
    public ResponseEntity<List<HistoryResponseDTO>> getAll() {
        return ResponseEntity.ok(historyService.getAllHistories());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistoryResponseDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(historyService.getHistoryById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<HistoryResponseDTO> update(@PathVariable Long id, @RequestBody HistoryRequestDTO request) {
        return ResponseEntity.ok(historyService.updateHistory(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        historyService.deleteHistory(id);
        return ResponseEntity.noContent().build();
    }
}
