import java.io.*;

public class p1 {
    public static void main(String[] args) throws IOException {
        // 使用绝对路径，确保文件存在于指定的位置
        String absolutePath = "E:\\DASSlab1\\Java2\\lab2practice\\src\\sample.txt";
        InputStreamReader ser = new InputStreamReader(new FileInputStream(absolutePath), "GBK");

        // 使用绝对路径，确保文件被创建在指定的位置
        String outputPath = "E:\\DASSlab1\\Java2\\lab2practice\\src\\111";
        OutputStreamWriter dest = new OutputStreamWriter(new FileOutputStream(outputPath), "UTF-8");

        int length = 0;
        while ((length = ser.read()) != -1) {
            dest.write(length);
        }

        ser.close();
        dest.close();
    }
}
