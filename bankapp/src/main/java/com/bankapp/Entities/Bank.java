package com.bankapp.Entities;

import java.util.List;

import com.bankapp.DataManagement;

public class Bank {
    private List<User> users = DataManagement.readUsersFromJson();;
    
    public void addUser(User user) {
        users.add(user);
        DataManagement.writeUsersToJson(users);
    }
    
    public User getUserByTCKimlikNo(String tcKimlikNo) {
        User finduser = null;
        for(User user : users){
            if(user.getTcKimlikNo().equals(tcKimlikNo)){
                finduser = user;
            }
        }
        return finduser;
    }
    
    public User authenticateUser(String tcKimlikNo, String password) {
        for(User user : users){
            if(user.getTcKimlikNo().equals(tcKimlikNo) && user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }
    
    public void transferMoney(User fromUser, User toUser, double amount) {
        if(fromUser.getBalance() >= amount){
            fromUser.setBalance(fromUser.getBalance() - amount);
            toUser.setBalance(toUser.getBalance() + amount);
            DataManagement.writeUsersToJson(users);
        }        
    }

    public void userAddBalance(User user, double amount) {
        user.addBalance(amount);
        DataManagement.writeUsersToJson(users);
    }

    public void withdraw(User user, double amount) {
        user.withdraw(amount);
        DataManagement.writeUsersToJson(users); 
    }
 
}
