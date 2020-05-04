package ch05.rtda;

public class Thread {

        int pc;
        Stack stack;

        public Thread(){
            stack = new Stack(1024);
        }

        public int PC(){
            // 设置初始栈的大小
            return this.pc;
        }

        public void setPc(int pc) {
            this.pc = pc;
        }

        public void pushFrame(Frame frame){
            System.out.println(stack==null);
            this.stack.push(frame);
        }

        public Frame popFrame(){
            return this.stack.pop();
        }

        public Frame currentFrame(){
            return this.stack.top();
        }

        public Frame NewFrame(Thread thread,int maxLocals,int maxStack){
            System.out.println("set frame maxlocal "+maxLocals+" maxstack "+maxStack);
            return new Frame(thread,maxLocals,maxStack);
        }
}
