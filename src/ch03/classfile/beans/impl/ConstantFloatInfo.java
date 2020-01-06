package ch03.classfile.beans.impl;

import ch03.classfile.ClassReader;
import ch03.classfile.beans.ConstantInfo;

public class ConstantFloatInfo extends ConstantInfo {
    int tag;
    int bytes;
    float val;

    @Override
    /**
     *  readInfo先读取一个uint32数据，然后把它转型成int32类型
     */
    public void readInfo(ClassReader reader) {
        this.bytes = (int) reader.readUnit32();
        this.val = (float)bytes;
    }
}
