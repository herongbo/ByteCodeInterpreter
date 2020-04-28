package ch04.RunTime;

public class OperandStack {
    int size;
    Slot[] slots;

    public OperandStack(int maxStack){
        if (maxStack>0){
            this.slots = new Slot[maxStack];
            for (int i = 0; i < slots.length; i++) {
                slots[i] = new Slot();
            }
        }
    }

    // pushint
    public void pushInt(int val){
        this.slots[this.size].num = val;
        this.size++;
    }
    public int popInt(){
        this.size--;
        return (int)this.slots[this.size].num;
    }

    /**
     * Float
     */
    public void pushFloat(float val){
        int bits = Float.floatToIntBits(val);
        this.slots[this.size].num = bits;
        this.size++;
    }
    public float popFloat(){
        this.size--;
        int bits = (int)this.slots[this.size].num;
        return Float.intBitsToFloat(bits);
    }

    /**
     * long
     */
    public void pushLong(long val){
        this.slots[this.size].num = val;
        this.size ++;
    }
    public long popLong(){
        this.size--;
        long val = this.slots[this.size].num;
        return val;
    }
    /**
     * Double
     */
    public void pushDouble(double val){
        long bits = Double.doubleToLongBits(val);
        this.pushLong(bits);
    }
    public double popDouble(){
        long bits = this.popLong();
        return Double.longBitsToDouble(bits);
    }

    /**
     * 引用类型
     */
    public void pushRef(Object ref){
        this.slots[this.size].ref = ref;
        this.size++;
    }
    public Object popRef(){
        this.size--;
        Object ref = this.slots[this.size].ref;
        this.slots[this.size] = null;
        return ref;
    }

}
