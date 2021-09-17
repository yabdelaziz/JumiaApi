package com.jumia.demo.dto;

public enum PhoneNoRegex {
    CAMEROON("+237", "\\(237\\)\\ ?[2368]\\d{7,8}$"),
    ETHIOPIA("+251", "\\(251\\)\\ ?[1-59]\\d{8}$"),
    MOROCCO("+212", "\\(212\\)\\ ?[5-9]\\d{8}$"),
    MOZAMBIQUE("+258", "\\(258\\)\\ ?[28]\\d{7,8}$"),
    UGANDA("+256", "\\(256\\)\\ ?\\d{9}$");

    private final String countryCode;
    private final String regex;

    PhoneNoRegex(String countryCode, String regex) {
        this.countryCode = countryCode;
        this.regex = regex;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getRegex() {
        return regex;
    }
}
