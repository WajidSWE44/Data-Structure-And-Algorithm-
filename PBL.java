package PBL_DSA;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class DataProcessor {
    private Map<String, CountryData> foodTable = new HashMap<>();
    private Map<String, CountryData> feedTable = new HashMap<>();
    private ItemLinkedList itemList = new ItemLinkedList();
    private static class CountryData {
        Map<Integer, ItemData> items = new HashMap<>();
    }

    private static class ItemData {
        int itemCode;
        String unit;
        Map<Integer, Integer> yearlyQuantities = new HashMap<>();
        public ItemData(int itemCode, String unit) {
            this.itemCode = itemCode;
            this.unit = unit;
        }
    }
    private static class ItemLinkedList {
        private Node head;
        private static class Node {
            int itemCode;
            String itemName;
            Node next;
            public Node(int itemCode, String itemName) {
                this.itemCode = itemCode;
                this.itemName = itemName;
            }
        }
        public void addItem(int itemCode, String itemName) {
            Node newNode = new Node(itemCode, itemName);
            newNode.next = head;
            head = newNode;
        }
        public String getItemNameByCode(int itemCode) {
            Node current = head;
            while (current != null) {
                if (current.itemCode == itemCode) {
                    return current.itemName;
                }
                current = current.next;
            }
            return "Item not found";
        }
    }

    public void loadData(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Skip the header line

            // Process each line in the file
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                if (columns.length < 18) { // Check if data row has enough columns
                    System.out.println("Invalid data row: " + line);
                    continue;
                }
                try {
                    // Extract basic data from columns
                    String countryCode = columns[0].trim();
                    int itemCode = Integer.parseInt(columns[3].trim());
                    String itemName = columns[4].trim();
                    String category = columns[6].trim();
                    String unit = columns[7].trim();

                    // Debug print: show parsed values
                    System.out.println("Country: " + countryCode + ", Item Code: " + itemCode + ", Item Name: " + itemName + ", Category: " + category);

                    // Add new item to the list if it’s not already there
                    if (itemList.getItemNameByCode(itemCode).equals("Item not found")) {
                        itemList.addItem(itemCode, itemName);
                    }

                    // Choose the correct table based on the item category (food or feed)
                    Map<String, CountryData> selectedTable = category.equalsIgnoreCase("food") ? foodTable : feedTable;
                    CountryData countryData = selectedTable.computeIfAbsent(countryCode, k -> new CountryData());

                    // Initialize item data if it doesn’t exist in the country’s records
                    ItemData itemData = countryData.items.computeIfAbsent(itemCode, k -> new ItemData(itemCode, unit));

                    // Populate yearly quantities for each item
                    for (int year = 2000; year <= 2013; year++) {
                        int yearIndex = year - 2000 + 8; // Map year to column index
                        if (yearIndex < columns.length) {
                            String quantityStr = columns[yearIndex].trim();
                            if (!quantityStr.isEmpty() && quantityStr.matches("-?\\d+")) {
                                int quantity = Integer.parseInt(quantityStr);
                                itemData.yearlyQuantities.put(year, quantity);
                            }
                        }
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error parsing numeric data in row: " + line + " - " + e.getMessage());
                }
            }

//            // Debugging: Print the tables after loading
//            System.out.println("Food Table:");
//            foodTable.forEach((country, data) -> System.out.println(country + " -> " + data.items));
//            System.out.println("Feed Table:");
//            feedTable.forEach((country, data) -> System.out.println(country + " -> " + data.items));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createStacksForCountryYear(String countryCode, int year) {
        System.out.println("Food items for country " + countryCode + " in year " + year + ":");
        Stack<ItemData> foodStack = createSortedStack(foodTable.get(countryCode), year);
        printStackDetails(foodStack, year);

        System.out.println("\nFeed items for country " + countryCode + " in year " + year + ":");
        Stack<ItemData> feedStack = createSortedStack(feedTable.get(countryCode), year);
        printStackDetails(feedStack, year);
    }
    private Stack<ItemData> createSortedStack(CountryData countryData, int year) {
        Stack<ItemData> stack = new Stack<>();
        if (countryData == null) return stack;

        List<ItemData> itemList = new ArrayList<>(countryData.items.values());
        itemList.sort((item1, item2) -> Integer.compare(
                item2.yearlyQuantities.getOrDefault(year, 0),
                item1.yearlyQuantities.getOrDefault(year, 0)
        ));
        for (ItemData item : itemList) {
            stack.push(item);
        }
        return stack;
    }
    private void printStackDetails(Stack<ItemData> stack, int year) {
        if (stack.isEmpty()) {
            System.out.println("No data available for this year.");
            return;
        }
        for (ItemData item : stack) {
            String itemName = getItemNameByCode(item.itemCode);
            int quantity = item.yearlyQuantities.getOrDefault(year, 0);
            System.out.println("Item Name: " + itemName + ", Quantity: " + quantity);
        }
    }
    public String getItemNameByCode(int itemCode) {
        return itemList.getItemNameByCode(itemCode);
    }
    public void printTopItemsInYear(int year) {
        String topFoodCountry = null;
        String topFeedCountry = null;
        String topFoodItem = null;
        String topFeedItem = null;
        int maxFoodQuantity = 0;
        int maxFeedQuantity = 0;

        for (Map.Entry<String, CountryData> entry : foodTable.entrySet()) {
            String countryCode = entry.getKey();
            CountryData countryData = entry.getValue();
            for (ItemData item : countryData.items.values()) {
                int quantity = item.yearlyQuantities.getOrDefault(year, 0);
                if (quantity > maxFoodQuantity) {
                    maxFoodQuantity = quantity;
                    topFoodCountry = countryCode;
                    topFoodItem = getItemNameByCode(item.itemCode);
                }
            }
        }
        for (Map.Entry<String, CountryData> entry : feedTable.entrySet()) {
            String countryCode = entry.getKey();
            CountryData countryData = entry.getValue();
            for (ItemData item : countryData.items.values()) {
                int quantity = item.yearlyQuantities.getOrDefault(year, 0);
                if (quantity > maxFeedQuantity) {
                    maxFeedQuantity = quantity;
                    topFeedCountry = countryCode;
                    topFeedItem = getItemNameByCode(item.itemCode);
                }
            }
        }
        if (topFoodCountry != null) {
            System.out.println("Top food item in " + year + ": " + topFoodItem + " from " + topFoodCountry);
        } else {
            System.out.println("No food items found for the year " + year);
        }

        if (topFeedCountry != null) {
            System.out.println("Top feed item in " + year + ": " + topFeedItem + " from " + topFeedCountry);
        } else {
            System.out.println("No feed items found for the year " + year);
        }
    }

    /*public String getTopItem(CountryData countryData, int year) {
        if (countryData == null) return "None";
        ItemData topItem = null;
        int maxQuantity = 0;

        for (ItemData item : countryData.items.values()) {
            int quantity = item.yearlyQuantities.getOrDefault(year, 0);
            if (quantity > maxQuantity) {
                maxQuantity = quantity;
                topItem = item;
            }
        }
        return (topItem != null) ? getItemNameByCode(topItem.itemCode) : "None";
    }
*/


    // Problem 1: List the names of items of country which sits at the top in year 2002 for both food and feed.
    public void listTopItemsForTopCountryInYear(int year) {
        // Find the top food country and list items
        String topFoodCountry = findTopCountry(foodTable, year);
        System.out.println("Top food items for country " + topFoodCountry + " in year " + year + ":");
        printItemsForCountry(foodTable.get(topFoodCountry), year);

        // Find the top feed country and list items
        String topFeedCountry = findTopCountry(feedTable, year);
        System.out.println("\nTop feed items for country " + topFeedCountry + " in year " + year + ":");
        printItemsForCountry(feedTable.get(topFeedCountry), year);
    }

    // Method to find the top country based on total quantity in the given year
    private String findTopCountry(Map<String, CountryData> table, int year) {
        String topCountry = null;
        int maxQuantity = 0;

        for (Map.Entry<String, CountryData> entry : table.entrySet()) {
            int totalQuantity = 0;
            for (ItemData item : entry.getValue().items.values()) {
                totalQuantity += item.yearlyQuantities.getOrDefault(year, 0);
            }

            if (totalQuantity > maxQuantity) {
                maxQuantity = totalQuantity;
                topCountry = entry.getKey();
            }
        }
        return topCountry;
    }

    // Method to print item names and quantities for a given country's data in the specified year
    private void printItemsForCountry(CountryData countryData, int year) {
        if (countryData == null) {
            System.out.println("No data available.");
            return;
        }

        for (ItemData item : countryData.items.values()) {
            int quantity = item.yearlyQuantities.getOrDefault(year, 0);
            if (quantity > 0) {
                String itemName = getItemNameByCode(item.itemCode);
                System.out.println("Item Name: " + itemName + ", Quantity: " + quantity);
            }
        }
    }

    //Problem 2: What are the most common food and feed items for the year 2006 by any country.
    public void printMostCommonItemsInYear(int year) {
        Map<Integer, Integer> foodItemCount = new HashMap<>();
        Map<Integer, Integer> feedItemCount = new HashMap<>();

        for (CountryData countryData : foodTable.values()) {
            for (ItemData item : countryData.items.values()) {
                int quantity = item.yearlyQuantities.getOrDefault(year, 0);
                if (quantity > 0) {
                    foodItemCount.put(item.itemCode, foodItemCount.getOrDefault(item.itemCode, 0) + 1);
                }
            }
        }
        for (CountryData countryData : feedTable.values()) {
            for (ItemData item : countryData.items.values()) {
                int quantity = item.yearlyQuantities.getOrDefault(year, 0);
                if (quantity > 0) {
                    feedItemCount.put(item.itemCode, feedItemCount.getOrDefault(item.itemCode, 0) + 1);
                }
            }
        }
        printMostCommonItem(foodItemCount, "food", year);
        printMostCommonItem(feedItemCount, "feed", year);
    }
    private void printMostCommonItem(Map<Integer, Integer> itemCountMap, String type, int year) {
        int mostCommonItem = -1;
        int highestCount = 0;

        for (Map.Entry<Integer, Integer> entry : itemCountMap.entrySet()) {
            int itemCode = entry.getKey();
            int count = entry.getValue();
            if (count > highestCount) {
                highestCount = count;
                mostCommonItem = itemCode;
            }
        }
        if (mostCommonItem != -1) {
            String itemName = getItemNameByCode(mostCommonItem);
            System.out.println("Most common " + type + " item in " + year + ": " + itemName + " (Count: " + highestCount + ")");
        } else {
            System.out.println("No " + type + " items found for the year " + year);
        }
    }


    // Problem 3: List the total number of items used as food or feed of all countries
    public void printTotalItemsUsedAsFoodOrFeed() {
        Set<Integer> foodItems = new HashSet<>();
        Set<Integer> feedItems = new HashSet<>();

        for (CountryData countryData : foodTable.values()) {
            for (ItemData item : countryData.items.values()) {
                foodItems.add(item.itemCode);
            }
        }
        for (CountryData countryData : feedTable.values()) {
            for (ItemData item : countryData.items.values()) {
                feedItems.add(item.itemCode);
            }
        }
        System.out.println("Total unique items used as food: " + foodItems.size());
        System.out.println("Total unique items used as feed: " + feedItems.size());
    }



    //    Problem 4: Which country has performed best from the year 2000 to 2010 (use step 3).

    public String getBestPerformingCountry(int startYear, int endYear) {
        return getPerformanceSummary(startYear, endYear, true);
    }

    //    Problem 5: Which country has performed worst from the year 2000 to 2010 (use step 3).
    public String getWorstPerformingCountry(int startYear, int endYear) {
        return getPerformanceSummary(startYear, endYear, false);
    }
    private String getPerformanceSummary(int startYear, int endYear, boolean findBest) {
        String bestOrWorstCountry = null;
        int targetQuantity = findBest ? Integer.MIN_VALUE : Integer.MAX_VALUE;

        // Combine all countries from food and feed tables
        Set<String> allCountries = new HashSet<>(foodTable.keySet());
        allCountries.addAll(feedTable.keySet());

        for (String countryCode : allCountries) {
            int countryTotal = calculateTotalQuantityForCountry(countryCode, startYear, endYear);

            // Find the best or worst country based on the target criteria
            if ((findBest && countryTotal > targetQuantity) || (!findBest && countryTotal < targetQuantity)) {
                targetQuantity = countryTotal;
                bestOrWorstCountry = countryCode;
            }
        }
        // Return result as a readable message
        if (bestOrWorstCountry != null) {
            String performanceType = findBest ? "Best" : "Worst";
            return performanceType + " performing country from " + startYear + " to " + endYear + ": " + bestOrWorstCountry;
        } else {
            return "No data available for the specified range.";
        }
    }
    private int calculateTotalQuantityForCountry(String countryCode, int startYear, int endYear) {
        int totalQuantity = 0;

        CountryData foodData = foodTable.get(countryCode);
        CountryData feedData = feedTable.get(countryCode);

        if (foodData != null) {
            totalQuantity += getTotalQuantityInRange(foodData, startYear, endYear);
        }
        if (feedData != null) {
            totalQuantity += getTotalQuantityInRange(feedData, startYear, endYear);
        }

        return totalQuantity;
    }
    private int getTotalQuantityInRange(CountryData countryData, int startYear, int endYear) {
        int total = 0;
        for (ItemData item : countryData.items.values()) {
            for (int year = startYear; year <= endYear; year++) {
                total += item.yearlyQuantities.getOrDefault(year, 0);
            }
        }
        return total;
    }

}

    public class PBL {
    public static void main(String[] args) {
        DataProcessor processor = new DataProcessor();
        // Specify the file path of the data file
        String filePath = "D:\\3rd semester\\DSAJAVA\\FAO.csv";
        processor.loadData(filePath);


        // Test: Generate stacks for a specific country and year

        //String countryCode = "AFG"; // Example country code

        System.out.println();
        processor.listTopItemsForTopCountryInYear(2002);
        System.out.println();
        //processor.createStacksForCountryYear(countryCode, year);

        // Test: Print top items in a specific year
        int year = 2006;
        System.out.println("\nTop items in year " + year + ":");
        processor.printTopItemsInYear(year);

        // Test: Print most common items in a specific year
        System.out.println("\nMost common items in year " + year + ":");
        processor.printMostCommonItemsInYear(year);
        System.out.println();
        //Test:Problem 3
        processor.printTotalItemsUsedAsFoodOrFeed();
        System.out.println();

        // Display best and worst-performing countries from 2000 to 2010
        System.out.println(processor.getBestPerformingCountry(2000, 2010));
        System.out.println(processor.getWorstPerformingCountry(2000, 2010));
    }
}