package mx.levm.finance.enums;

public enum ExpenseType {
    
    PRIORITY("Prioritario"),
    PLEASURE("Placer"),
    INVESTMENT("Inversión"),
    HOUSE("Casa"),
    OTHER("Otros"),
    ENTERTAINMENT("Entretenimiento"),
    UNPLANNED("Imprevisto"),
    RELATIONSHIP("Pareja");
    
    private final String label;

    ExpenseType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}