package ch04.classfile.beans;

import ch04.classfile.ClassReader;


public abstract class ConstantInfo {
    int tag;
    int[] info[];

    public abstract void readInfo(ClassReader classReader);
}