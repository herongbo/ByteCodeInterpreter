package ch05.instructions;

import ch05.instructions.base.BytecodeReader;

public abstract class Index8Instruction implements Instruction {
    public int index = 0;

    @Override
    public void FetchOperands(BytecodeReader reader){
        this.index = reader.readUint8();
    }

}
