package com.finai.Enums;

public enum PaymentMethod {
    CREDIT_CARD(1L),
    DEBIT_CARD(2L),
    CASH(3L),
    PIX(4L),
    TRANSFER(5L),
    BOLETO(6L),
    DIGITAL_WALLET(7L),
    CHEQUE(8L),
    LOAN(9L),
    SALARY(10L),
    OTHER(11L);

    private final Long id;

    PaymentMethod(Long id){
        this.id = id;
    }
    public Long getId(){
       return id;
    }

    public static PaymentMethod fromId(Long id){
        for (PaymentMethod type : values()){
            if(type.getId().equals(id)){
                return type;
            }
        }throw new IllegalArgumentException("Método de pagamento inválido" + id);
    }


}

