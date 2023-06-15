package com.jea.payments.banking.controller;

import lombok.RequiredArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.jea.payments.banking.entity.Refund;
import com.jea.payments.banking.service.RefundService;

import java.util.List;

@RestController
@RequestMapping("/api/refunds")
@RequiredArgsConstructor
public class RefundController {

    private final RefundService refundService;
    private static final Logger logger = LoggerFactory.getLogger(RefundController.class);
    @GetMapping
    public List<Refund> getAllRefunds() {
    	 logger.info("Fetching all refunds");
        return refundService.getAllRefunds();
    }

    @PostMapping
    public Refund createRefund(@RequestBody Refund refund) {
        return refundService.createRefund(refund);
    }

    @PutMapping("/{id}")
    public Refund updateRefund(@PathVariable Long id, @RequestBody Refund refundDetails) {
        return refundService.updateRefund(id, refundDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRefund(@PathVariable Long id) {
        refundService.deleteRefund(id);
        return ResponseEntity.noContent().build();
    }

}
