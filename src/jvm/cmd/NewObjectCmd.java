package jvm.cmd;

import jvm.clz.ClassFile;
import jvm.constant.ClassInfo;
import jvm.constant.ConstantPool;
import jvm.engine.ExecutionResult;
import jvm.engine.Heap;
import jvm.engine.JavaObject;
import jvm.engine.StackFrame;

public class NewObjectCmd extends TwoOperandCmd{
	
	public NewObjectCmd(ClassFile clzFile, String opCode){
		super(clzFile,opCode);
	}

	@Override
	public String toString() {
		
		return super.getOperandAsClassInfo();
	}
	public void execute(StackFrame frame,ExecutionResult result){
		
		int index = this.getIndex();
		
		ClassInfo info = (ClassInfo)this.getConstantInfo(index);
		
		String clzName = info.getClassName();
		
		//在Java堆上创建一个实例
		JavaObject jo = Heap.getInstance().newObject(clzName);
		
		frame.getOprandStack().push(jo);
		
		
		
	}
	
}
