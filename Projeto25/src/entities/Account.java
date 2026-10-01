package entities;

import exceptions.BusinessException;

public class Account {
    private  int number;
    private  String holder;
    private double balance;
    private double limiteSaque;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getLimiteSaque() {
        return limiteSaque;
    }

    public void setLimiteSaque(double limiteSaque) {
        this.limiteSaque = limiteSaque;
    }

    public Account() {
    }
    public Account(int number, String holder, double balance, double limiteSaque) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.limiteSaque = limiteSaque;
    }
    public void deposit(double amount) {
        this.balance += amount;
    }
    public void withdraw(double amount) {
        validateWithdraw(amount);
        this.balance -= amount;
    }

    private void validateWithdraw(double amount) {
        if (amount > getBalance() ) {
            throw new BusinessException("Saldo insuficiente");

        }
        if (amount > limiteSaque) {
            throw new BusinessException("O valor excede o limite de saque!");
        }
    }

    @Override
    public String toString() {
        return "New balance:" + balance;
    }
}
