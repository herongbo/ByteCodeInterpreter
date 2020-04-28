package ch04.classfile.beans.impl;

import ch04.classfile.ClassReader;
import ch04.classfile.beans.AttributeInfo;

public class LineNumberTableAttribute extends AttributeInfo {
    int attributeNameIndex;
    int attributeLength;
    LineNumberTableEntry[] lineNumberTableEntries;
    class LineNumberTableEntry{
        public int startPc;
        public int lineNumber;
    }

    @Override
    public void readInfo(ClassReader reader) {
        int lineNumberTableLength = (int) reader.readUint16();
        this.lineNumberTableEntries = new LineNumberTableEntry[lineNumberTableLength];
        for (int i = 0; i < lineNumberTableLength; i++) {
            lineNumberTableEntries[i] = new LineNumberTableEntry();
            lineNumberTableEntries[i].startPc = (int)reader.readUint16();
            lineNumberTableEntries[i].lineNumber = (int)reader.readUint16();
        }
    }
}
