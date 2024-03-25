import java.io.*;

public class CharsetConvertor {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("使用方法：java CharsetConvertor <sourceFileName> <sourceEncoding> <targetEncoding>");
            System.exit(1);
        }

        String sourceFileName = args[0];
        String sourceEncoding = args[1];
        String targetEncoding = args[2];

        try {
            // 使用指定的编码从源文件读取内容
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(sourceFileName), sourceEncoding));

            // 通过将目标编码附加到原始文件名来创建目标文件名
            String targetFileName = generateTargetFileName(sourceFileName, targetEncoding);

            // 使用目标编码将内容写入目标文件
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(targetFileName), targetEncoding));

            // 执行转换
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }

            // 关闭读取器和写入器
            reader.close();
            writer.close();

            System.out.println("转换完成。目标文件：" + targetFileName);

        } catch (IOException e) {
            System.err.println("错误：" + e.getMessage());
            e.printStackTrace();
        }
    }

    private static String generateTargetFileName(String sourceFileName, String targetEncoding) {
        int dotIndex = sourceFileName.lastIndexOf('.');
        String baseFileName = (dotIndex == -1) ? sourceFileName : sourceFileName.substring(0, dotIndex);
        String extension = (dotIndex == -1) ? "" : sourceFileName.substring(dotIndex);
        return baseFileName + "_" + targetEncoding.toLowerCase() + extension;
    }
}
