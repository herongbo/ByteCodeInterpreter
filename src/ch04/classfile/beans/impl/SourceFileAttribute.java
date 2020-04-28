package ch04.classfile.beans.impl;

import ch04.classfile.ClassReader;
import ch04.classfile.beans.AttributeInfo;
import ch04.classfile.beans.ConstantInfo;

import java.io.UTFDataFormatException;

public class SourceFileAttribute extends AttributeInfo {
    int attributeNameIndex;
    int attributeLength;
    int sourcefileIndex;
    ConstantInfo[] cp;
    public SourceFileAttribute(ConstantInfo[] cp){
        this.cp = cp;
    }

    @Override
    public void readInfo(ClassReader reader){
        this.sourcefileIndex = (int)reader.readUint16();
    }

    public String fileName(){
        return ((ConstantUTF8Info)this.cp[this.sourcefileIndex]).string;
    }

    @Override
    public String toString(){
        return "\tsource_file_index" + this.sourcefileIndex;
    }
}
