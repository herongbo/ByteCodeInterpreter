package ch05.rtda;

public class Frame {
    public Frame lower;
    public LocalVars localVars;
    public OperandStack operandStack;
    public Thread thread;
    public int nextPC;

    public Frame(Thread thread,int maxLocals, int maxStack){
        System.out.println("init frame "+ thread + maxLocals + maxStack);
        this.thread = thread;
        this.localVars = new LocalVars(maxLocals);
        this.operandStack = new OperandStack(maxStack);
    }
}
