package ch04.RunTime;

public class StartJVM {

    public static void main(String[] args){
        Frame frame = new Frame(100,100);
        StartJVM startJVM = new StartJVM();
        startJVM.testLocalVars(frame.localVars);
        startJVM.testOperandStack(frame.operandStack);
    }

    public void testLocalVars(LocalVars vars){
        vars.setInt(0,100);
        vars.setInt(1,-100);
        vars.setLong(2,2997924580L);
        vars.setLong(4,-2997924580L);
        vars.setFloat(6,3.1415926f);
        vars.setDouble(7,32.71828182845);
        vars.setRef(9,null);

        System.out.println(0+">>>>>>>");
        System.out.println(vars.getInt(0));
        System.out.println(vars.getInt(1));
        System.out.println(vars.getLong(2));
        System.out.println(vars.getLong(4));
        System.out.println(vars.getFloat(6));
        System.out.println(vars.getDouble(7));
        System.out.println(vars.getRef(9));
    }

    public void testOperandStack(OperandStack ops){
        ops.pushInt(100);
        ops.pushInt(-100);
        ops.pushLong(2997924580L);
        ops.pushLong(-2997924580L);
        ops.pushFloat(3.1415926f);
        ops.pushDouble(2.71828182845);
        ops.pushRef(null);
        System.out.println(ops.popRef());
        System.out.println(ops.popDouble());
        System.out.println(ops.popFloat());
        System.out.println(ops.popLong());
        System.out.println(ops.popLong());
        System.out.println(ops.popInt());
        System.out.println(ops.popInt());
    }
}
