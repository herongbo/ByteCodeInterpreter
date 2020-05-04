package ch05.instructions.constants;

import ch05.instructions.Instruction;
import ch05.instructions.base.BytecodeReader;
import ch05.rtda.Frame;

public class DCONST_1 implements Instruction {

    @Override
    public void FetchOperands(BytecodeReader reader) {

    }

    @Override
    public void Execute(Frame frame) {
        frame.operandStack.pushDouble(1.0);
    }
}
