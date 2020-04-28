package ch04.classfile.beans.impl;

import ch04.classfile.ClassReader;
import ch04.classfile.beans.AttributeInfo;

public class SyntheticAttribute extends AttributeInfo {

    @Override
    public void readInfo(ClassReader reader){
        // read nothing
    }
}
