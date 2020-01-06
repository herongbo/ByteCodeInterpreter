package ch03.classfile.beans;

import ch03.classfile.ClassReader;


public abstract class ConstantInfo {
    int tag;
    int[] info[];

    public abstract void readInfo(ClassReader classReader);
}