package com.finai.Enums;

public enum MovementType {
    INCOME(1L),
    EXPENSE(2L);

    private final Long id;

    MovementType(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public static MovementType fromId(Long id) {
        for (MovementType mt : values()) {
            if (mt.getId().equals(id)) {
                return mt;
            }
        }
        throw new IllegalArgumentException("Tipo de movimentação não encontrado: " + id);
    }
}
