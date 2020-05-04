package ch05.instructions.stores;

import ch05.instructions.Instruction;
import ch05.instructions.base.BytecodeReader;
import ch05.rtda.Frame;

public class ISTORE_0 implements Instruction {

    @Override
    public void FetchOperands(BytecodeReader reader) {
    }

    @Override
    public void Execute(Frame frame) {
        istore(frame,0);
    }

    public void istore(Frame frame,int index){
        int var =  frame.operandStack.popInt();
        frame.localVars.setInt(index,var);
    }
}
