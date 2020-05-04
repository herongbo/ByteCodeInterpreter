package ch05.instructions.base;

import ch05.instructions.Instruction;
import ch05.rtda.Frame;
import ch05.rtda.OperandStack;
/**
 * 取余指令
 */
public class LREM implements Instruction {
    @Override
    public void FetchOperands(BytecodeReader reader) {

    }

    @Override
    public void Execute(Frame frame) {
        OperandStack stack = frame.operandStack;
        long v2 = stack.popLong();
        long v1 = stack.popLong();
        if (v2 == 0){
            new Exception("java.lang.ArithmeticException: /by zero");
        }
        Long result = v1%v2;
        stack.pushLong(result);
    }
}
