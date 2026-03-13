package com.porado.LogistiQ.backend.service;

import com.porado.LogistiQ.backend.model.Expense;
import com.porado.LogistiQ.backend.model.Trip;

import java.util.List;

public interface ExpenseService {
    Expense getExpense(Long id);
    List<Expense> getAllExpenses();
    Expense createExpense(Expense employee);
    Expense updateExpense(Expense employee);
    void deleteExpense(Expense employee);

    List<Expense> getByTrip(Trip trip);
}
