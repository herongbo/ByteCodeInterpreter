package ch05.instructions;

import ch05.instructions.base.*;
import ch05.instructions.comparisons.*;
import ch05.instructions.constants.*;
import ch05.instructions.control.GOTO;
import ch05.instructions.conversions.D2F;
import ch05.instructions.conversions.D2I;
import ch05.instructions.conversions.D2L;
import ch05.instructions.conversions.IF_ACMPEQ;
import ch05.instructions.extended.GOTO_W;
import ch05.instructions.extended.IFNOTNULL;
import ch05.instructions.extended.IFNULL;
import ch05.instructions.loads.*;
import ch05.instructions.math.*;
import ch05.instructions.stack.DUP;
import ch05.instructions.stack.POP;
import ch05.instructions.stack.POP2;
import ch05.instructions.stack.SWAP;
import ch05.instructions.stores.*;


public class Factory {
    public static Instruction NewInstruction(int opcode){
        System.out.println("inst "+Integer.toHexString(opcode));
        /*
        助记符和功能描述
         */
        switch (opcode){
            case 0x00:
                // nop 无操作
                return new NoOperandsInstruction();
            case 0x01:
                // aconst_null null 入栈
                return new ACONST_NULL();
            case 0x02:
                // iconst_m1 int类型常量-1进栈
                return new ICONST_M1();
            case 0x03:
                // iconst_0 int类型常量0进栈
                return new ICONST_0();
            case 0x04:
                // iconst_1 int类型常量1进栈
                return new ICONST_1();
            case 0x05:
                // iconst_2 int类型常量2进栈
                return new ICONST_2();
            case 0x06:
                // iconst_3 int类型常量3进栈
                return new ICONST_3();
            case 0x07:
                // iconst_4 int类型常量4进栈
                return new ICONST_4();
            case 0x08:
                // iconst_5 int类型常量5进栈
                return new ICONST_5();
            case 0x09:
                // lconst_0 long类型常量0进栈
                return new LCONST_0();
            case 0x0A:
                // lconst_1 long类型常量1进栈
                return new LCONST_1();
            case 0x0B:
                // fconst_0 float类型常量值0进栈
                return new FCONST_0();
            case 0x0C:
                // fconst_1 float类型常量值1进栈
                return new FCONST_1();
            case 0x0D:
                // fconst_2 float类型常量值2进栈
                return new FCONST_2();
            case 0x0E:
                // dconst_0 double类型常量值0进栈
                return new DCONST_0();
            case 0x0F:
                // dconst_1 double类型常量1进栈
                return new DCONST_1();
            case 0x10:
                // bipush 将一个byte类型常量值推送到栈顶
                return new BIPUSH();
            case 0x11:
                // sipush 将一个short类型常量推送到栈顶
                return new SIPUSH();
            case 0x12:
                // ldc 将int、float或String常量值从常量池中推送到栈顶
                return null;
            case 0x13:
                // ldc_w将int、float、String型常量从常量池中推送至栈顶
                return null;
            case 0x14:
                // ldc2_2 将龙或double类型常量值从常量池中推送到栈顶（宽索引
                return null;
            case 0x15:
                // iload 指定int类型局部变量进栈
                return new ILOAD();
            case 0x16:
                // lload 指定long类型局部变量进栈
                return null;
            case 0x17:
                // fload 指定float类型局部变量进栈
                return null;
            case 0x18:
                // dload 指定double类型局部变量进栈
                return null;
            case 0x19:
                // aload 当前frame的局部变量数组中下标为index的引用的局部变量进栈
                return null;
            case 0x1A:
                // iload_0 第一个int类型局部变量进栈
                return new ILOAD_0();
            case 0x1B:
                // iload_1 第二个int类型局部变量进栈
                return new ILOAD_1();
            case 0x1C:
                // iload_2 第三个int类型局部变量进栈
                return new ILOAD_2();
            case 0x1D:
                // iload_3 第四个int类型局部变量进栈
                return new ILOAD_3();
            case 0x1E:
                // lload_0 第一个long型局部变量进栈
//                return new LLOAD_0();
                return null;
            case 0x1F:
                // lload_1 第二个long型局部变量进栈
//                return new LLOAD_1();
                return null;
            case 0x20:
                // lload_2 第三个long型局部变量进栈
//                return new LLOAD_2();
                return null;
            case 0x21:
                // lload_3 第四个long型局部变量进栈
//                return new LLOAD_3();
                return null;
            case 0x22:
                // fload_0 第一个float型局部变量进栈
//                return new FLOAD_0();
                return null;
            case 0x23:
                // fload_1 第二个float型局部变量进栈
//                return new FLOAD_1();
                return null;
            case 0x24:
                // fload_2 第三个float型局部变量进栈
//                return new FLOAD_2();
                return null;
            case 0x25:
                // fload_3 第四个float型局部变量进栈
//                return new FLOAD_3();
                return null;
            case 0x26:
                // dload_0 第一个double型局部变量进栈
//                return new DLOAD_0();
                return null;
            case 0x27:
                // dload_1 第二个double型局部变量进栈
//                return new DLOAD_1();
                return null;
            case 0x28:
                // dload_2 第三个double型局部变量进栈
//                return new DLOAD_2();
                return null;
            case 0x29:
                // dload_3 第四个double型局部变量进栈
//                return new DLOAD_3();
                return null;
            case 0x2A:
                // aload_0
//                return new ALOAD_0();
                return null;
            case 0x2B:
                // aload_1
//                return new ALOAD_1();
                return null;
            case 0x2C:
                // aload_2
//                return new ALOAD_2();
                return null;
            case 0x2D:
                // aload_3
//                return new ALOAD_3();
                return null;
            case 0x2E:
                // iaload 指定的int型数组的指定下标处的值进栈
//                return new IALOAD();
                return null;
            case 0x2F:
                // laload 指定的long型数组的指定下标处的值进栈
//                return new LALOAD();
                return null;
            case 0x30:
                // faload 指定的float型数组的指定下标处的值进栈
//                return new FALOAD();
                return null;
            case 0x31:
                // daload 指定的double型数组的指定下标处的值进栈
//                return new DALOAD();
                return null;
            case 0x32:
                // aaload
//                return new AALOAD();
                return null;
            case 0x33:
                // baload 指定的boolean或byte型数组的指定下标处的值进栈
//                return new BALOAD();
                return null;
            case 0x34:
                // caload 指定的char型数组的指定下标处的值进栈
//                return new CALOAD();
                return null;
            case 0x35:
                // saload 指定的short型数组的指定下标处的值进栈
//                return new SALOAD();
                return null;
            case 0x36:
                // istore 将栈顶int型数值存入指定的局部变量
                return new ISTORE();
            case 0x37:
                // lstore 将栈顶long型数值存入指定的局部变量
//                return new LSTORE();
                return null;
            case 0x38:
                // fstore 将栈顶float型数值存入指定的局部变量
//                return new FSTORE();
                return null;
            case 0x39:
                // dstore 将栈顶double型数值存入指定的局部变量
//                return new DSTORE();
                return null;
            case 0x3A:
                // astore
//                return new ASTORE();
                return null;
            case 0x3B:
                // istore_0 将栈顶int型数值存入第一个局部变量
                return new ISTORE_0();
            case 0x3C:
                // istore_1 将栈顶int型数值存入第二个局部变量
                return new ISTORE_1();
            case 0x3D:
                // istore_2 将栈顶int型数值存入第三个局部变量
                return new ISTORE_2();
            case 0x3E:
                // istore_3 将栈顶int型数值存入第四个局部变量
                return new ISTORE_3();
            case 0x3F:
                // lstore_0 将栈顶long型数值存入第一个局部变量
//                return new LSTORE_0();
                return null;
            case 0x40:
                // lstore_1 将栈顶long型数值存入第二个局部变量
//                return new LSTORE_1();
                return null;
            case 0x41:
                // lstore_2 将栈顶long型数值存入第三个局部变量
//                return new LSTORE_2();
                return null;
            case 0x42:
                // lstore_3 将栈顶long型数值存入第四个局部变量
//                return new LSTORE_3();
                return null;
            case 0x43:
                // fstore_0 将栈顶float型数值存入第一个局部变量
//                return new FSTORE_0();
                return null;
            case 0x44:
                // fstore_1 将栈顶float型数值存入第二个局部变量
//                return new FSTORE_1();
                return null;
            case 0x45:
                // fstore_2 将栈顶float型数值存入第三个局部变量
//                return new FSTORE_2();
                return null;
            case 0x46:
                // fstore_3 将栈顶float型数值存入第四个局部变量
//                return new FSTORE_3();
                return null;
            case 0x47:
                // dstore_0 将栈顶double型数值存入第一个局部变量
//                return new DSTORE_0();
                return null;
            case 0x48:
                // dstore_1 将栈顶double型数值存入第二个局部变量
//                return new DSTORE_1();
                return null;
            case 0x49:
                // dstore_2 将栈顶double型数值存入第三个局部变量
//                return new DSTORE_2();
                return null;
            case 0x4A:
                // dstore_3 将栈顶double型数值存入第四个局部变量
//                return new DSTORE_3();
                return null;
            case 0x4B:
                // astore_0
//                return new ASTORE_0();
                return null;
            case 0x4C:
                // astore_1
//                return new ASTORE_1();
                return null;
            case 0x4D:
                // astore_2
//                return new ASTORE_2();
                return null;
            case 0x4E:
                // astore_3
//                return new ASTORE_3();
                return null;
            case 0x4F:
                // iastore  将栈顶int型数值存入指定数组的指定下标处
//                return new IASTORE ();
                return null;
            case 0x50:
                // lastore 将栈顶long型数值存入指定数组的指定下标处
//                return new LASTORE();
                return null;
            case 0x51:
                // fastore 将栈顶float型数值存入指定数组的指定下标处
//                return new FASTORE();
                return null;
            case 0x52:
                // dastore 将栈顶double型数值存入指定数组的指定下标处
//                return new DASTORE();
                return null;
            case 0x53:
                // aastore
//                return new AASTORE();
                return null;
            case 0x54:
                // bastore 将栈顶boolean或byte型数值存入指定数组的指定下标处
//                return new BASTORE();
                return null;
            case 0x55:
                // castore 将栈顶char型数值存入指定数组的指定下标处
//                return new CASTORE();
                return null;
            case 0x56:
                // sastore 将栈顶short型数值存入指定数组的指定下标处
//                return new SASTORE();
                return null;
            case 0x57:
                // pop 栈顶数值出栈 (该栈顶数值不能是long或double型)
                return new POP(); case 0x58:
                // pop2 栈顶的一个（如果是long、double型的)或两个（其它类型的）数值出栈
                return new POP2();
            case 0x59:
                // dup 复制栈顶数值，并且复制值进栈
                return new DUP();
            case 0x5A:
                // dup_x1 复制栈顶数值，并且复制值进栈2次
//                return new DUP_X1();
                return null;
            case 0x5B:
                // dup_x2 复制栈顶数值，并且复制值进栈2次或3次
//                return new DUP_X2();
                return null;
            case 0x5C:
                // dup2 复制栈顶一个（long、double型的)或两个（其它类型的）数值，并且复制值进栈
//                return new DUP2();
                return null;
            case 0x5D:
                // dup2_x1
//                return new DUP2_X1();
                return null;
            case 0x5E:
                // dup2_x2
//                return new DUP2_X2();
                return null;
            case 0x5F:
                // swap 栈顶的两个数值互换(要求栈顶的两个数值不能是long或double型的)
                return new SWAP();
            case 0x60:
                // iadd 栈顶两int型数值相加，并且结果进栈
                return new IADD();
            case 0x61:
                // ladd 栈顶两long型数值相加，并且结果进栈
                return new LADD();
            case 0x62:
                // fadd 栈顶两float型数值相加，并且结果进栈
//                return new FADD();
                return null;
            case 0x63:
                // dadd 栈顶两double型数值相加，并且结果进栈
//                return new DADD();
                return null;
            case 0x64:
                // isub 栈顶两int型数值相减，并且结果进栈
//                return new ISUB();
                return null;
            case 0x65:
                // lsub 栈顶两long型数值相减，并且结果进栈
//                return new LSUB();
                return null;
            case 0x66:
                // fsub 栈顶两float型数值相减，并且结果进栈
//                return new FSUB();
                return null;
            case 0x67:
                // dsub 栈顶两double型数值相减，并且结果进栈
//                return new DSUB();
                return null;
            case 0x68:
                // imul 栈顶两int型数值相乘，并且结果进栈
//                return new IMUL();
                return null;
            case 0x69:
                // lmul 栈顶两long型数值相乘，并且结果进栈
//                return new LMUL();
                return null;
            case 0x6A:
                // fmul 栈顶两float型数值相乘，并且结果进栈
//                return new FMUL();
                return null;
            case 0x6B:
                // dmul 栈顶两double型数值相乘，并且结果进栈
//                return new DMUL();
                return null;
            case 0x6C:
                // idiv 栈顶两int型数值相除，并且结果进栈
//                return new IDIV();
                return null;
            case 0x6D:
                // ldiv 栈顶两long型数值相除，并且结果进栈
//                return new LDIV();
                return null;
            case 0x6E:
                // fdiv 栈顶两float型数值相除，并且结果进栈
//                return new FDIV();
                return null;
            case 0x6F:
                // ddiv 栈顶两double型数值相除，并且结果进栈
//                return new DDIV();
                return null;
            case 0x70:
                // irem 栈顶两int型数值作取模运算，并且结果进栈
                return new IREM();
            case 0x71:
                // lrem 栈顶两long型数值作取模运算，并且结果进栈
                return new LREM();
            case 0x72:
                // frem 栈顶两float型数值作取模运算，并且结果进栈
                return new FREM();
            case 0x73:
                // drem 栈顶两double型数值作取模运算，并且结果进栈
                return new DREM();
            case 0x74:
                // ineg 栈顶int型数值取负，并且结果进栈
//                return new INEG();
                return null;
            case 0x75:
                // lneg 栈顶long型数值取负，并且结果进栈
//                return new LNEG();
                return null;
            case 0x76:
                // fneg 栈顶float型数值取负，并且结果进栈
//                return new FNEG();
                return null;
            case 0x77:
                // dneg 栈顶double型数值取负，并且结果进栈
//                return new DNEG();
                return null;
            case 0x78:
                // ishl int型数值左移指定位数，并且结果进栈
                return new ISHL();
            case 0x79:
                // lshl long型数值左移指定位数，并且结果进栈
                return new LSHL();
            case 0x7A:
                // ishr int型数值带符号右移指定位数，并且结果进栈
                return new ISHR();
            case 0x7B:
                // lshr long型数值带符号右移指定位数，并且结果进栈
                return new LSHR();
            case 0x7C:
                // iushr int型数值无符号右移指定位数，并且结果进栈
                return new IUSHR();
            case 0x7D:
                // lushr long型数值无符号右移指定位数，并且结果进栈
                return new LUSHR();
            case 0x7E:
                // iand 栈顶两int型数值按位与，并且结果进栈
                return new IAND();
            case 0x7F:
                // land 栈顶两long型数值按位与，并且结果进栈
                return new LAND();
            case 0x80:
                // ior 栈顶两int型数值按位或，并且结果进栈
                return new IOR();
            case 0x81:
                // lor 栈顶两long型数值按位或，并且结果进栈
                return new LOR();
            case 0x82:
                // ixor 栈顶两int型数值按位异或，并且结果进栈
                return new IXOR();
            case 0x83:
                // lxor 栈顶两long型数值按位异或，并且结果进栈
                return new LXOR();
            case 0x84:
                // iinc 指定int型变量增加指定值
                return new IINC();
            case 0x85:
                // i2l 栈顶int值强转long值，并且结果进栈
//                return new I2L();
                return null;
            case 0x86:
                // i2f 栈顶int值强转float值，并且结果进栈
//                return new I2F();
                return null;
            case 0x87:
                // i2d 栈顶int值强转double值，并且结果进栈
//                return new I2D();
                return null;
            case 0x88:
                // l2i 栈顶long值强转int值，并且结果进栈
//                return new L2I();
                return null;
            case 0x89:
                // l2f 栈顶long值强转float值，并且结果进栈
//                return new L2F();
                return null;
            case 0x8A:
                // l2d 栈顶long值强转double值，并且结果进栈
//                return new L2D();
                return null;
            case 0x8B:
                // f2i 栈顶float值强转int值，并且结果进栈
//                return new F2I();
                return null;
            case 0x8C:
                // f2l 栈顶float值强转long值，并且结果进栈
//                return new F2L();
                return null;
            case 0x8D:
                // f2d 栈顶float值强转double值，并且结果进栈
//                return new F2D();
                return null;
            case 0x8E:
                // d2i 栈顶double值强转int值，并且结果进栈
                return new D2I();
            case 0x8F:
                // d2l 栈顶double值强转long值，并且结果进栈
                return new D2L();
            case 0x90:
                // d2f 栈顶double值强转float值，并且结果进栈
                return new D2F();
            case 0x91:
                // i2b 栈顶int值强转byte值，并且结果进栈
//                return new I2B();
                return null;
            case 0x92:
                // i2c 栈顶int值强转char值，并且结果进栈
//                return new I2C();
                return null;
            case 0x93:
                // i2s 栈顶int值强转short值，并且结果进栈
//                return new I2S();
                return null;
            case 0x94:
                // lcmp 比较栈顶两long型数值大小，并且结果（1，0，-1）进栈
                return new LCMP();
            case 0x95:
                // fcmpl 比较栈顶两float型数值大小，并且结果（1，0，-1）进栈；当其中一个数值为NaN时， -1进栈
                return new FCMPL();
            case 0x96:
                // fcmpg 比较栈顶两float型数值大小，并且结果（1，0，-1）进栈；当其中一个数值为NaN时，1进栈
                return new FCMPG();
            case 0x97:
                // dcmpl 比较栈顶两double型数值大小，并且结果（1，0，-1）进栈；当其中一个数值为NaN时，-1进栈
                return new DCMPL();
            case 0x98:
                // dcmpg 比较栈顶两double型数值大小，并且结果（1，0，-1）进栈；当其中一个数值为NaN时，1进栈
                return new DCMPG();
            case 0x99:
                // ifeq 当栈顶int型数值等于0时跳转
                return new IFEQ();
            case 0x9A:
                // ifne 当栈顶int型数值不等于0时跳转
                return new IFNE();
            case 0x9B:
                // iflt 当栈顶int型数值小于0时跳转
                return new IFLT();
            case 0x9C:
                // ifge 当栈顶int型数值大于等于0时跳转
                return new IFGE();
            case 0x9D:
                // ifgt 当栈顶int型数值大于0时跳转
                return new IFGT();
            case 0x9E:
                // ifle 当栈顶int型数值小于等于0时跳转
                return new IFLE();
            case 0x9F:
                // if_icmpeq 比较栈顶两int型数值大小，当结果等于0时跳转
                return new IF_ICMPEQ();
            case 0xA0:
                // if_icmpne 比较栈顶两int型数值大小，当结果不等于0时跳转
                return new IF_ICMPNE();
            case 0xA1:
                // if_icmplt 比较栈顶两int型数值大小，当结果小于0时跳转
                return new IF_ICMPLT();
            case 0xA2:
                // if_icmpge 比较栈顶两int型数值大小，当结果大于等于0时跳转
                return new IF_ICMPGE();
            case 0xA3:
                // if_icmpgt 比较栈顶两int型数值大小，当结果大于0时跳转
                return new IF_ICMPGT();
            case 0xA4:
                // if_icmple 比较栈顶两int型数值大小，当结果小于等于0时跳转
                return new IF_ICMPLE();
            case 0xA5:
                // if_acmpeq 比较栈顶两引用型数值，当结果相等时跳转
                return new IF_ACMPEQ();
            case 0xA6:
                // if_acmpne 比较栈顶两引用型数值，当结果不相等时跳转
//                return new IF_ACMPNE();
                return null;
            case 0xA7:
                // goto 无条件跳转
                return new GOTO();
            case 0xA8:
                // jsr 跳转至指定16位offset位置，并将jsr下一条指令地址压入栈顶
//                return new JSR();
                return null;
            case 0xA9:
                // ret 返回至局部变量指定的index的指令位置（通常与jsr、jsr_w联合使用）
//                return new RET();
                return null;
            case 0xAA:
                // tableswitch 用于switch条件跳转，case值连续（可变长度指令）
//                return new TABLESWITCH();
                return null;
            case 0xAB:
                // lookupswitch 用于switch条件跳转，case值不连续（可变长度指令）
//                return new LOOKUPSWITCH();
                return null;
            case 0xAC:
                // ireturn 当前方法返回int
//                return new IRETURN();
                return null;
            case 0xAD:
                // lreturn 当前方法返回long
//                return new LRETURN();
                return null;
            case 0xAE:
                // freturn 当前方法返回float
//                return new FRETURN();
                return null;
            case 0xAF:
                // dreturn 当前方法返回double
//                return new DRETURN();
                return null;
            case 0xB0:
                // areturn
//                return new ARETURN();
                return null;
            case 0xB1:
                // return 当前方法返回void
                return new RETURN();
            case 0xB2:
                // getstatic 获取指定类的静态域，并将其值压入栈顶
//                return new GETSTATIC();
                return null;
            case 0xB3:
                // putstatic 为指定的类的静态域赋值
//                return new PUTSTATIC();
                return null;
            case 0xB4:
                // getfield 获取指定类的实例域，并将其值压入栈顶
//                return new GETFIELD();
                return null;
            case 0xB5:
                // putfield 为指定的类的实例域赋值
//                return new PUTFIELD();
                return null;
            case 0xB6:
                // invokevirtual 调用实例方法
//                return new INVOKEVIRTUAL();
                return null;
            case 0xB7:
                // invokespecial 调用超类构造方法、实例初始化方法、私有方法
//                return new INVOKESPECIAL();
                return null;
            case 0xB8:
                // invokestatic 调用静态方法
//                return new INVOKESTATIC();
                return null;
            case 0xb9:
                // invokeinterface 调用接口方法
//                return new INVOKEINTERFACE();
                return null;
            case 0xBA:
                // --- 因为历史原因，该码点为未使用的保留码点
//                return new ---();
                return null;
            case 0xBB:
                // new 创建一个对象，并且其引用进栈
//                return new NEW();
                return null;
            case 0xBC:
                // newarray 创建一个基本类型数组，并且其引用进栈
//                return new NEWARRAY();
                return null;
            case 0xBD:
                // anewarray
//                return new ANEWARRAY();
                return null;
            case 0xBE:
                // arraylength
//                return new ARRAYLENGTH();
                return null;
            case 0xBF:
                // athrow
//                return new ATHROW();
                return null;
            case 0xC0:
                // checkcast 类型转换检查，如果该检查未通过将会抛出ClassCastException异常
//                return new CHECKCAST();
                return null;
            case 0xc1:
                // instanceof 检查对象是否是指定的类的实例。如果是，1进栈；否则，0进栈
//                return new INSTANCEOF();
                return null;
            case 0xC2:
                // monitorenter 获得对象锁
//                return new MONITORENTER();
                return null;
            case 0xC3:
                // monitorexit 释放对象锁
//                return new MONITOREXIT();
                return null;
            case 0xC4:
                // wide 用于修改其他指令的行为
                return new WIDE();
            case 0xC5:
                // multianewarray 创建指定类型和维度的多维数组（执行该指令时，栈中必须包含各维度的长度值），并且其引用值进栈
//                return new MULTIANEWARRAY();
                return null;
            case 0xC6:
                // ifnull 为null时跳转
                return new IFNULL();
            case 0xC7:
                // ifnonnull 不为null时跳转
                return new IFNOTNULL();
            case 0xC8:
                // goto_w 无条件跳转（宽索引）
                return new GOTO_W();
            case 0xC9:
                // jsr_w 跳转至指定32位offset位置，并且jsr_w下一条指令地址进栈
//                return new JSR_W();
                return null;
            case 0xCA:
                // breakpoint
//                return new BREAKPOINT();
                return null;
            case 0xFE:
                // impdep1
//                return new IMPDEP1();
                return null;
            case 0xFF:
                // impdep2
//                return new IMPDEP2();
                return null;
            default:
                System.err.println("no such instruction error " + opcode);
                return null;
        }
    }
}
