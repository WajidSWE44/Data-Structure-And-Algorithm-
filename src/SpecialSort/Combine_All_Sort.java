package SpecialSort;

import javax.swing.*;
import java.awt.*;

public class Combine_All_Sort extends JPanel {
    private int[] array;
    private int barWidth;
    private int delay;

    public Combine_All_Sort(int[] array, int delay) {
        this.array = array;
        this.barWidth = Math.max(1, 800 / array.length);  // Ensure bars are visible even for larger arrays
        this.delay = delay;
    }

    @Override
    protected void paintComponent(Graphics g) {  //g--> graphic library
        super.paintComponent(g);
        for (int i = 0; i < array.length; i++) {
            int barHeight = array[i];
            g.setColor(Color.BLUE);
            g.fillRect(i * barWidth, getHeight() - barHeight, barWidth, barHeight);

            // Draw the label on top of the bar
            g.setColor(Color.BLACK);
            g.drawString(String.valueOf(array[i]), i * barWidth + barWidth / 4, getHeight() - barHeight - 5);
        }
    }

    public void visualizeSort(String sortType) {
        new Thread(() -> {
            switch (sortType) {
                case "BubbleSort":
                    bubbleSort();
                    break;
                case "SelectionSort":
                    selectionSort();
                    break;
                case "InsertionSort":
                    insertionSort();
                    break;
                case "MergeSort":
                    mergeSort(0, array.length - 1);
                    break;
                case "QuickSort":
                    quickSort(0, array.length - 1);
                    break;
                case "HeapSort":
                    heapSort();
                    break;
            }
        }).start();
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

    // Selection Sort
    private void selectionSort() {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            swap(i, minIndex);
            repaint();
            sleep();
        }
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
            }
            array[j + 1] = key;
            repaint();
            sleep();
        }
    }

    // Merge Sort
    private void mergeSort(int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(left, mid);
            mergeSort(mid + 1, right);
            merge(left, mid, right);
            repaint();
            sleep();
        }
    }

    private void merge(int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];

        System.arraycopy(array, left, L, 0, n1);
        System.arraycopy(array, mid + 1, R, 0, n2);

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
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
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                swap(i, j);
            }
        }
        swap(i + 1, high);
        return i + 1;
    }

    // Heap Sort
    private void heapSort() {
        int n = array.length;
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(n, i);

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

        if (left < n && array[left] > array[largest])
            largest = left;

        if (right < n && array[right] > array[largest])
            largest = right;

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
            Thread.sleep(delay);  // Slows down the sorting process for visualization
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sort Visualization");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        int[] array = new int[30];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 500 + 10);
        }

        Combine_All_Sort visualizer = new Combine_All_Sort(array, 50);
        frame.add(visualizer);
        frame.setVisible(true);

        // Example to visualize Bubble Sort (replace with others for testing)
        visualizer.visualizeSort("MergeSort");
    }
}
