import java.io.FileInputStream;
import java.io.IOException;

public class FileTypeParser {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java FileTypeDetector <file1> <file2> <file3> ...");
            System.exit(1);
        }

        for (String fileName : args) {
            try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
                // Read the first few bytes to determine the file type
                byte[] headerBytes = new byte[8];
                int bytesRead = fileInputStream.read(headerBytes);

                if (bytesRead >= 4) {
                    String fileHeader = bytesToHex(headerBytes, 4);

                    // Determine the file type based on the file header
                    String fileType = getFileType(fileHeader);
                    System.out.println("Filename: " + fileName+" " +"File Header:" +fileHeader + " " + "File  Type: " + fileType);
                } else {
                    System.out.println("File: " + fileName + "  Unable to determine file type.");
                }

            } catch (IOException e) {
                System.err.println("Error reading file: " + fileName);
                e.printStackTrace();
            }
        }
    }

    private static String bytesToHex(byte[] bytes, int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(String.format("%02x", bytes[i]));
        }
        return sb.toString();
    }

    private static String getFileType(String fileHeader) {
        switch (fileHeader) {
            case "89504e47":
                return "png";
            case "504b0304":
                return "zip or jar";
            case "cafebabe":
                return "class";
            default:
                return "Unknown";
        }
    }
}
