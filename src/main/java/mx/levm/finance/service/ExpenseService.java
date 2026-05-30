package mx.levm.finance.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.levm.finance.dto.CreateTransactionRequest;
import mx.levm.finance.entity.Bank;
import mx.levm.finance.entity.InstallmentPlan;
import mx.levm.finance.entity.Transaction;
import mx.levm.finance.enums.TransactionType;
import mx.levm.finance.repository.BankRepository;
import mx.levm.finance.repository.TransactionRepository;

@Service
public class ExpenseService {

    private final TransactionRepository transactionRepository;
    private final BankRepository bankRepository;

    public ExpenseService(TransactionRepository transactionRepository, BankRepository bankRepository) {
        this.transactionRepository = transactionRepository;
        this.bankRepository = bankRepository;
    }

    @Transactional
    public Transaction createExpense(CreateTransactionRequest request) {
        Transaction expense = new Transaction();
        expense.setConcept(request.getConcept());
        expense.setAmount(request.getAmount());
        expense.setExpenseDate(request.getExpenseDate());
        expense.setYear(request.getYear());
        expense.setTransactionType(TransactionType.EXPENSE);
        expense.setExpenseType(request.getExpenseType());
        expense.setPaymentMethod(request.getPaymentMethod());
        expense.setMonth(request.getMonth());
        expense.setBillingPeriod(request.getBillingPeriod());
        expense.setBank(findBank(request.getBankId()));
        expense.setInstallmentPlan(createInstallmentPlan(request));

        return transactionRepository.save(expense);
    }

    private Bank findBank(Long bankId) {
        if (bankId == null) {
            return null;
        }

        return bankRepository.findById(bankId)
                .orElseThrow(() -> new IllegalArgumentException("No existe el banco con id: " + bankId));
    }

    private InstallmentPlan createInstallmentPlan(CreateTransactionRequest request) {
        if (request.getInstallmentType() == null) {
            return null;
        }

        InstallmentPlan installmentPlan = new InstallmentPlan();
        installmentPlan.setInstallmentType(request.getInstallmentType());
        installmentPlan.setTotalMonths(request.getTotalMonths());
        installmentPlan.setCurrentInstallment(request.getCurrentInstallment());
        installmentPlan.setPartialAmount(request.getPartialAmount());
        installmentPlan.setInterest(request.getInterest());
        return installmentPlan;
    }
}
