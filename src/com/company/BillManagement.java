package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BillManagement {
    private List<Bill> bills = new ArrayList<>();

    public void showAll() {
        for (int i = 0; i < bills.size(); i++) {
            System.out.println(bills.get(i));
        }
    }

    public void addNewBill(Bill bill) {
        bills.add(bill);
    }

    public int size() {
        return bills.size();
    }

    public void updateBill(int index, Bill bill) {
        bills.set(index, bill);
    }

    public void deleteBill(int index) {
        bills.remove(index);
    }

    public void writeToFile(String path) throws IOException {
        FileWriter fileWriter = new FileWriter(path);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for (Bill bill : bills
        ) {
            bufferedWriter.write(bill.toString() + "\n");
        }
        bufferedWriter.close();
        fileWriter.close();
    }

    public void readFile(String path) throws IOException {
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            String[] lines = line.split(",");
            String customerName = lines[0].trim();
            String apartmentNumber = lines[1].trim();
            int kwh = Integer.parseInt(lines[2].trim());//trim() để xóa khoảng trắng ở đầu và cuối
            Customer customer = new Customer(customerName, apartmentNumber, kwh);
            int oldIndex = Integer.parseInt(lines[3].trim());
            int newIndex = Integer.parseInt(lines[4].trim());
            Bill bill = new Bill(customer, oldIndex, newIndex);
            this.bills.add(bill);
        }
        bufferedReader.close();
        fileReader.close();
    }
}
