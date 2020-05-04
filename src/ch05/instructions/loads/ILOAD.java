package ch05.instructions.loads;

import ch05.instructions.Instruction;
import ch05.instructions.base.BytecodeReader;
import ch05.rtda.Frame;

public class ILOAD implements Instruction {

    public int index;

    @Override
    public void FetchOperands(BytecodeReader reader) {
        this.index = reader.readUint8();
    }

    @Override
    public void Execute(Frame frame) {
        iload(frame,this.index);
    }

    public void iload(Frame frame,int index){
        int val = frame.localVars.getInt(index);
        frame.operandStack.pushInt(val);
    }
}
