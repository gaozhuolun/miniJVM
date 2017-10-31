package jvm.cmd;

import jvm.clz.ClassFile;
import jvm.constant.ConstantInfo;
import jvm.constant.ConstantPool;
import jvm.engine.ExecutionResult;
import jvm.engine.Heap;
import jvm.engine.JavaObject;
import jvm.engine.StackFrame;


public class BiPushCmd extends OneOperandCmd {

	public BiPushCmd(ClassFile clzFile,String opCode) {
		super(clzFile,opCode);
		
	}

	@Override
	public String toString() {
	
		return this.getOffset()+":"+ this.getOpCode()+" " + this.getReadableCodeText() + " " + this.getOperand();
	}
	public void execute(StackFrame frame,ExecutionResult result){
		int value = this.getOperand();
		JavaObject jo = Heap.getInstance().newInt(value);
		frame.getOprandStack().push(jo);
		
	}
	

}
