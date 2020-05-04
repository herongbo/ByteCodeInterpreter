package ch05.instructions.math;

import ch05.instructions.Instruction;
import ch05.instructions.base.BytecodeReader;
import ch05.rtda.Frame;
import ch05.rtda.LocalVars;

/**
 * iinc指令给局部变量表中的int变量增加常量值，局部变量表索引和常量值都有指令操作数提供
 */
public class IINC implements Instruction {
    public int index;
    public int Const;

    @Override
    public void FetchOperands(BytecodeReader reader) {
        this.index = reader.readUint8();
        this.Const = reader.readUint8();
    }

    @Override
    public void Execute(Frame frame) {
        LocalVars localVars = frame.localVars;
        int val = localVars.getInt(this.index);
        val = val + this.Const;
        localVars.setLong(this.index,val);
    }
}
