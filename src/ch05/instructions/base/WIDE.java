package ch05.instructions.base;

import ch05.instructions.Instruction;
import ch05.instructions.loads.ILOAD;
import ch05.instructions.math.IINC;
import ch05.rtda.Frame;

public class WIDE implements Instruction{

    Instruction modifiedInstruction;
    @Override
    public void FetchOperands(BytecodeReader reader) {
        int opcode = reader.readUint8();
        switch (opcode){
            case 0x15: //iload
                ILOAD iload = new ILOAD();
                iload.index = reader.readInt16();
                modifiedInstruction = iload;
                break;
            case 0x16: //lload
                break;
            case 0x17: //fload
                break;
            case 0x18: //dload
                break;
            case 0x19: //aload
                break;
            case 0x36: //istore
                break;
            case 0x37: //lstore
                break;
            case 0x38: //fstore
                break;
            case 0x39: //dstore
                break;
            case 0x3a: //astore
                break;
            case 0x84: //iinc
                IINC iinc = new IINC();
                iinc.index = reader.readInt16();
                iinc.Const = reader.readInt16();
                this.modifiedInstruction = iinc;
                break;
            case 0xa9: //ret
                new Exception("Unsupported opcode 0xa9");
                break;
        }
    }

    @Override
    public void Execute(Frame frame) {
        this.modifiedInstruction.Execute(frame);
    }
}
