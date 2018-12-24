package com.company;

public class Candy extends DessertItem{
    protected double weight;
    protected int pricePerPound;

    public Candy(String name, double weight, int pricePerPound) {
        super(name);
        this.weight = weight;
        this.pricePerPound = pricePerPound;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getPricePerPound() {
        return pricePerPound;
    }

    public void setPricePerPound(int pricePerPound) {
        this.pricePerPound = pricePerPound;
    }

    //For example, 2.30 lbs.of fudge @ .89 /lb. = 205 cents. The cost should be rounded to the nearest cent.
    @Override
    public int getCost() {
        double cost = this.weight * this.pricePerPound;
        return (int) Math.round(cost);
    }
    public String toString(){
        double pricePerPoundValue = Double.valueOf(DessertShoppe.cents2dollarsAndCents(this.pricePerPound));
        String s = String.format("%1$.2f lbs. @ %2$.2f /lb.\n",
                this.weight,
                pricePerPoundValue);
        double costValue = Double.valueOf(DessertShoppe.cents2dollarsAndCents(this.getCost()));
        s += String.format("%1$"+ (-DessertShoppe.MAX_ITEM_NAME_SIZE ) + "s%2$" + DessertShoppe.COST_WIDTH + ".2f\n",
                this.getName(),
                costValue);
        return s;
    }
}
