package ch04.RunTime;

public class Frame {
    Frame lower;
    LocalVars localVars;
    OperandStack operandStack;

    public Frame(int maxLocals, int maxStack){
        this.localVars = new LocalVars(maxLocals);
        this.operandStack = new OperandStack(maxStack);
    }
}
