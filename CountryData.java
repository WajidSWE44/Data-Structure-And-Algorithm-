package Algorithm;

import java.util.HashMap;
import java.util.Map;

public class CountryData {
    public Map<String, HashMap<Integer, FoodFeedData>> foodData = new HashMap<>(); // CountryCode -> (ItemCode -> Data)
    public Map<String, HashMap<Integer, FoodFeedData>> feedData = new HashMap<>();

    // Data structure to store item data
    public static class FoodFeedData {
        int itemCode;
        String unit;
        Map<Integer, Double> yearlyData; // Year -> Quantity

        public FoodFeedData(int itemCode, String unit) {
            this.itemCode = itemCode;
            this.unit = unit;
            this.yearlyData = new HashMap<>();
        }

        public void addYearlyData(int year, double data) {
            this.yearlyData.put(year, data);
        }
    }
}

