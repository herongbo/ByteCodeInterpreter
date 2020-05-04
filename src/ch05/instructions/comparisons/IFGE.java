package ch05.instructions.comparisons;

import ch05.instructions.BranchInstruction;
import ch05.instructions.base.Branch_logic;
import ch05.instructions.base.BytecodeReader;
import ch05.rtda.Frame;

/**
 * ifeq x==0
 * ifne x!=0
 * iflt x<0
 * ifle x<=0
 * ifgt x>0
 * ifge x>=0
 */
public class IFGE extends BranchInstruction {
    @Override
    public void FetchOperands(BytecodeReader reader) {

    }

    @Override
    public void Execute(Frame frame) {
        int val = frame.operandStack.popInt();
        if (val>=0){
            Branch_logic.Branch(frame,this.offset);
        }
    }
}
