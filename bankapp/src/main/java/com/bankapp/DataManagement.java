package com.bankapp;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.bankapp.Entities.User;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataManagement {
    private static final String FILENAME = "users.json";

    public static void writeUsersToJson(List<User> users) {
        try (FileWriter writer = new FileWriter(FILENAME)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(users, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<User> readUsersFromJson() {
        List<User> users = new ArrayList<>();
        try (FileReader reader = new FileReader(FILENAME)) {
            Gson gson = new Gson();
            User[] userArray = gson.fromJson(reader, User[].class);
            users.addAll(Arrays.asList(userArray));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }
}