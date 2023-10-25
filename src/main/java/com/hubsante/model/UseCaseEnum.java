package com.hubsante.model;

import java.util.Arrays;

public enum UseCaseEnum {
    RC_EDA("CreateCaseMessage"),
    RC_REF("ReferenceMessage"),
    CUSTOM("CustomMessage"),
    RS_INFO("ErrorReport");

    private String clazzName;

    UseCaseEnum(String clazzName) {
        this.clazzName = clazzName;
    }

    public static UseCaseEnum getByValue(String clazzName) {
        return Arrays.stream(UseCaseEnum.values())
                .filter(useCaseEnum -> useCaseEnum.clazzName.equals(clazzName)).findFirst().orElseThrow();
    }

}
