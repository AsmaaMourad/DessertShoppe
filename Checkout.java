package com.company;

import java.util.ArrayList;

public class Checkout {
    protected ArrayList<DessertItem> dessertItems;

    //Creates a Checkout instance with an empty list of DessertItem's
    public Checkout(){
        this.dessertItems = new ArrayList<DessertItem>();
    }

    //Returns the number of DessertItem's in the list
    public int numberOfItems(){
        return this.dessertItems.size();
    }

    //A DessertItem is added to the end of the list of items
    public void enterItem(DessertItem item){
        this.dessertItems.add(item);
    }

    //Clears the Checkout to begin checking out a new set of items
    public void clear(){
        this.dessertItems.clear();
    }

    //Returns total cost of items in cents (without tax)
    public int totalCost(){
        int sum = 0;
        for (int i = 0; i < this.numberOfItems(); i++){
            sum += this.dessertItems.get(i).getCost();
        }
        return sum;
    }
    //Returns total tax on items in cents
    public int totalTax(){
        return (int) Math.round(this.totalCost() * DessertShoppe.TAX_RATE / 100);
    }

    //Returns a String representing a receipt for the current list of items
    public String toString(){
        String s = String.format("%1$"+ DessertShoppe.MAX_ITEM_NAME_SIZE + "s\n",DessertShoppe.STORE_NAME);
        s += String.format("%1$"+ DessertShoppe.MAX_ITEM_NAME_SIZE + "s\n\n", "--------------------");
        for (int i = 0; i < this.numberOfItems(); i++){
            s += this.dessertItems.get(i);
        }
        double taxValue = Double.valueOf(DessertShoppe.cents2dollarsAndCents(this.totalTax()));
        s += String.format("\n%1$"+ (-DessertShoppe.MAX_ITEM_NAME_SIZE ) + "s%2$" + DessertShoppe.COST_WIDTH + ".2f\n",
                "Tax",
                taxValue);
        double totalCostValue = Double.valueOf(DessertShoppe.cents2dollarsAndCents(this.totalCost() + this.totalTax()));
        s += String.format("%1$"+ (-DessertShoppe.MAX_ITEM_NAME_SIZE ) + "s%2$" + DessertShoppe.COST_WIDTH + ".2f\n",
                "Total Cost",
                totalCostValue);
        return s;
    }

}