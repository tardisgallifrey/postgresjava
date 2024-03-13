package com.tardisgallifrey;

import java.util.Scanner;

public class Utility {

    public int menu(Scanner input){
        int choice;

        System.out.println("************************");
        System.out.println("** User Menu          **");
        System.out.println("************************");
        System.out.println("1. Add User");
        System.out.println("2. Get all users");
        System.out.println();
        System.out.println("9. End program");
        System.out.println(" ");
        System.out.print("Enter your choice: ");
        choice = input.nextInt();

        return choice;

    }
}
