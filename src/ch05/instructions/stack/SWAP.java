package ch05.instructions.stack;

import ch05.instructions.Instruction;
import ch05.instructions.base.BytecodeReader;
import ch05.rtda.Frame;
import ch05.rtda.OperandStack;
import ch05.rtda.Slot;

public class SWAP implements Instruction {

    @Override
    public void FetchOperands(BytecodeReader reader) {

    }

    @Override
    public void Execute(Frame frame) {
        OperandStack stack = frame.operandStack;
        Slot slot1 = stack.popSlot();
        Slot slot2 = stack.popSlot();
        stack.pushSlot(slot1);
        stack.pushSlot(slot2);
    }
}
