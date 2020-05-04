package ch05.instructions;

import ch05.instructions.base.BytecodeReader;
import ch05.rtda.Frame;

public interface Instruction {
    /**
     * FetchOperands方法从字节码中提取操作数
     * @param reader
     */
    public void FetchOperands(BytecodeReader reader);

    /**
     * Execute方法执行指令逻辑
     * @param frame
     */
    public void Execute(Frame frame);
}
