package ch05.instructions.control;

import ch05.instructions.BranchInstruction;
import ch05.instructions.base.Branch_logic;
import ch05.instructions.base.BytecodeReader;
import ch05.rtda.Frame;
import ch05.rtda.OperandStack;

public class GOTO extends BranchInstruction {
    @Override
    public void FetchOperands(BytecodeReader reader) {
        this.offset = reader.readInt16();
        if (this.offset > 0xff) {
            this.offset = this.offset - 0xffff - 1;
            System.out.println("offset = "+this.offset);
        }
    }

    /**
     * goto进行无条件跳转
     * @param frame
     */
    @Override
    public void Execute(Frame frame) {
        Branch_logic.Branch(frame,this.offset);
    }
}
