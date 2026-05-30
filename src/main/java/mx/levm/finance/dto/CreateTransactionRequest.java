package mx.levm.finance.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.levm.finance.enums.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateTransactionRequest {

    @NotBlank(message = "El concepto es obligatorio")
    @Size(max = 150)
    private String concept;

    @NotNull(message = "El monto es obligatorio")
    private BigDecimal amount;

    @NotNull(message = "La fecha de gasto es obligatoria")
    private LocalDate expenseDate;

    @NotNull(message = "El año es obligatorio")
    @Positive(message = "El año debe ser un valor positivo")
    private Integer year;

    @NotNull(message = "El tipo de transacción es obligatorio")
    private TransactionType transactionType;

    private ExpenseType expenseType;

    @NotNull(message = "El método de pago es obligatorio")
    private PaymentMethod paymentMethod;

    @NotNull(message = "El mes es obligatorio")
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