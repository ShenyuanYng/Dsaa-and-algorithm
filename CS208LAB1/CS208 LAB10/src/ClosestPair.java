import java.util.Arrays;
import java.util.Scanner;

class Point {
    double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

public class ClosestPair {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = scanner.nextInt();

        Point[] points = new Point[n];

        for (int i = 0; i < n; i++) {
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();
            points[i] = new Point(x, y);
        }

        ClosestPair closestPair = new ClosestPair();
        System.out.println( Math.round(Math.pow(closestPair.closestPairDistance(points),2)));
    }

    public double closestPairDistance(Point[] points) {
        Arrays.sort(points, (p1, p2) -> Double.compare(p1.x, p2.x));
        return closestPairDistanceUtil(points, 0, points.length - 1);
    }

    private double closestPairDistanceUtil(Point[] points, int left, int right) {
        if (right - left <= 3) {
            return bruteForce(points, left, right);
        }

        int mid = (left + right) / 2;
        double leftClosest = closestPairDistanceUtil(points, left, mid);
        double rightClosest = closestPairDistanceUtil(points, mid + 1, right);

        double minClosest = Math.min(leftClosest, rightClosest);

        return Math.min(minClosest, closestSplitPair(points, left, right, minClosest));
    }

    private double bruteForce(Point[] points, int left, int right) {
        double minDistance = Double.POSITIVE_INFINITY;

        for (int i = left; i <= right; i++) {
            for (int j = i + 1; j <= right; j++) {
                double distance = distance(points[i], points[j]);
                minDistance = Math.min(minDistance, distance);
            }
        }

        return minDistance;
    }

    private double closestSplitPair(Point[] points, int left, int right, double minClosest) {
        double midX = (points[left].x + points[right].x) / 2;
        Point[] strip = Arrays.copyOfRange(points, left, right + 1);
        Arrays.sort(strip, (p1, p2) -> Double.compare(p1.y, p2.y));

        for (int i = 0; i < strip.length; i++) {
            for (int j = i + 1; j < strip.length && (strip[j].y - strip[i].y) < minClosest; j++) {
                double distance = distance(strip[i], strip[j]);
                minClosest = Math.min(minClosest, distance);
            }
        }

        return minClosest;
    }

    private double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }
}
