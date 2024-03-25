import java.util.*;

public class PrimeConversion {
    private Set<Integer> primes; // 存储质数集合

    public PrimeConversion() {
        primes = generatePrimes();
    }

    public int findMinConversion(int a, int b) {
        if (!primes.contains(a) || !primes.contains(b)) {
            return -1; // a或b不是质数，无法转换
        }

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.offer(a);
        visited.add(a);

        int minConversion = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int current = queue.poll();

                if (current == b) {
                    return minConversion;
                }

                List<Integer> neighbors = getValidNeighbors(current);
                for (Integer neighbor : neighbors) {
                    if (!visited.contains(neighbor)) {
                        queue.offer(neighbor);
                        visited.add(neighbor);
                    }
                }
            }

            minConversion++;
        }

        return -1; // 无法转换为质数b
    }

    private Set<Integer> generatePrimes() {
        Set<Integer> primes = new HashSet<>();

        // 生成所有四位质数
        for (int i = 1000; i < 10000; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }

        return primes;
    }

    private boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    private List<Integer> getValidNeighbors(int num) {
        List<Integer> neighbors = new ArrayList<>();

        char[] digits = String.valueOf(num).toCharArray();

        for (int i = 0; i < 4; i++) {
            char originalDigit = digits[i];

            for (char c = '0'; c <= '9'; c++) {
                if (c != originalDigit) {
                    digits[i] = c;
                    int neighbor = Integer.parseInt(new String(digits));

                    if (primes.contains(neighbor)) {
                        neighbors.add(neighbor);
                    }
                }
            }

            digits[i] = originalDigit;
        }

        return neighbors;
    }

    public static void main(String[] args) {
        PrimeConversion primeConversion = new PrimeConversion();
        Scanner input = new Scanner(System.in);
        int number=input.nextInt();
        for (int i = 0; i < number; i++) {
            int a = input.nextInt();
            int b = input.nextInt();

            int minConversion = primeConversion.findMinConversion(a, b);

            if (minConversion == -1) {
                System.out.println("Impossible");
            } else {
                System.out.println( minConversion);
            }
        }
    }
}
