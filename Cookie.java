package com.company;

public class Cookie extends DessertItem {
    protected int number;
    protected int pricePerDozen;

    public Cookie(String name, int number, int pricePerDozen) {
        super(name);
        this.number = number;
        this.pricePerDozen = pricePerDozen;
    }

    @Override
    public int getCost() {
        int cost = (this.number * this.pricePerDozen) / 12  ;
        return (int) Math.round(cost);
    }

    public String toString(){
        double pricePerDozenValue = Double.valueOf(DessertShoppe.cents2dollarsAndCents(this.pricePerDozen));
        String s = String.format("%1$d @ %2$.2f /dz.\n",
                this.number,
                pricePerDozenValue);
        double costValue = Double.valueOf(DessertShoppe.cents2dollarsAndCents(this.getCost()));
        s += String.format("%1$"+ (-DessertShoppe.MAX_ITEM_NAME_SIZE ) + "s%2$" + DessertShoppe.COST_WIDTH + ".2f\n",
                this.getName(),
                costValue);
        return s;
    }
}