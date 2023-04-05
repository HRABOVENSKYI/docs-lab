package ua.lviv.iot.docslab.enums;

public enum PaymentType {
    PAYMENT("PAYMENT"),
    REIMBURSEMENT("REIMBURSEMENT");

    private final String name;

    PaymentType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
