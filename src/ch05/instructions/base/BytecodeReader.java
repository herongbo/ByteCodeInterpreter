package ch05.instructions.base;

public class BytecodeReader {
    public byte[] code;
    public int pc;

    public void reset(byte[] code,int pc){
        this.code = code;
        this.pc = pc;
    }

    public int readUint8(){
//        System.out.println(Byte.toUnsignedInt(this.code[this.pc]));

        int i = Byte.toUnsignedInt(this.code[this.pc]);
        this.pc++;
        return i;
    }

    public int ReadUint8(){
        return (int)this.readUint8();
    }

    public int readUint16(){
        int byte1 = this.readUint8();
        int byte2 = this.readUint8();
        return (byte1<<8)|byte2;
    }

    public int readInt16(){
        return this.readUint16();
    }

    public int ReadInt32(){
        int byte1 = this.readUint8();
        int byte2 = this.readUint8();
        int byte3 = this.readUint8();
        int byte4 = this.readUint8();
        return (byte1<<24)| (byte2<<16) | (byte3<<8) | byte4;
    }

    public int[]  ReadInt32s(int n){
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = this.ReadInt32();
        }
        return ints;
    }

    /**
     * tableswitch指令操作码的后面有0-3字节的padding，
     * 以保证defaultOffset在字节码中的地址是4的倍数，
     * BytecodeReader结构体的SkopPadding
     */
    public void SkipPadding(){
        while (this.pc % 4 !=0 ){
            this.ReadUint8();
        }
    }

    public void Reset(byte[] code,int pc){
        this.code = code;
        this.pc = pc;
    }
}
