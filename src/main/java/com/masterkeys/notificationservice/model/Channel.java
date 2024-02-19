package com.masterkeys.notificationservice.model;

public enum Channel {
    EMAIL("EMAIL"),
    PUSH("PUSH"),
    SMS("SMS");

    private final String value;

    Channel(final String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
