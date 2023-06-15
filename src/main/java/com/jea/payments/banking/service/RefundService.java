package com.jea.payments.banking.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.jea.payments.banking.entity.Refund;
import com.jea.payments.banking.repository.RefundRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RefundService {

    private final RefundRepository refundRepository;

    public List<Refund> getAllRefunds() {
        return refundRepository.findAll();
    }

    public Refund createRefund(Refund refund) {
        return refundRepository.save(refund);
    }

    public Refund updateRefund(Long id, Refund refundDetails) {
        Refund refund = refundRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Refund not found"));
        refund.setAmount(refundDetails.getAmount());
        refund.setReason(refundDetails.getReason());
        refund.setStatus(refundDetails.getStatus());
        return refundRepository.save(refund);
    }

    public void deleteRefund(Long id) {
        refundRepository.deleteById(id);
    }
}
