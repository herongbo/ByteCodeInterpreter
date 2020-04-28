package ch04.RunTime;

public class Stack {
    int maxSize;
    int size;
    Frame top;
    public Stack(int maxSize){

    }

    /**
     * maxSize字段保存栈的容量（最多可以容纳多少帧），size字段保存栈的当前大小，top字段保存栈顶指针
     * @param frame
     */
    public void push(Frame frame){
        if (this.size >= this.maxSize){
            new StackOverflowError();
        }
        if (this.top != null){
            frame.lower = this.top;
        }
        this.top = frame;
        this.size++;
    }

    /**
     * 如果栈顶满了，按照Java虚拟机规范，应该抛出StackOverflowError异常，在第10章才会讨论异常，这里先终止执行，pop方法把栈顶帧弹出
     */
    public Frame pop(){
        if (this.top==null){
            new Exception("jvm stack is empty");
        }
        top = this.top;
        this.top = top.lower;
        top.lower = null;
        this.size--;
        return top;
    }

    public Frame top(){
        if (this.top==null){
            new Exception("jvm stack is empty");
        }
        return this.top;
    }

}
