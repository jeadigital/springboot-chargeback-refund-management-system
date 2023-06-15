package com.jea.payments.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jea.payments.banking.entity.Refund;

@Repository
public interface RefundRepository extends JpaRepository<Refund, Long> {
}
