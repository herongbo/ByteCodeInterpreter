package ch05.instructions.control;

import ch05.instructions.Instruction;
import ch05.instructions.base.Branch_logic;
import ch05.instructions.base.BytecodeReader;
import ch05.rtda.Frame;

public class LOOKUP_SWITCH implements Instruction {
    int defaultOffset;
    int npairs;
    int[] matchOffsets;


    @Override
    public void FetchOperands(BytecodeReader reader) {
        reader.SkipPadding();
        this.defaultOffset = reader.ReadInt32();
        this.npairs = reader.ReadInt32();
        this.matchOffsets = reader.ReadInt32s(this.npairs * 2);
    }

    @Override
    public void Execute(Frame frame) {
        int key = frame.operandStack.popInt();
        for (int i = 0; i < this.npairs*2; i+=2) {
            if (this.matchOffsets[i] == key){
                int offset = this.matchOffsets[i+1];
                Branch_logic.Branch(frame,offset);
                return;
            }
        }
        Branch_logic.Branch(frame,this.defaultOffset);
    }
}
