package com.people.manager.api.demo.utils;

import com.people.manager.api.demo.dto.request.PhoneDto;
import com.people.manager.api.demo.entity.Phone;
import com.people.manager.api.demo.enums.PhoneType;

import java.util.List;

public class PhoneUtils {

    private static  final String PHONE_NUMBER = "";
    private static final PhoneType PHONE_TYPE = PhoneType.MOBILE;
    private static final long PHONE_ID = 1L;

    public static PhoneDto createFakeDto() {
        return PhoneDto
                .builder()
                .number(PHONE_NUMBER)
                .type(PHONE_TYPE)
                .build();
    }

    public static Phone createFakeEntity() {
        return Phone
                .builder()
                .id(PHONE_ID)
                .number(PHONE_NUMBER)
                .type(PHONE_TYPE)
                .build();
    }
}
