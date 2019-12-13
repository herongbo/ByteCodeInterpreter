package ch02.utils;

public class ByteToString {
    public String getString(byte[] data) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < data.length; i++) {
            sb.append(Integer.toString(data[i]));
            sb.append(" ");
        }
        return sb.toString();
    }
}
