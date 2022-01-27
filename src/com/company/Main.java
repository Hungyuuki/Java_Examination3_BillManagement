package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice = -1;
        BillManagement billManagement = new BillManagement();
        try {
            billManagement.readFile("bill.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Choice one: ");
        do {
            showMainMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1: {
                    billManagement.showAll();
                    break;
                }
                case 2: {
                    createBill(billManagement);
                    break;
                }
                case 3: {
                    editBill(billManagement);
                    break;
                }
                case 4: {
                    deleteBill(billManagement);
                    break;
                }
                case 5: {
                    try {
                        billManagement.writeToFile("bill.txt");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 6: {
                    try {
                        billManagement.readFile("bill.txt");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
            }
            try {
                billManagement.writeToFile("bill.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while (choice != 0);
    }

    private static void createBill(BillManagement billManagement) {
        Bill bill = getBill();
        billManagement.addNewBill(bill);
    }

    private static void deleteBill(BillManagement billManagement) {
        System.out.println("Delete Bill By Index: ");
        System.out.println("Input Index In Order To Delete: ");
        int index = scanner.nextInt();
        if (index < 0 || index > billManagement.size())
            System.err.println("IndexOutOfBoundException");
        else
            billManagement.deleteBill(index);
    }

    private static void editBill(BillManagement billManagement) {
        System.out.println("Edit Bill Info: ");
        System.out.println("Input Index In Order To Edit: ");
        int index = scanner.nextInt();
        if (index < 0 || index > billManagement.size())
            System.err.println("IndexOutOfBoundException");
        else {
            Bill bill = getBill();
            billManagement.updateBill(index, bill);
        }
    }

    private static Bill getBill() {
        System.out.println("Add New Bill: ");
        Customer customer = getCustomerInfo();
        System.out.println("Input Payment Info: ");
        System.out.println("Input Old Index: ");
        int oldIndex = scanner.nextInt();
        System.out.println("Input New Index: ");
        int newIndex = scanner.nextInt();
        return new Bill(customer, oldIndex, newIndex);
    }

    private static Customer getCustomerInfo() {
        System.out.println("Input Customer's Name: ");
        scanner.nextLine();
        String customerName = scanner.nextLine();
        System.out.println("Input Apartment Number: ");
        String apartmentNumber = scanner.nextLine();
        System.out.println("Input KwH: ");
        int kwh = scanner.nextInt();
        return new Customer(customerName, apartmentNumber, kwh);
    }

    private static void showMainMenu() {
        System.out.println("1. Show Bill List");
        System.out.println("2. Add new Bill");
        System.out.println("3. Update Bill");
        System.out.println("4. Delete Bill");
        System.out.println("5. Record Bill Into File");
        System.out.println("6. Read Bill From File");
        System.out.println("0. Exit Menu");
    }
}
