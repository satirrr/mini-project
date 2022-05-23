package com.personal.miniproject.controller;

import com.personal.miniproject.entity.LendingHistory;
import com.personal.miniproject.service.LendingHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LendingHistoryController {
    private final LendingHistoryService lendingHistoryService;

    @PostMapping("/lending")
    public ResponseEntity<LendingHistory> insertLendingHistory(@RequestBody LendingHistory lendingHistory){
        LendingHistory lendingHistoryResponse = lendingHistoryService.insertLendingHistory(lendingHistory);
        return ResponseEntity.status(HttpStatus.CREATED).body(lendingHistoryResponse);
    }
}
