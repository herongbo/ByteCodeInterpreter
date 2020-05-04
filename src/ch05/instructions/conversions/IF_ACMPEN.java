package ch05.instructions.conversions;

import ch05.instructions.BranchInstruction;
import ch05.instructions.base.Branch_logic;
import ch05.instructions.base.BytecodeReader;
import ch05.rtda.Frame;
import ch05.rtda.OperandStack;

public class IF_ACMPEN extends BranchInstruction {

    @Override
    public void FetchOperands(BytecodeReader reader) {
        super.FetchOperands(reader);
    }

    @Override
    public void Execute(Frame frame) {
        OperandStack stack = frame.operandStack;
        Object ref2 = stack.popRef();
        Object ref1 = stack.popRef();
        if (ref1 != ref2){
            Branch_logic.Branch(frame,this.offset);
        }
    }
}
