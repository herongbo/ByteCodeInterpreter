package ch05.instructions;

import ch05.instructions.base.BytecodeReader;
import ch05.rtda.Frame;

public class NoOperandsInstruction implements Instruction{

    @Override
    public void FetchOperands(BytecodeReader reader) {

    }

    @Override
    public void Execute(Frame frame) {

    }
}
