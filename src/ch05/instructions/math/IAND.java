package ch05.instructions.math;

import ch05.instructions.Instruction;
import ch05.instructions.base.BytecodeReader;
import ch05.rtda.Frame;
import ch05.rtda.OperandStack;

public class IAND implements Instruction {
    @Override
    public void FetchOperands(BytecodeReader reader) {

    }

    @Override
    public void Execute(Frame frame) {
        OperandStack stack = frame.operandStack;
        int v2 = stack.popInt();
        int v1 = stack.popInt();
        int result = v1&v2;
        stack.pushInt(result);
    }
}
