package ua.lviv.iot.docslab.enums;

public enum Permission {
    READ("READ"),
    WRITE("WRITE");

    private final String name;

    Permission(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
