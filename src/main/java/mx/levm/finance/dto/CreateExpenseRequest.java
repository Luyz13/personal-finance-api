package mx.levm.finance.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.levm.finance.enums.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateExpenseRequest {

    @NotBlank
    private String concept;

    @NotNull
    @Positive
    private BigDecimal amount;

    @NotNull
    private LocalDate expenseDate;

    @NotNull
    private Integer year;

    @NotNull
    private ExpenseType expenseType;

    @NotNull
    private PaymentMethod paymentMethod;

    @NotNull
    private Month month;

    private BillingPeriod billingPeriod;

    private Long bankId;

    // Installments (optional)
    private InstallmentType installmentType;
    private Integer totalMonths;
    private Integer currentInstallment;
    private BigDecimal partialAmount;
    private BigDecimal interest;
}