package com.porado.LogistiQ.backend.serviceImpl;

import com.porado.LogistiQ.backend.model.Expense;
import com.porado.LogistiQ.backend.model.Trip;
import com.porado.LogistiQ.backend.repository.ExpenseRepository;
import com.porado.LogistiQ.backend.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;


    @Override
    public Expense getExpense(Long id) {
        return expenseRepository
                .findById(id)
                .orElseThrow(() -> new IllegalStateException("Expense does not exist"));
    }

    @Override
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    @Override
    public Expense createExpense(Expense expense) {
        if (expense.getExpenseId() != null) throw new IllegalStateException("Cannot create a new Expense record");
        return expenseRepository.save(expense);
    }

    @Override
    public Expense updateExpense(Expense expense) {
        if (expense.getExpenseId() == null) throw new IllegalStateException("Cannot update on null ID");
        return expenseRepository.save(expense);
    }

    @Override
    public void deleteExpense(Expense expense) {
        Expense e = getExpense(expense.getExpenseId());
        expenseRepository.delete(e);
    }

    @Override
    public List<Expense> getByTrip(Trip trip) {
        return expenseRepository.findByTrip(trip);
    }
}
