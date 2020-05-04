package ch05.classfile.beans.impl;

import ch05.classfile.ClassReader;
import ch05.classfile.beans.AttributeInfo;

public class SyntheticAttribute extends AttributeInfo {

    @Override
    public void readInfo(ClassReader reader){
        // read nothing
    }
}
