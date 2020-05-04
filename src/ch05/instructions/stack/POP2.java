package ch05.instructions.stack;

import ch05.instructions.Instruction;
import ch05.instructions.base.BytecodeReader;
import ch05.rtda.Frame;
import ch05.rtda.OperandStack;

public class POP2 implements Instruction {
    @Override
    public void FetchOperands(BytecodeReader reader) {

    }

    @Override
    public void Execute(Frame frame) {
        OperandStack stack = frame.operandStack;
        stack.popSlot();
        stack.popSlot();
    }
}
