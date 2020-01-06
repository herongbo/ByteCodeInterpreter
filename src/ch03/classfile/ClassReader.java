package ch03.classfile;

public class ClassReader {
    byte[] data;

    public ClassReader(byte[] data) {
        this.data = data;
    }

    // 读取一个字节
    public long readUint8() {
        long value = data[0] & 0xff;
        System.out.println(">" + Long.toString(value, 16));

        // 修改数组
        byte[] temp = new byte[data.length - 1];
        System.arraycopy(data, 1, temp, 0, temp.length);
        data = temp;
        return value;
    }

    // 读取两个字节
    public long readUint16() {
        long value = (data[0] & 0xff) * 0xff + data[1] & 0xff;
        System.out.println(">>" + (data[0] & 0xff) + " " + (data[1] & 0xff));
        // 修改数组
        byte[] temp = new byte[data.length - 2];
        System.arraycopy(data, 2, temp, 0, temp.length);
        data = temp;
        return value;
    }

    // 读取 u4类型的字节
    public long readUnit32() {
        String str = Integer.toString(data[0] & 0xff, 16)
                + Integer.toString(data[1] & 0xff, 16)
                + Integer.toString(data[2] & 0xff, 16)
                + Integer.toString(data[3] & 0xff, 16);
        long value = Long.parseLong(str, 16);
        System.out.println(">>>>" + Long.toString(value, 16));

        // 修改数组
        byte[] temp = new byte[data.length - 4];
        System.arraycopy(data, 4, temp, 0, temp.length);
        data = temp;

        return value;
    }

    public long readUnit64() {
        long value = (data[0] & 0xff) * 0xff + data[1] & 0xff;
        System.out.println(">>" + (data[0] & 0xff) + " " + (data[1] & 0xff));
        // 修改数组
        byte[] temp = new byte[data.length - 2];
        System.arraycopy(data, 2, temp, 0, temp.length);
        data = temp;
        return value;
    }

    //  readUint16s 读取uint16表，表的大小由开头的uint16数据指出，代码如下
    public static String read16s() {
        System.err.println("这个方法还没有完成");
        System.exit(-1);
        return null;
    }

    // 最后一个方法是readBytes,用于读取指定数量的字节，代码如下
    public byte[] readBytes(int n) {
        // 保存剩余的字节，长度为 data.length - n
        byte[] temp = new byte[data.length - n];
        // 记录需要提取的字节，长度为 n
        byte[] keep = new byte[n];
        // 复制需要返回的字节
        System.arraycopy(data, 0, keep, 0, keep.length);
        // 复制剩下来的字节
        System.arraycopy(data, n, temp, 0, temp.length);
        data = temp;
        return keep;
    }


}