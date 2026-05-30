package mx.levm.finance.enums;

public enum TransactionType {
    EXPENSE("Gasto"),
    PAYMENT("Pago");

    private final String label;

    TransactionType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
