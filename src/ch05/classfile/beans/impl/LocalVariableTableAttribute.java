package ch05.classfile.beans.impl;

import ch05.classfile.ClassReader;
import ch05.classfile.beans.AttributeInfo;

import javax.sound.sampled.FloatControl;

public class LocalVariableTableAttribute extends AttributeInfo {
    int attributeNameIndex;
    int attributeLength;
    LocalVariableTableEntry[] localVariableTableAttributes;
    class LocalVariableTableEntry{
        public int startPc;
        public int length;
        public int nameIndex;
        public int descriptorIndex;
        public int index;
    }

    @Override
    public void readInfo(ClassReader reader) {
//        this.attributeNameIndex = (int) reader.readUint16();
//        this.attributeLength = (int) reader.readUint16();
        int lineNumberTableLength = (int) reader.readUint16();
        this.localVariableTableAttributes = new LocalVariableTableEntry[lineNumberTableLength];
        for (int i = 0; i < lineNumberTableLength; i++) {
            localVariableTableAttributes[i] = new LocalVariableTableEntry();
            localVariableTableAttributes[i].startPc = (int)reader.readUint16();
            localVariableTableAttributes[i].length = (int)reader.readUint16();
            localVariableTableAttributes[i].nameIndex = (int)reader.readUint16();
            localVariableTableAttributes[i].descriptorIndex = (int)reader.readUint16();
            localVariableTableAttributes[i].index = (int)reader.readUint16();
        }
    }
}
