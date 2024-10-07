package intermediate.src.week1_labs.advance_algo;

import java.util.*;

class Knapsack {
    
    // Item class to store the value and weight of an item
    static class Item {
        int value;
        int weight;
        
        public Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }
    }
    
    // Method to get the maximum value in the knapsack with fractional items allowed
    public static double getMaxValue(int capacity, List<Item> items) {
        // Sort items by value-to-weight ratio in descending order
        items.sort((a, b) -> Double.compare((double) b.value / b.weight, (double) a.value / a.weight));
        
        double totalValue = 0.0; // Total value in the knapsack
        int currentWeight = 0;   // Current weight of the knapsack
        
        for (Item item : items) {
            if (currentWeight + item.weight <= capacity) {
                // If the item can be taken fully, add its full value
                currentWeight += item.weight;
                totalValue += item.value;
            } else {
                // Otherwise, take the fraction of the item that fits
                int remainingCapacity = capacity - currentWeight;
                totalValue += item.value * ((double) remainingCapacity / item.weight);
                break; // Once we've filled the knapsack, stop
            }
        }
        
        return totalValue;
    }
    
    public static void main(String[] args) {
        // List of items with value and weight
        List<Item> items = Arrays.asList(
                new Item(60, 10),  // value = 60, weight = 10
                new Item(100, 20), // value = 100, weight = 20
                new Item(120, 30)  // value = 120, weight = 30
        );
        
        int capacity = 50; // Maximum weight the knapsack can carry
        
        // Calculate the maximum value possible
        double maxValue = getMaxValue(capacity, items);
        
        // Print the result
        System.out.println("Maximum value in the knapsack = " + maxValue);
    }
}
