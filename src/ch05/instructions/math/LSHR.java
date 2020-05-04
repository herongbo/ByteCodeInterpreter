package ch05.instructions.math;

import ch05.instructions.Instruction;
import ch05.instructions.base.BytecodeReader;
import ch05.rtda.Frame;
import ch05.rtda.OperandStack;

/**
 * int左移位
 * 先从操作数栈中弹出两个int变量v2和v1，v1是要进行位移操作的变量，v2指出要位移多少比特
 * 位移之后，把结果推入操作数栈，这里注意两点，第一int变量只有32位，所以只取v2的前5个比特就足够表示位移数了

 */
public class LSHR implements Instruction {
    @Override
    public void FetchOperands(BytecodeReader reader) {

    }

    @Override
    public void Execute(Frame frame) {
        OperandStack stack = frame.operandStack;
        long v2 = stack.popLong();
        long v1 = stack.popLong();
        long result = v1>>v2;
        stack.pushLong(result);
    }
}
