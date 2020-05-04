package ch05.instructions.base;

import ch05.instructions.Instruction;
import ch05.rtda.Frame;
import ch05.rtda.OperandStack;
/**
 * 取余指令
 */
public class IREM implements Instruction {
    @Override
    public void FetchOperands(BytecodeReader reader) {

    }

    @Override
    public void Execute(Frame frame) {
        OperandStack stack = frame.operandStack;
        int v2 = stack.popInt();
        int v1 = stack.popInt();
        if (v2 == 0){
            new Exception("java.lang.ArithmeticException: /by zero");
        }
        int result = v1%v2;
        stack.pushInt(result);
    }
}
