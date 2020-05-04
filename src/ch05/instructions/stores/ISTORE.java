package ch05.instructions.stores;

import ch05.instructions.Instruction;
import ch05.instructions.base.BytecodeReader;
import ch05.rtda.Frame;

public class ISTORE implements Instruction {

    int index;

    @Override
    public void FetchOperands(BytecodeReader reader) {
        this.index = reader.readUint8();
    }

    @Override
    public void Execute(Frame frame) {
        istore(frame,this.index);
    }

    public void istore(Frame frame,int index){
        int var =  frame.operandStack.popInt();
        frame.localVars.setInt(index,var);
    }
}
