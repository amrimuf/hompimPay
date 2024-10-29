package com.amrimuf.hompimpay.service;

import com.amrimuf.hompimpay.dto.WithdrawalRequest;
import com.amrimuf.hompimpay.dto.WithdrawalResponse;
import com.amrimuf.hompimpay.model.Withdrawal;
import com.amrimuf.hompimpay.repository.WithdrawalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WithdrawalService {

    @Autowired
    private WithdrawalRepository withdrawalRepository;

    public WithdrawalResponse createWithdrawal(WithdrawalRequest request) {
        Withdrawal withdrawal = new Withdrawal(request.getAmount(), request.getAccountNumber());
        Withdrawal savedWithdrawal = withdrawalRepository.save(withdrawal);
        return toResponse(savedWithdrawal);
    }

    public List<WithdrawalResponse> getAllWithdrawals() {
        return withdrawalRepository.findAll().stream()
            .map(this::toResponse)
            .collect(Collectors.toList());
    }

    public WithdrawalResponse getWithdrawalById(Long id) {
        Optional<Withdrawal> withdrawal = withdrawalRepository.findById(id);
        return withdrawal.map(this::toResponse).orElse(null);
    }

    public WithdrawalResponse updateWithdrawal(Long id, WithdrawalRequest request) {
        Optional<Withdrawal> existingWithdrawal = withdrawalRepository.findById(id);
        if (existingWithdrawal.isPresent()) {
            Withdrawal withdrawal = existingWithdrawal.get();
            withdrawal.setAmount(request.getAmount());
            withdrawal.setAccountNumber(request.getAccountNumber());
            Withdrawal updatedWithdrawal = withdrawalRepository.save(withdrawal);
            return toResponse(updatedWithdrawal);
        }
        return null;
    }

    public void deleteWithdrawal(Long id) {
        withdrawalRepository.deleteById(id);
    }

    private WithdrawalResponse toResponse(Withdrawal withdrawal) {
        return new WithdrawalResponse(
            withdrawal.getId(),
            withdrawal.getAmount(),
            withdrawal.getAccountNumber(),
            withdrawal.getCreatedAt()
        );
    }
}
