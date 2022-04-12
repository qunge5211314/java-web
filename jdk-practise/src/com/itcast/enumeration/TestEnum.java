package com.itcast.enumeration;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum TestEnum {
    UNCOMMITED(0L, "test", "未提交"),
    COMMITED(1L, "test", "已提交"),
    REJECTED(2L, "test", "已驳回");
    private Long code;
    private String mark;
    private String value;

    TestEnum(Long code, String mark, String value) {
        this.code = code;
        this.mark = mark;
        this.value = value;
    }

    public Long getCode() {
        return code;
    }

    public String getMark() {
        return mark;
    }

    public String getValue() {
        return value;
    }

    public static Map<Long, TestEnum> toMap() {
        Map<Long, TestEnum> result = new HashMap<>();
        Arrays.stream(values()).forEach(item->result.put(item.getCode(), item));
        return result;
    }
}
