package day11;

public class T06Example {
	public static void main(String[] args) {
		T06ImplementationC impl = new T06ImplementationC();
		
		T06InterfaceA ia = impl;
		ia.methodA();
		System.out.println();	//InterfaceA 변수는 methodA()만 호출 가능
		
		T06InterfaceB ib = impl;
		ib.methodB();			//InterfaceB 변수는 methodB()만 호출 가능
		System.out.println();
		
		T06InterfaceC ic = impl;
		ic.methodA();	//
		ic.methodB();	// InterfaceC 변수는 methodA(), methodB(), methodC() 모두 호출 가능
		ic.methodC();	//
	}

}