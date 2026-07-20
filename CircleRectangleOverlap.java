public class CircleRectangleOverlap {

    public static boolean checkOverlap(int radius, int xCenter, int yCenter,
                                       int x1, int y1, int x2, int y2) {

        int xClosest = Math.max(x1, Math.min(xCenter, x2));
        int yClosest = Math.max(y1, Math.min(yCenter, y2));


        int distanceSquared = (xCenter - xClosest) * (xCenter - xClosest) +
                (yCenter - yClosest) * (yCenter - yClosest);


        return distanceSquared <= radius * radius;
    }

    public static void main(String[] args) {
        // Example 1
        System.out.println(checkOverlap(1, 0, 0, 1, -1, 3, 1)); // Output: true

        // Example 2
        System.out.println(checkOverlap(1, 1, 1, 1, -3, 2, -1)); // Output: false

        // Example 3
        System.out.println(checkOverlap(1, 0, 0, -1, 0, 0, 1)); // Output: true
    }
}
