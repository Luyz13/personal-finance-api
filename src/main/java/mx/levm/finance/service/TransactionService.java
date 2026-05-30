package mx.levm.finance.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.levm.finance.dto.CreateTransactionRequest;
import mx.levm.finance.entity.Bank;
import mx.levm.finance.entity.InstallmentPlan;
import mx.levm.finance.entity.Transaction;
import mx.levm.finance.repository.BankRepository;
import mx.levm.finance.repository.TransactionRepository;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final BankRepository bankRepository;

    public TransactionService(TransactionRepository transactionRepository, BankRepository bankRepository) {
        this.transactionRepository = transactionRepository;
        this.bankRepository = bankRepository;
    }

    @Transactional
    public Transaction createTransaction(CreateTransactionRequest request) {
        Transaction transaction = new Transaction();
        transaction.setConcept(request.getConcept());
        transaction.setAmount(request.getAmount());
        transaction.setExpenseDate(request.getExpenseDate());
        transaction.setYear(request.getYear());
        transaction.setTransactionType(request.getTransactionType());
        transaction.setExpenseType(request.getExpenseType());
        transaction.setPaymentMethod(request.getPaymentMethod());
        transaction.setMonth(request.getMonth());
        transaction.setBillingPeriod(request.getBillingPeriod());
        transaction.setBank(findBank(request.getBankId()));
        transaction.setInstallmentPlan(createInstallmentPlan(request));

        return transactionRepository.save(transaction);
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
