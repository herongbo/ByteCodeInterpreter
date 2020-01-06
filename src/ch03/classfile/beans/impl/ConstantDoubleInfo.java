package ch03.classfile.beans.impl;

import ch03.classfile.ClassReader;
import ch03.classfile.beans.ConstantInfo;

public class ConstantDoubleInfo extends ConstantInfo {
    int tag;
    long bytes;
    double val;

    @Override
    /**
     *  ？将long类型转换double类型
     */
    public void readInfo(ClassReader reader) {
        this.bytes = reader.readUnit64();
        this.val = (double)bytes;
    }
}
