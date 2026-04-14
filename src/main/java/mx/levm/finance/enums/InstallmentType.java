package mx.levm.finance.enums;

public enum InstallmentType {
    
    WITHOUT_INTEREST("Sin interés"),
    WITH_INTEREST("Con interés");

    private final String label;

    InstallmentType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}