package ch05.instructions.loads;

import ch05.instructions.Instruction;
import ch05.instructions.base.BytecodeReader;
import ch05.rtda.Frame;

public class ILOAD_3 implements Instruction {

    @Override
    public void FetchOperands(BytecodeReader reader) {

    }

    @Override
    public void Execute(Frame frame) {
        iload(frame,3);
    }

    public void iload(Frame frame,int index){
        int val = frame.localVars.getInt(index);
        frame.operandStack.pushInt(val);
    }
}
