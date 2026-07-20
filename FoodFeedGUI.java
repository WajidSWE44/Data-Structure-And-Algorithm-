package Algorithm;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Stack;

public class FoodFeedGUI extends JFrame {
    private CountryData countryData;
    private CountryStacks countryStacks;
    private ItemLinkedList itemList;
    private JTextArea resultArea;

    public FoodFeedGUI() {
        setTitle("Food and Feed Data System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        countryData = new CountryData();
        countryStacks = new CountryStacks();
        itemList = new ItemLinkedList();

        // Create panels
        JPanel inputPanel = new JPanel();
        JPanel actionPanel = new JPanel();
        resultArea = new JTextArea();
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);

        // Add panels to JFrame
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(actionPanel, BorderLayout.SOUTH);

        // Initialize GUI components
        setupInputPanel(inputPanel);
        setupActionPanel(actionPanel);

        // Simulate loading of data
        loadData();
    }

    private void setupInputPanel(JPanel inputPanel) {
        inputPanel.setLayout(new FlowLayout());
        JLabel countryLabel = new JLabel("Country Code:");
        JTextField countryField = new JTextField(10);

        JLabel yearLabel = new JLabel("Year:");
        JTextField yearField = new JTextField(4);

        JButton searchButton = new JButton("Search Top Items");

        searchButton.addActionListener(e -> {
            String countryCode = countryField.getText();
            int year = Integer.parseInt(yearField.getText());
            searchTopItems(countryCode, year);
        });

        inputPanel.add(countryLabel);
        inputPanel.add(countryField);
        inputPanel.add(yearLabel);
        inputPanel.add(yearField);
        inputPanel.add(searchButton);
    }

    private void setupActionPanel(JPanel actionPanel) {
        JButton commonItemsButton = new JButton("Most Common Items in 2006");
        JButton totalItemsButton = new JButton("Total Items Count");

        commonItemsButton.addActionListener(e -> showCommonItems(2006));
        totalItemsButton.addActionListener(e -> showTotalItems());

        actionPanel.add(commonItemsButton);
        actionPanel.add(totalItemsButton);
    }

    // Search top items for a specific country and year
    private void searchTopItems(String countryCode, int year) {
        Stack<Integer> foodStack = countryStacks.foodStacks.get(countryCode).get(year);
        Stack<Integer> feedStack = countryStacks.feedStacks.get(countryCode).get(year);

        int topFoodItemCode = foodStack.peek();
        int topFeedItemCode = feedStack.peek();

        String topFoodItemName = itemList.getItemName(topFoodItemCode);
        String topFeedItemName = itemList.getItemName(topFeedItemCode);

        resultArea.setText("Top food item in " + year + ": " + topFoodItemName + "\n");
        resultArea.append("Top feed item in " + year + ": " + topFeedItemName + "\n");
    }

    // Display most common items for 2006
    private void showCommonItems(int year) {
        // Implement logic similar to the backend to find common items
        resultArea.setText("Most common items in 2006...\n");
    }

    // Show total items count across countries
    private void showTotalItems() {
        resultArea.setText("Total items count across countries...\n");
    }

    // Simulate loading of data into hash tables and linked lists
    private void loadData() {
        // Populate countryData, itemList, and stacks
        itemList.addItem(1001, "Rice");
        itemList.addItem(1002, "Wheat");
        itemList.addItem(1003, "Corn");

        // Example country and yearly data
        CountryData.FoodFeedData riceData = new CountryData.FoodFeedData(1001, "Tonnes");
        riceData.addYearlyData(2002, 500);
        riceData.addYearlyData(2006, 600);

        CountryData.FoodFeedData wheatData = new CountryData.FoodFeedData(1002, "Tonnes");
        wheatData.addYearlyData(2002, 300);
        wheatData.addYearlyData(2006, 400);

        countryData.foodData.put("USA", new HashMap<>());
        countryData.foodData.get("USA").put(1001, riceData);
        countryData.foodData.get("USA").put(1002, wheatData);

        // Create stacks
        countryStacks.createStacks("USA", countryData.foodData.get("USA"), true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FoodFeedGUI().setVisible(true));
    }
}

