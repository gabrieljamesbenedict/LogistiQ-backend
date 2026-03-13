package com.porado.LogistiQ.backend.controller;

import com.porado.LogistiQ.backend.model.Expense;
import com.porado.LogistiQ.backend.model.Trip;
import com.porado.LogistiQ.backend.repository.ExpenseRepository;
import com.porado.LogistiQ.backend.repository.TripRepository;
import com.porado.LogistiQ.backend.service.ExpenseService;
import com.porado.LogistiQ.backend.service.TripService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
@RequiredArgsConstructor
public class ExpenseController {

    private final ExpenseService expenseService;
//    private final TripService tripService;

    @GetMapping("/{id}")
    public ResponseEntity<Expense> getExpense(@PathVariable Long id) {
        return ResponseEntity.ok(expenseService.getExpense(id));
    }

    @GetMapping
    public ResponseEntity<List<Expense>> getAllExpenses() {
        return ResponseEntity.ok(expenseService.getAllExpenses());
    }

    @PostMapping
    public ResponseEntity<Expense> createExpense(@RequestBody Expense expense) {
        return ResponseEntity.ok(expenseService.createExpense(expense));
    }

    @PutMapping
    public ResponseEntity<Expense> updateExpense(@RequestBody Expense expense) {
        return ResponseEntity.ok(expenseService.updateExpense(expense));
    }

    @DeleteMapping
    public void deleteExpense(@RequestBody Expense expense) {
        expenseService.deleteExpense(expense);
    }

//    @GetMapping
//    public List<Expense> getAllExpenses() {
//        return expenseService.get();
//    }
//
//    @PostMapping
//    public ResponseEntity<Expense> addExpense(@RequestParam Long tripId, @RequestBody Expense expense) {
//        Trip trip = tripRepository.findById(tripId)
//                .orElseThrow(() -> new IllegalArgumentException("Trip not found"));
//        expense.setTrip(trip);
//        Expense saved = expenseRepository.save(expense);
//        return ResponseEntity.ok(saved);
//    }
//
//    @GetMapping("/trip/{tripId}")
//    public ResponseEntity<List<Expense>> getExpensesForTrip(@PathVariable Long tripId) {
//        Trip trip = tripRepository.findById(tripId)
//                .orElseThrow(() -> new IllegalArgumentException("Trip not found"));
//        List<Expense> expenses = expenseRepository.findByTrip(trip);
//        return ResponseEntity.ok(expenses);
//    }
}

