package com.bankapp.Entities;

public class User {
    private String username;
    private String tcKimlikNo;
    private String password;
    private double balance=0;

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getTcKimlikNo() {
        return tcKimlikNo;
    }
    public void setTcKimlikNo(String tcKimlikNo) {
        this.tcKimlikNo = tcKimlikNo;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }    
    public void addBalance(double amount) {
        this.balance = balance+amount;
    }
    public void withdraw(double amount) {
        if(balance>=amount){
            this.balance = balance-amount;
        }else{
            System.out.println("Bakiyeniz yetersiz");
        }
        
    } 
}