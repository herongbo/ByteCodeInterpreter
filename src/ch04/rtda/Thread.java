package ch04.rtda;

public class Thread {

        int pc;
        Stack stack;

        public Thread(){

        }

        public int PC(){
            // 设置初始栈的大小
            return this.pc;
        }

        public void setPc(int pc) {
            this.pc = pc;
        }

        public void pushFrame(Frame frame){
         this.stack.push(frame);
        }

        public Frame popFrame(){
            return this.stack.pop();
        }

        public Frame currentFrame(){
            return this.stack.top();
        }
}
