package com.company;

public class Sundae extends IceCream{
    protected String toppingName;
    protected int toppingCost;

    public Sundae(String name, int cost, String toppingName, int toppingCost) {
        super(name, cost);
        this.toppingName = toppingName;
        this.toppingCost = toppingCost;
    }

    public String getToppingName() {
        return toppingName;
    } 

    public void setToppingName(String toppingName) {
        this.toppingName = toppingName;
    }

    public int getToppingCost() {
        return toppingCost;
    }

    public void setToppingCost(int toppingCost) {
        this.toppingCost = toppingCost;
    }

    @Override
    public int getCost() {
        int cost = this.cost + this.toppingCost;
        return cost;
    }

    public String toString(){
        String s = this.toppingName + " Sundae with\n";
        double costValue = Double.valueOf(DessertShoppe.cents2dollarsAndCents(this.getCost()));
        s += String.format("%1$"+ (-DessertShoppe.MAX_ITEM_NAME_SIZE ) + "s%2$" + DessertShoppe.COST_WIDTH + "s\n",
                this.getName(),
                costValue);
        return s;
    }
}
