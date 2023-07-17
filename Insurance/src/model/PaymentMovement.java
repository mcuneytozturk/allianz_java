package model;

import java.math.BigDecimal;

public class PaymentMovement {

    private BankAccount bankAccount;
    private String description;
    private MovementTypeEnum movementType;
    private BigDecimal amount;

    public PaymentMovement() {
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MovementTypeEnum getMovementType() {
        return movementType;
    }

    public void setMovementType(MovementTypeEnum movementType) {
        this.movementType = movementType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }


}
