package Algorithm;

import java.util.*;

public class CountryStacks {
    public Map<String, Map<Integer, Stack<Integer>>> foodStacks = new HashMap<>(); // Country -> (Year -> Stack of ItemCodes)
    public Map<String, Map<Integer, Stack<Integer>>> feedStacks = new HashMap<>();

    public void createStacks(String countryCode, HashMap<Integer, CountryData.FoodFeedData> data, boolean isFood) {
        Map<Integer, Stack<Integer>> yearStacks = new HashMap<>();

        for (int year = 2000; year <= 2013; year++) {
            List<Map.Entry<Integer, Double>> items = new ArrayList<>();
            for (Map.Entry<Integer, CountryData.FoodFeedData> entry : data.entrySet()) {
                items.add(new java.util.AbstractMap.SimpleEntry<>(entry.getKey(), entry.getValue().yearlyData.getOrDefault(year, 0.0)));
            }

            // Sort items by quantity
            Collections.sort(items, Comparator.comparingDouble(Map.Entry::getValue));

            Stack<Integer> itemStack = new Stack<>();
            for (Map.Entry<Integer, Double> entry : items) {
                itemStack.push(entry.getKey());
            }
            yearStacks.put(year, itemStack);
        }

        if (isFood) {
            foodStacks.put(countryCode, yearStacks);
        } else {
            feedStacks.put(countryCode, yearStacks);
        }
    }
}

