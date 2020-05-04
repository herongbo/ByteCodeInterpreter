package ch05.instructions.base;

import ch05.rtda.Frame;

import java.util.Arrays;

public class Branch_logic {
    public static void Branch(Frame frame,int offset){

        int pc = frame.thread.PC();
        int nextPC = pc + offset;
        frame.nextPC = nextPC;
    }
}
