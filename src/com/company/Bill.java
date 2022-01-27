package com.company;

public class Bill {
    private Customer customer;
    private int oldIndex;
    private int newIndex;
    private float payment;

    public Bill() {
    }

    public Bill(Customer customer, int oldIndex, int newIndex) {
        this.customer = customer;
        this.oldIndex = oldIndex;
        this.newIndex = newIndex;
        this.payment = (this.newIndex - this.oldIndex) * 750;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getOldIndex() {
        return oldIndex;
    }

    public void setOldIndex(int oldIndex) {
        this.oldIndex = oldIndex;
    }

    public int getNewIndex() {
        return newIndex;
    }

    public void setNewIndex(int newIndex) {
        this.newIndex = newIndex;
    }

    @Override
    public String toString() {
        return customer + ", " + oldIndex + ", " + newIndex + ", " + payment;
    }
}
