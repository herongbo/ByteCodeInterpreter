package ch05.instructions.control;

import ch05.instructions.Instruction;
import ch05.instructions.base.Branch_logic;
import ch05.instructions.base.BytecodeReader;
import ch05.rtda.Frame;

public class TABLE_SWITCH implements Instruction {
    int defaultOffset;
    int low;
    int high;
    int[] jumpOffsets;


    @Override
    public void FetchOperands(BytecodeReader reader) {
        reader.SkipPadding();
        this.defaultOffset = reader.ReadInt32();
        this.low = reader.ReadInt32();
        this.high = reader.ReadInt32();
        int jumpOffsetsCount = this.high - this.low + 1;
        this.jumpOffsets = reader.ReadInt32s(jumpOffsetsCount);
    }

    @Override
    public void Execute(Frame frame) {
        int index = frame.operandStack.popInt();
        int offset;
        if (index >= this.low && index<= this.high){
            offset = this.jumpOffsets[index-this.low];
        }else {
            offset = this.defaultOffset;
        }
        Branch_logic.Branch(frame,offset);
    }
}
