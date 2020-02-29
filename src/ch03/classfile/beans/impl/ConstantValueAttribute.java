package ch03.classfile.beans.impl;

import ch03.classfile.ClassReader;
import ch03.classfile.beans.AttributeInfo;

public class ConstantValueAttribute extends AttributeInfo {
    int attributeNameIndex;
    int attributeLength;
    int constantValueIndex;

    @Override
    public void readInfo(ClassReader reader){
        this.constantValueIndex = (int)reader.readUint16();
    }

    public int getConstantValueIndex(){
        return this.constantValueIndex;
    }
}
