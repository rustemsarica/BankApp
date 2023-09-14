package com.bankapp;

import java.util.Scanner;

import com.bankapp.Entities.Bank;
import com.bankapp.Entities.User;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean isLoggedIn = false;
            User loggedInUser = null;
            Bank bank = new Bank();

            while (true) {
                if(isLoggedIn){
                    System.out.println("Online Banka Sistemi");
                    System.out.println("1. Transfer");
                    System.out.println("2. Bakiye Sorgula");
                    System.out.println("3. Para Yatır");
                    System.out.println("4. Para Çek");
                    System.out.println("5. Çıkış Yap");

                    int choice = scanner.nextInt();
                    scanner.nextLine();

                    switch (choice) {
                        case 1:
                            System.out.print("Transfer yapılacak TC kimlik no: ");
                            String tcNo = scanner.nextLine();
                            System.out.print("Miktar: ");
                            double amount = scanner.nextDouble();
                            bank.transferMoney(loggedInUser, bank.getUserByTCKimlikNo(tcNo), amount);
                            break;
                        case 2:
                            System.out.println("Bakiyeniz: "+loggedInUser.getBalance());
                            break;
                        case 3:
                            System.out.print("Miktar: ");
                            double addAmount = scanner.nextDouble();
                            bank.userAddBalance(loggedInUser, addAmount);
                            break;
                        case 4:
                            System.out.print("Miktar: ");
                            double withdraw = scanner.nextDouble();
                            bank.withdraw(loggedInUser,withdraw);
                            break;
                        case 5:
                            System.out.println("Çıkış yapılıyor...");
                            System.exit(0);
                        default:
                            System.out.println("Geçersiz seçenek. Lütfen tekrar deneyin.");
                    }

                }else{
                    System.out.println("Online Banka Sistemi");
                    System.out.println("1. Giriş Yap");
                    System.out.println("2. Kayıt Ol");
                    System.out.println("3. Çıkış Yap");
                    
                    int choice = scanner.nextInt();
                    scanner.nextLine();

                    switch (choice) {
                        case 1:
                            System.out.print("TC kimlik no: ");
                            String tcNo = scanner.nextLine();
                            System.out.print("Sifre: ");
                            String password = scanner.nextLine();
                            loggedInUser = bank.authenticateUser(tcNo, password);
                            if( loggedInUser != null){
                                isLoggedIn = true;
                            }

                            break;
                        case 2:
                            System.out.print("Ad Soyad: ");
                            String name = scanner.nextLine();
                            System.out.print("TC kimlik no: ");
                            String tcNoReister = scanner.nextLine();
                            System.out.print("Sifre: ");
                            String passwordRegister = scanner.nextLine();
                            User user = new User();
                            user.setUsername(name);
                            user.setTcKimlikNo(tcNoReister);
                            user.setPassword(passwordRegister);
                            bank.addUser(user);
                            break;
                        case 3:
                            System.out.println("Çıkış yapılıyor...");
                            System.exit(0);
                        default:
                            System.out.println("Geçersiz seçenek. Lütfen tekrar deneyin.");
                    }
                }            
            }
        }
    }

}
