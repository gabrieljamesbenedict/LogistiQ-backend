package com.porado.LogistiQ.backend.controller;

import com.porado.LogistiQ.backend.model.Expense;
import com.porado.LogistiQ.backend.model.Trip;
import com.porado.LogistiQ.backend.repository.ExpenseRepository;
import com.porado.LogistiQ.backend.repository.TripRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
@CrossOrigin(origins = "http://localhost:3000")
public class ExpenseController {

    private final ExpenseRepository expenseRepository;
    private final TripRepository tripRepository;

    public ExpenseController(ExpenseRepository expenseRepository, TripRepository tripRepository) {
        this.expenseRepository = expenseRepository;
        this.tripRepository = tripRepository;
    }

    @GetMapping
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Expense> addExpense(@RequestParam Long tripId, @RequestBody Expense expense) {
        Trip trip = tripRepository.findById(tripId)
                .orElseThrow(() -> new IllegalArgumentException("Trip not found"));
        expense.setTrip(trip);
        Expense saved = expenseRepository.save(expense);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/trip/{tripId}")
    public ResponseEntity<List<Expense>> getExpensesForTrip(@PathVariable Long tripId) {
        Trip trip = tripRepository.findById(tripId)
                .orElseThrow(() -> new IllegalArgumentException("Trip not found"));
        List<Expense> expenses = expenseRepository.findByTrip(trip);
        return ResponseEntity.ok(expenses);
    }
}

