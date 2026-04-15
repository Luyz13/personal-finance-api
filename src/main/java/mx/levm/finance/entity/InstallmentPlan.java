package mx.levm.finance.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import mx.levm.finance.enums.InstallmentType;

@Entity
@Table(name = "installment_plans")
public class InstallmentPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "installment_type", nullable = false, length = 30)
    private InstallmentType installmentType;

    @Column(name = "total_months", nullable = false)
    private Integer totalMonths;

    @Column(name = "current_installment", nullable = false)
    private Integer currentInstallment;

    @Column(name = "partial_amount", nullable = false, precision = 12, scale = 2)
    private BigDecimal partialAmount;

    @Column(name = "interest", precision = 12, scale = 2)
    private BigDecimal interest;

    public InstallmentPlan() {
    }

    public Long getId() {
        return id;
    }

    public InstallmentType getInstallmentType() {
        return installmentType;
    }

    public void setInstallmentType(InstallmentType installmentType) {
        this.installmentType = installmentType;
    }

    public Integer getTotalMonths() {
        return totalMonths;
    }

    public void setTotalMonths(Integer totalMonths) {
        this.totalMonths = totalMonths;
    }

    public Integer getCurrentInstallment() {
        return currentInstallment;
    }

    public void setCurrentInstallment(Integer currentInstallment) {
        this.currentInstallment = currentInstallment;
    }

    public BigDecimal getPartialAmount() {
        return partialAmount;
    }

    public void setPartialAmount(BigDecimal partialAmount) {
        this.partialAmount = partialAmount;
    }

    public BigDecimal getInterest() {
        return interest;
    }

    public void setInterest(BigDecimal interest) {
        this.interest = interest;
    }
}