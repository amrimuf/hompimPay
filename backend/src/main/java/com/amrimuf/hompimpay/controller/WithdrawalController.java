package com.amrimuf.hompimpay.controller;

import com.amrimuf.hompimpay.dto.WithdrawalRequest;
import com.amrimuf.hompimpay.dto.WithdrawalResponse;
import com.amrimuf.hompimpay.service.WithdrawalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/withdrawals")
@Validated
public class WithdrawalController {

    @Autowired
    private WithdrawalService withdrawalService;

    @PostMapping
    public ResponseEntity<WithdrawalResponse> createWithdrawal(@Valid @RequestBody WithdrawalRequest request) {
        WithdrawalResponse response = withdrawalService.createWithdrawal(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public List<WithdrawalResponse> getAllWithdrawals() {
        return withdrawalService.getAllWithdrawals();
    }

    @GetMapping("/{id}")
    public ResponseEntity<WithdrawalResponse> getWithdrawalById(@PathVariable Long id) {
        WithdrawalResponse response = withdrawalService.getWithdrawalById(id);
        if (response != null) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<WithdrawalResponse> updateWithdrawal(@PathVariable Long id, @RequestBody WithdrawalRequest request) {
        WithdrawalResponse updatedWithdrawal = withdrawalService.updateWithdrawal(id, request);
        if (updatedWithdrawal != null) {
            return ResponseEntity.ok(updatedWithdrawal);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWithdrawal(@PathVariable Long id) {
        withdrawalService.deleteWithdrawal(id);
        return ResponseEntity.noContent().build();
    }
}
