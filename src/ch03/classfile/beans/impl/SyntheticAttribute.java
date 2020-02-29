package ch03.classfile.beans.impl;

import ch03.classfile.ClassReader;
import ch03.classfile.beans.AttributeInfo;

public class SyntheticAttribute extends AttributeInfo {

    @Override
    public void readInfo(ClassReader reader){
        // read nothing
    }
}
