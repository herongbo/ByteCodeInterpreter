package ch04.rtda;

public class Frame {
    Frame lower;
    LocalVars localVars;
    OperandStack operandStack;

    public Frame(int maxLocals, int maxStack){
        this.localVars = new LocalVars(maxLocals);
        this.operandStack = new OperandStack(maxStack);
    }
}
