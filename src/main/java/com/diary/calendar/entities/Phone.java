package com.diary.calendar.entities;

import com.diary.calendar.enums.PhoneType;

public class Phone extends AbstractEntity {

    private PhoneType type;
    private String code;
    private String number;

    public PhoneType getType() {
        return type;
    }

    public void setType(PhoneType type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

}
