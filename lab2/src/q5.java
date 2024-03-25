import java.util.Scanner;

public class q5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number =input.nextInt();
        for (int i = 0; i <number ; i++) {
            int n=input.nextInt();
            int h = 0;
            int count=0;
          while (n!=0&&n!=1) {
              for (int j = 1; j < 100000; j++) {
                  if (2 * j + 3 * (j * (j - 1) / 2) <= n && 2 * (j + 1) + 3 * (j * (j + 1) / 2) > n) {
                      h = j;
                      count++;
                     break;
                  }
              }
              n = n - 2 * h - 3 * (h * (h - 1) / 2);
          }
            System.out.println(count);
            }
        }
        }
