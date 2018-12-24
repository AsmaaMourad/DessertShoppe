package com.company;

public class IceCream extends DessertItem {
    protected int cost; 

    public IceCream(String name, int cost) {
        super(name);
        this.cost = cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public int getCost() {
        return this.cost;
    }

    public String toString(){
        double costValue = Double.valueOf(DessertShoppe.cents2dollarsAndCents(this.getCost()));
        String s = String.format("%1$"+ (-DessertShoppe.MAX_ITEM_NAME_SIZE ) + "s%2$" + DessertShoppe.COST_WIDTH + "s\n",
                this.getName(),
                costValue);
        return s;
    }
}
