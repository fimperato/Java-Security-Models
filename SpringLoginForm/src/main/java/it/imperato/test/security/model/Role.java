package it.imperato.test.security.model;

public enum Role {
    ROLE_CUSTOMER("Customer"),ROLE_MANAGER("Manager"),ROLE_ADMIN("Admin");

    private String role;

    Role(String role) {
        this.role = role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
