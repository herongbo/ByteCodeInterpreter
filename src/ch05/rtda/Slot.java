package ch05.rtda;

public class Slot {
    long num;
    Object ref;
    public Slot(){
        this.num = 0;
        this.ref = null;
    }

    @Override
    public String toString() {
        return "num= "+num+" ref "+ref;
    }
}
