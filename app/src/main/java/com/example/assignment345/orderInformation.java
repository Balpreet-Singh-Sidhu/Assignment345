package com.example.assignment345;

public class orderInformation {
    private long orderId;
    private String foodName;
    private int price;
    private int quantity;
    private double tip;
    private double tax;
    private double cost;

    public orderInformation(long orderId, String foodName, int price, int quantity, double tip, double cost, double tax)
    {
        this.orderId = orderId;
        this.foodName = foodName;
        this.price = price;
        this.quantity = quantity;
        this.tip = tip;
        this.tax = tax;
        this.cost = cost;
    }
    public orderInformation()
    {

    }
    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTip() {
        return tip;
    }

    public void setTip(double tip) {
        this.tip = tip;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String toString()
    {
        return "Order ID: "+ getOrderId() + "\n" +
                "Meal Name: "+ getFoodName() + "\n" +
                "Price: "+ getPrice() + "\n" +
                "Quantity: " + getQuantity() + "\n" +
                "Tip: " + getTip() + "\n" +
                "Tax: " + getTax() + "\n" +
                "Final Cost: " + getCost() + "\n";
    }

}
