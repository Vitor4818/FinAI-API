package com.finai.Enums;

public enum Category {
    GROCERIES(1L, MovementType.EXPENSE),
    RESTAURANTS(2L, MovementType.EXPENSE),
    PUBLIC_TRANSPORT(3L, MovementType.EXPENSE),
    FUEL(4L, MovementType.EXPENSE),
    VEHICLE_MAINTENANCE(5L, MovementType.EXPENSE),
    RENT(6L, MovementType.EXPENSE),
    WATER_BILL(7L, MovementType.EXPENSE),
    ELECTRICITY_BILL(8L, MovementType.EXPENSE),
    GAS_BILL(9L, MovementType.EXPENSE),
    INTERNET(10L, MovementType.EXPENSE),
    PHONE(11L, MovementType.EXPENSE),
    TV_STREAMING(12L, MovementType.EXPENSE),
    HEALTH(13L, MovementType.EXPENSE),
    PHARMACY(14L, MovementType.EXPENSE),
    GYM(15L, MovementType.EXPENSE),
    EDUCATION(16L, MovementType.EXPENSE),
    PERSONAL_CARE(17L, MovementType.EXPENSE),
    CLOTHING(18L, MovementType.EXPENSE),
    PETS(19L, MovementType.EXPENSE),
    ENTERTAINMENT(20L, MovementType.EXPENSE),
    TRAVEL(21L, MovementType.EXPENSE),
    BARS_RESTAURANTS(22L, MovementType.EXPENSE),
    SUBSCRIPTIONS(23L, MovementType.EXPENSE),
    GIFTS(24L, MovementType.EXPENSE),
    INTEREST_FEES(25L, MovementType.EXPENSE),
    BANK_FEES(26L, MovementType.EXPENSE),
    CREDIT_CARD_FEE(27L, MovementType.EXPENSE),
    LOANS(28L, MovementType.EXPENSE),
    TAXES(29L, MovementType.EXPENSE),
    ONLINE_SHOPPING(30L, MovementType.EXPENSE),
    APPLIANCES(31L, MovementType.EXPENSE),
    FURNITURE(32L, MovementType.EXPENSE),
    DECORATION(33L, MovementType.EXPENSE),
    HOME_REPAIRS(34L, MovementType.EXPENSE),
    DONATIONS(35L, MovementType.EXPENSE),
    DOMESTIC_SERVICES(36L, MovementType.EXPENSE),
    INSURANCE(37L, MovementType.EXPENSE),
    SALARY(38L, MovementType.INCOME),
    THIRTEENTH_SALARY(39L, MovementType.INCOME),
    VACATION(40L, MovementType.INCOME),
    BONUS(41L, MovementType.INCOME),
    FREELANCE(42L, MovementType.INCOME),
    SELF_EMPLOYED(43L, MovementType.INCOME),
    ITEM_SALES(44L, MovementType.INCOME),
    LOTTERY(45L, MovementType.INCOME),
    CASHBACK(46L, MovementType.INCOME),
    SAVINGS_INTEREST(47L, MovementType.INCOME),
    DIVIDENDS(48L, MovementType.INCOME),
    FUNDS_REVENUE(49L, MovementType.INCOME),
    RENTAL_INCOME(50L, MovementType.INCOME),
    PENSION(51L, MovementType.INCOME),
    ALLOWANCE(52L, MovementType.INCOME),
    REIMBURSEMENT(53L, MovementType.INCOME),
    TAX_REFUND(54L, MovementType.INCOME),
    COMPENSATION(55L, MovementType.INCOME),
    INHERITANCE(56L, MovementType.INCOME);

    private final Long id;
    private final MovementType movementType;

    Category(Long id, MovementType movementType) {
        this.id = id;
        this.movementType = movementType;
    }

    public Long getId() {
        return id;
    }

    public MovementType getMovementType() {
        return movementType;
    }

    public static Category fromId(Long id) {
        for (Category type : values()) {
            if (type.getId().equals(id)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Categoria não encontrada: " + id);
    }
}
