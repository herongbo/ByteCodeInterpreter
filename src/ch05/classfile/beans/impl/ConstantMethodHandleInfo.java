package ch05.classfile.beans.impl;

import ch05.classfile.ClassReader;
import ch05.classfile.beans.ConstantInfo;

/**
 * 给出字段或方法的名称和描述符
 * CONSTANT_Class_Info和CONSTANAT_NameAndType_info加在一起可以唯一确定一个字段
 * 或者方法，其结构如下
 */

/**
 * 字段或方法名由name_index给出，字段或方法的描述符由name_index给出
 */
public class ConstantMethodHandleInfo extends ConstantInfo {
    public int tag;
    public int referenceKind;
    public int referenceIndex;

    @Override
    /**
     *  readInfo先读取一个uint32数据，然后把它转型成int32类型
     */
    public void readInfo(ClassReader reader) {
        this.referenceKind = (int) reader.readUint8();
        this.referenceIndex = (int) reader.readUint16();
    }
}

