package com.porado.LogistiQ.backend.repository;

import com.porado.LogistiQ.backend.model.Expense;
import com.porado.LogistiQ.backend.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findByTrip(Trip trip);
}

