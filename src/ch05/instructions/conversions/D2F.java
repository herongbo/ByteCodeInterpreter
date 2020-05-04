package ch05.instructions.conversions;

import ch05.instructions.Instruction;
import ch05.instructions.base.BytecodeReader;
import ch05.rtda.Frame;
import ch05.rtda.OperandStack;

public class D2F implements Instruction {
    @Override
    public void FetchOperands(BytecodeReader reader) {

    }

    @Override
    public void Execute(Frame frame) {
        OperandStack stack = frame.operandStack;
        double d = stack.popDouble();
        float i = (float) d;
        stack.pushFloat(i);
    }
}
