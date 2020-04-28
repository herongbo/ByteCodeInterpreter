package ch04.classfile.beans.impl;

import ch04.classfile.ClassReader;
import ch04.classfile.beans.ConstantInfo;

public class ConstantUTF8Info extends ConstantInfo {
    public int tag;
    public int length;
    public byte[] bytes;
    public String string;

    @Override
    /**
     *  readInfo先读取一个uint32数据，然后把它转型成int32类型
     */
    public void readInfo(ClassReader reader) {
        this.length = (int)reader.readUint16();
        bytes = reader.readBytes(length);
        string = new String(bytes);
    }
}
