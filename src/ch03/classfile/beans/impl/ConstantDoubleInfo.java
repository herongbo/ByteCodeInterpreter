package ch03.classfile.beans.impl;

import ch03.classfile.ClassReader;
import ch03.classfile.beans.ConstantInfo;

public class ConstantDoubleInfo extends ConstantInfo {
    public int tag;
    public long bytes;
    public double val;

    @Override
    /**
     *  ？将long类型转换double类型
     */
    public void readInfo(ClassReader reader) {
        this.bytes = reader.readUnit64();
        System.out.println(Double.longBitsToDouble(bytes));
        this.val = Double.longBitsToDouble(bytes);
    }
}
