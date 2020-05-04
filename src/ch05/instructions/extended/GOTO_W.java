package ch05.instructions.extended;

import ch05.instructions.BranchInstruction;
import ch05.instructions.base.Branch_logic;
import ch05.instructions.base.BytecodeReader;
import ch05.rtda.Frame;

public class GOTO_W extends BranchInstruction {

    public int offset;

    @Override
    public void FetchOperands(BytecodeReader reader) {
        this.offset = reader.ReadInt32();
    }

    @Override
    public void Execute(Frame frame) {
        Branch_logic.Branch(frame,offset);
    }
}
