package ch05.instructions.constants;

import ch05.instructions.Instruction;
import ch05.instructions.base.BytecodeReader;
import ch05.rtda.Frame;

public class SIPUSH implements Instruction {
    // int16
    int val;
    @Override
    public void FetchOperands(BytecodeReader reader) {
        this.val = reader.readInt16();
    }

    @Override
    public void Execute(Frame frame) {
        int i = this.val;
        frame.operandStack.pushInt(i);
    }
}
