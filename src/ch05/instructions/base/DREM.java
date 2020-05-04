package ch05.instructions.base;

import ch05.instructions.Instruction;
import ch05.rtda.Frame;
import ch05.rtda.OperandStack;
/**
 * 取余指令
 */
public class DREM implements Instruction {
    @Override
    public void FetchOperands(BytecodeReader reader) {

    }

    @Override
    public void Execute(Frame frame) {
        OperandStack stack = frame.operandStack;
        double v2 = stack.popDouble();
        double v1 = stack.popDouble();
        if (v2 == 0){
            new Exception("java.lang.ArithmeticException: /by zero");
        }
        double result = v1%v2;
        stack.pushDouble(result);
    }
}
