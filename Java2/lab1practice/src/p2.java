public class p2 {
    public static void main(String[] args) {
        byte[] byteBuffer = { (byte) 128, 4 };
        int[] lengthOfBits = { 4, 4, 8 };

        int[] result = parseByteBuffer(byteBuffer, lengthOfBits);

        System.out.print("[");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if (i < result.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static int[] parseByteBuffer(byte[] byteBuffer, int[] lengthOfBits) {
        int[] result = new int[lengthOfBits.length];
        int currentIndex = 0;

        for (int i = 0; i < lengthOfBits.length; i++) {
            int bits = lengthOfBits[i];
            int value = readBits(byteBuffer, currentIndex, bits);
            result[i] = value;

            currentIndex += bits;
        }

        return result;
    }

    private static int readBits(byte[] byteBuffer, int startBit, int numBits) {
        int result = 0;

        for (int i = 0; i < numBits; i++) {
            int byteIndex = (startBit + i) / 8;
            int bitIndex = (startBit + i) % 8;

            byte currentByte = byteBuffer[byteIndex];
            //将当前字节右移（7 - bitIndex）位，使得目标位变为最低位，再使用 & 1 取得最低位的值（0 或 1）
            int bitValue = (currentByte >> (7 - bitIndex)) & 1;
           //移一位表示为当前结果乘以 2，将新的位值加到结果的最低位
            result = (result << 1) | bitValue;
        }

        return result;
    }
}
