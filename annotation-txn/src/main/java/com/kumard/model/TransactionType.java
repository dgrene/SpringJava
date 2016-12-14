package com.kumard.model;

/**
 * Created by deepak on 4/12/16.
 */
public enum TransactionType {
    DEBIT("Debit"), CREDIT("Credit");
    private String type;

    TransactionType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
