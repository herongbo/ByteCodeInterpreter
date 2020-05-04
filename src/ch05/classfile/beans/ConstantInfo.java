package ch05.classfile.beans;

import ch05.classfile.ClassReader;


public abstract class ConstantInfo {
    int tag;
    int[] info[];

    public abstract void readInfo(ClassReader classReader);
}