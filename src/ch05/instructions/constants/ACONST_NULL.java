package ch05.instructions.constants;

import ch05.instructions.Instruction;
import ch05.instructions.base.BytecodeReader;
import ch05.rtda.Frame;

/**
 * 把null引用推入操作数栈
 */
public class ACONST_NULL implements Instruction {

    @Override
    public void FetchOperands(BytecodeReader reader) {

    }

    @Override
    public void Execute(Frame frame) {
        frame.operandStack.pushRef(null);
    }
}
