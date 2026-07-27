package Sort;

public class BubbleSort {
    public void PrintArray(int arr[] ){
     for(int i=0; i< arr.length; i++){
         System.out.print(arr[i]+" ");
     }
        System.out.println();
    }
    public static void main(String[] args) {
        BubbleSort bs = new BubbleSort();
        int [] arr = {2,5,3,1,7,6,8,4};

        for(int i=0; i< arr.length-1 ; i++){
            for(int j=0 ;j< arr.length-i-1; j++){
                if(arr[j] < arr[j+1]){
                    //swap
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    bs.PrintArray(arr);
                }
            }
        }
        bs.PrintArray(arr);
    }
}
/*
package Sort;

import javax.swing.*;
import java.awt.*;

public class BubbleSortVisualizer extends JPanel {

    private int[] arr = {2, 5, 3, 1, 7, 6, 8, 4}; // Initial array
    private int delay = 200; // Delay in milliseconds for visualization speed

    // Paint component to draw the array as bars
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.WHITE);

        // Set color and size for each bar representing an array element
        int width = getWidth() / arr.length;
        for (int i = 0; i < arr.length; i++) {
            int height = arr[i] * 50; // Scale height of the bars
            g.setColor(Color.BLUE);
            g.fillRect(i * width, getHeight() - height, width, height); // Drawing bars
            g.setColor(Color.BLACK);
            g.drawRect(i * width, getHeight() - height, width, height); // Drawing borders for bars

            // Draw the number on top of each bar
            g.setFont(new Font("Arial", Font.BOLD, 18));
            g.setColor(Color.RED);
            g.drawString(String.valueOf(arr[i]), i * width + (width / 2) - 10, getHeight() - height - 10); // Center the text
        }
    }

    // Function to perform bubble sort with visual updates
    public void bubbleSort() throws InterruptedException {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    // Repaint the panel to visualize the swap
                    repaint();

                    // Pause for a moment to see the change
                    Thread.sleep(delay);
                }
            }
        }
    }

    // Create GUI
    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Bubble Sort Visualizer");
        BubbleSortVisualizer sorter = new BubbleSortVisualizer();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.add(sorter);
        frame.setVisible(true);

        // Run sorting algorithm in a separate thread to avoid freezing the GUI
        new Thread(() -> {
            try {
                sorter.bubbleSort();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public static void main(String[] args) {
        // Schedule the GUI creation on the Event Dispatch Thread
        SwingUtilities.invokeLater(BubbleSortVisualizer::createAndShowGUI);
    }
}


*/
