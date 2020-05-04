package ch05.instructions.math;

import ch05.instructions.Instruction;
import ch05.instructions.base.BytecodeReader;
import ch05.rtda.Frame;
import ch05.rtda.OperandStack;

public class LADD implements Instruction {
    @Override
    public void FetchOperands(BytecodeReader reader) {

    }

    @Override
    public void Execute(Frame frame) {
        OperandStack stack = frame.operandStack;
        long v2 = stack.popLong();
        long v1 = stack.popLong();
        long result = v1 + v2;
        stack.pushLong(result);
    }
}
