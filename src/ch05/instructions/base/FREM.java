package ch05.instructions.base;

import ch05.instructions.Instruction;
import ch05.rtda.Frame;
import ch05.rtda.OperandStack;

/**
 * 取余指令
 */
public class FREM implements Instruction {
    @Override
    public void FetchOperands(BytecodeReader reader) {

    }

    @Override
    public void Execute(Frame frame) {
        OperandStack stack = frame.operandStack;
        float v2 = stack.popFloat();
        float v1 = stack.popFloat();
        if (v2 == 0){
            new Exception("java.lang.ArithmeticException: /by zero");
        }
        float result = v1%v2;
        stack.pushFloat(result);
    }
}
