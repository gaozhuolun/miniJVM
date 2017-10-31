package jvm.print;

import jvm.clz.ClassFile;
import jvm.constant.ClassInfo;
import jvm.constant.ConstantInfo;
import jvm.constant.ConstantPool;
import jvm.constant.FieldRefInfo;
import jvm.constant.MethodRefInfo;
import jvm.constant.NameAndTypeInfo;
import jvm.constant.StringInfo;
import jvm.constant.UTF8Info;
import jvm.loader.ClassFileLoader;

public class ClassFilePrinter {
	ClassFile clzFile = null;
	public ClassFilePrinter(ClassFile clzFile){
		this.clzFile = clzFile;
	}
	
	public void print(){
		
		if(clzFile.getAccessFlag().isPublicClass()){
			System.out.println("Access flag : public  ");
		}
		System.out.println("Class Name:"+ clzFile.getClassName());
		
		System.out.println("Super Class Name:"+ clzFile.getSuperClassName());
		
		System.out.println("minor version:" + clzFile.getMinorVersion());
		
		System.out.println("major version:" + clzFile.getMinorVersion());
		
		ConstantPoolPrinter cnstPoolPrinter = new ConstantPoolPrinter(clzFile.getConstantPool());
		cnstPoolPrinter.print();
		
		
		
		
	}
	
	public static void main(String[] args){
		String path = "C:\\Users\\mini-jvm\\bin";
		ClassFileLoader loader = new ClassFileLoader();
		loader.addClassPath(path);
		String className = "jvm.test.EmployeeV1";
		
		ClassFile clzFile = loader.loadClass(className);
		
		ClassFilePrinter printer  = new ClassFilePrinter(clzFile);
		
		printer.print();
	}
}
