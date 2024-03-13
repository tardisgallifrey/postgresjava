package com.tardisgallifrey;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        //create new postgres database class object
    PSGL mydb = new PSGL();
    Utility util = new Utility();
    String database = "tardis1";

    int menuChoice = 0;
    Scanner input = new Scanner(System.in);
    menuChoice = util.menu(input);

    while(menuChoice != 9) {
        switch (menuChoice) {
            case 1:
                enterUser(mydb, input, database);
                break;
            case 2:
                showUsers(mydb, database);
                break;
            default:
                break;
        }
        System.out.print("Enter another choice: ");
        menuChoice = input.nextInt();
    }


    }

    private static void enterUser(PSGL mydb, Scanner input, String database){
        System.out.print("Enter a new username: ");
        String username = input.next();

        //create new database connection token
        int success = mydb.addUser(username,database);
        if(success > 0){
            System.out.print("You added "+username);
            System.out.println(" to database " + database);
        }else{
            System.out.println("Your add might not have worked.");
        }

    }

    private static void showUsers(PSGL mydb, String database) throws SQLException {
        ResultSet results = null;
        results = mydb.getAllUsers(database);

        while(true){
            try {
                if (!results.next()) break;
            } catch (SQLException e){
                System.out.println("Something went wrong");
            }
            int id = results.getInt(1);
            String name = results.getString(2);
            System.out.println("ID: "+id+"   username: "+name);
        }

    }

}