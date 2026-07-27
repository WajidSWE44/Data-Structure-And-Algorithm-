package SpecialSort;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class SortVisualizer extends JPanel {
    private int[] array;
    private int barWidth;
    private int delay;

    public SortVisualizer(int[] array, int delay) {
        this.array = array;
        this.barWidth = Math.max(1, 800 / array.length);  // Ensure bars are visible even for larger arrays
        this.delay = delay;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < array.length; i++) {
            int barHeight = array[i];
            g.setColor(Color.BLUE);
            g.fillRect(i * barWidth, getHeight() - barHeight, barWidth, barHeight);
        }
    }

    public void visualizeSort() {
        new Thread(() -> {
            bubbleSort();  // You can replace this with other sorts like insertionSort(), mergeSort(), etc.
        }).start();
    }

    private void bubbleSort() {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(j, j + 1);
                    repaint();
                    sleep();
                }
            }
        }
    }

    private void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private void sleep() {
        try {
            Thread.sleep(delay);  // Slows down the sorting process for visualization
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Add other sorts like Insertion Sort, Merge Sort here

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sort Visualization");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        int[] array = new int[30];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 500 + 10);
        }

        SortVisualizer visualizer = new SortVisualizer(array, 50);
        frame.add(visualizer);
        frame.setVisible(true);

        visualizer.visualizeSort();
    }
}
