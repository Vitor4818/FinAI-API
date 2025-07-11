package com.finai.Enums;

public enum Recurring {
    YES(1L),
    NO(2L);

    private final Long id;

    Recurring(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public static Recurring fromId(Long id) {
        for (Recurring type : values()) {
            if (type.getId().equals(id)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Tipo de recorrência inválido: " + id);
    }
}
