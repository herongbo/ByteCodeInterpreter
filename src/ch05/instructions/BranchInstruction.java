package ch05.instructions;

import ch05.instructions.base.BytecodeReader;

public abstract class BranchInstruction implements Instruction {
    public int offset = 0;

    @Override
    public void FetchOperands(BytecodeReader reader){
        this.offset = reader.readUint8();
    }

}
