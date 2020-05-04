package ch05;

import ch05.classfile.beans.impl.CodeAttribute;
import ch05.classfile.beans.MemberInfo;
import ch05.instructions.Factory;
import ch05.instructions.Instruction;
import ch05.instructions.base.BytecodeReader;
import ch05.rtda.Frame;
import ch05.rtda.Thread;

import java.util.Arrays;

public class Interpreter {
    public void interpret(MemberInfo memberInfo){
        CodeAttribute codeAttr = memberInfo.codeAttribute();
        // 编译时已经给出局部变量表和操作数栈的大小
        int maxLocals = codeAttr.maxLocals;
        int maxStack = codeAttr.maxStack;
        // 指令的二进制格式
        byte[] byteCode = codeAttr.code;
        // 其他代码
        Thread thread = new Thread();
        Frame frame = thread.NewFrame(thread,maxLocals,maxStack);
        thread.pushFrame(frame);
//        defer catchErr(frame);
        loop(thread,byteCode);
    }

    /**
     * 回到interpert方法，我们的解释器目前还没有办法优雅的结束运行，因为每个方法的最后一条指令都是某个return质量，
     * 而还没有实现return指令，所有方法在执行过程值必定会出现错误，此时解释器逻辑会跳转到catchError函数
     */
//    public void catchErr(Frame frame){
//
//    }

    public void loop(Thread thread,byte[] bytecode){
        Frame frame = thread.popFrame();
        BytecodeReader reader = new BytecodeReader();
        try {
            while (true) {
                int pc = frame.nextPC;
                // 设置程序计数器
                thread.setPc(pc);
                //decode解码指令
                reader.Reset(bytecode, pc);
                int opcode = reader.ReadUint8();
                Instruction inst = Factory.NewInstruction(opcode);
                inst.FetchOperands(reader);
                frame.nextPC = reader.pc;

                //execute执行
                System.out.printf("pc:%2d inst:%s %s\n", pc, inst.getClass().getSimpleName(), inst.getClass().getName());
                inst.Execute(frame);
            }
        }catch (Exception e){
            System.out.println("localvars"+frame.localVars);
            Arrays.stream(frame.localVars.vars).forEach(System.out::println);
            System.out.println("operandstack");
            Arrays.stream(frame.operandStack.slots).forEach(System.out::println);
        }
    }
}
