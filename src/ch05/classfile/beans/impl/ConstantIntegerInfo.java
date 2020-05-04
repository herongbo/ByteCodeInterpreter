package ch05.classfile.beans.impl;

import ch05.classfile.ClassReader;
import ch05.classfile.beans.ConstantInfo;

/*
CONSTANT_Integer_info使用4字节存储整数常量，其结构定义如下
CONSTANT_Integer_info和后边将要接收的其他三种数字常量五乱是结构还是，实现都非常相似
所以爸爸他们定义在同一个文件中，定义ConstatnIntegerInfo结构体
CONSTANT_Integer_info正好可以容纳一个Java的int形常量，但实际上比int更小的
boolean byte short char类型的常量也可以放在CONSTANT_Integee_info常量
 */
public class ConstantIntegerInfo extends ConstantInfo {
    public int tag;
    public int bytes;
    public int val;

    @Override
    /**
     *  readInfo先读取一个uint32数据，然后把它转型成int32类型
     */
    public void readInfo(ClassReader reader) {
        this.bytes = (int) reader.readUnit32();
        this.val = bytes;
    }
}
