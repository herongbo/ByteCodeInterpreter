package ch05.instructions.comparisons;

import ch05.instructions.BranchInstruction;
import ch05.instructions.Instruction;
import ch05.instructions.base.Branch_logic;
import ch05.instructions.base.BytecodeReader;
import ch05.rtda.Frame;
import ch05.rtda.OperandStack;

public class IF_ICMPEQ extends BranchInstruction {
    @Override
    public void FetchOperands(BytecodeReader reader) {
        this.offset = reader.readInt16();
        if (this.offset > 0xff) {
            this.offset = this.offset - 0xffff - 1;
            System.out.println("offset = "+this.offset);
        }
    }

    @Override
    public void Execute(Frame frame) {
        OperandStack stack = frame.operandStack;
        int val2 = stack.popInt();
        int val1 = stack.popInt();
        if (val1==val2){
            Branch_logic.Branch(frame,this.offset);
        }
    }
}
