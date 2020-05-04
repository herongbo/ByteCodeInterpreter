package ch05.rtda;

public class LocalVars {
    public Slot[] vars;

    public LocalVars(int maxLocals){
        if (maxLocals > 0){
            System.out.println("new Slot["+maxLocals+"]");
            vars = new Slot[maxLocals];
            for (int i = 0; i < vars.length; i++) {
                vars[i] = new Slot();
            }
        }else {
            vars = null;
        }
    }

    /**
     * int 类型变量
     * @param index
     * @param val
     */
    public void setInt(int index, int val){
        this.vars[index].num = val;
    }

    public int getInt(int index){
        return (int)vars[index].num;
    }

    /**
     * float类型变量
     * @param index
     * @param val
     */
    public void setFloat(int index,float val){
        int bits = Float.floatToIntBits(val);
        this.vars[index].num = bits;
    }

    public float getFloat(int index){
        int bits = (int)vars[index].num;
        return Float.intBitsToFloat(bits);
    }

    /**
     * long变量则需要拆成两个int变量
     */
    public void setLong(int index,long val){
        this.vars[index].num = val;
    }

    public long getLong(int index){
        long val = this.vars[index].num;
        return val;
    }

    /**
     * double变量可以先转成long类型然后按照long变量来处理
     * @param index
     * @param val
     */
    public void setDouble(int index, double val){
        long bits = Double.doubleToLongBits(val);
        setLong(index,bits);
    }

    public double getDouble(int index){
        long bits = getLong(index);
        return Double.longBitsToDouble(bits);
    }

    /**
     * 最后是引用值
     */
    public void setRef(int index,Object ref){
        this.vars[index].ref = ref;
    }

    public Object getRef(int index){
        return this.vars[index].ref;
    }

    /**
     * 我们并没有真的对boolean、byte、short和char类型定义存取方法，这些类型的值都可以转换成int值类来处理
     */
}
