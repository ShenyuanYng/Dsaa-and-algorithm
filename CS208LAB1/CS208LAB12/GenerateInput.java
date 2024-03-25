import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class GenerateInput {
    public static void main(String[] args) {
        try {
            FileWriter fileWriter = new FileWriter("input.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);

            // Number of test cases
            printWriter.println(1);

            // Number of nodes and edges
            int n = 2000;
            int m = 2000;
            printWriter.println(n + " " + m);

            // Generating edges with weight -10000
            for (int i = 1; i <= n; i++) {
                int u = i;
                int v = (i % n) + 1;
                printWriter.println(u + " " + v + " " + -10000);
            }

            printWriter.close();
            System.out.println("Input file generated successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
