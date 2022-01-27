package com.company;

public class Customer {
    private String customerName;
    private String apartmentNumber;
    private int kwh;

    public Customer() {

    }

    public Customer(String customerName, String apartmentNumber, int kwh) {
        this.customerName = customerName;
        this.apartmentNumber = apartmentNumber;
        this.kwh = kwh;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public int getKwh() {
        return kwh;
    }

    public void setKwh(int kwh) {
        this.kwh = kwh;
    }

    @Override
    public String toString() {
        return customerName + ", " + apartmentNumber + ", " + kwh;
    }
}
