package ch05.instructions.extended;

import ch05.instructions.BranchInstruction;
import ch05.instructions.base.Branch_logic;
import ch05.instructions.base.BytecodeReader;
import ch05.rtda.Frame;

public class IFNULL extends BranchInstruction {
    @Override
    public void FetchOperands(BytecodeReader reader) {
        super.FetchOperands(reader);
    }

    @Override
    public void Execute(Frame frame) {
        Object ref = frame.operandStack.popRef();
        if (ref == null){
            Branch_logic.Branch(frame,offset);
        }
    }
}
