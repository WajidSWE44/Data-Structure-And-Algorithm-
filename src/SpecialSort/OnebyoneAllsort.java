package SpecialSort;

import javax.swing.*;
import java.awt.*;

public class OnebyoneAllsort extends JPanel {
    private int[] array;
    private int barWidth;
    private int delay;

    public OnebyoneAllsort(int[] array, int delay) {
        this.array = array;
        this.barWidth = Math.max(1, 800 / array.length);
        this.delay = delay;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < array.length; i++) {
            int barHeight = array[i];
            g.setColor(Color.GREEN);
            g.fillRect(i * barWidth, getHeight() - barHeight, barWidth, barHeight);

            // Draw the label on top of the bar
            g.setColor(Color.BLACK);
            g.drawString(String.valueOf(array[i]), i * barWidth + barWidth / 4, getHeight() - barHeight - 5);
        }
    }

    public void visualizeSort(String sortType) {
        new Thread(() -> {
            long startTime = System.nanoTime(); // Start timing
            switch (sortType) {
                case "InsertionSort":
                    insertionSort();
                    break;
                case "QuickSort":
                    quickSort(0, array.length - 1);
                    break;
                case "BubbleSort":
                    bubbleSort();
                    break;
                case "HeapSort":
                    heapSort();
                    break;
                // Add other sorting methods if needed
            }
            long endTime = System.nanoTime(); // End timing
            long duration = endTime - startTime;
            System.out.println(sortType + " took " + (duration / 1_000_000.0) + " milliseconds.");
        }).start();
    }

    // Insertion Sort
    private void insertionSort() {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
                repaint();
                sleep();
            }
            array[j + 1] = key;
            repaint();
            sleep();
        }
    }

    // Quick Sort
    private void quickSort(int low, int high) {
        if (low < high) {
            int pi = partition(low, high);
            quickSort(low, pi - 1);
            quickSort(pi + 1, high);
            repaint();
            sleep();
        }
    }

    private int partition(int low, int high) {
        int pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                swap(i, j);
            }
        }
        swap(i + 1, high);
        return i + 1;
    }

    // Bubble Sort
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

    // Heap Sort
    private void heapSort() {
        int n = array.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(n, i);
        }
        for (int i = n - 1; i > 0; i--) {
            swap(0, i);
            heapify(i, 0);
            repaint();
            sleep();
        }
    }

    private void heapify(int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && array[left] > array[largest]) {
            largest = left;
        }

        if (right < n && array[right] > array[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(i, largest);
            heapify(n, largest);
        }
    }

    private void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private void sleep() {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sort Visualization");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Create an array of random values
        int[] array = new int[30];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 500 + 10);
        }

        OnebyoneAllsort visualizer = new OnebyoneAllsort(array, 400);
        frame.add(visualizer);
        frame.setVisible(true);

        // Example to visualize different sorts
//         visualizer.visualizeSort("InsertionSort"); // Uncomment to visualize other sorts
//         visualizer.visualizeSort("QuickSort");
//        visualizer.visualizeSort("BubbleSort");
         visualizer.visualizeSort("HeapSort");

    }
}
