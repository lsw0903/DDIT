package day42;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class MyServletRequestListener implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println(
				"[MyServletRequestListener] requestDestroyed() 호출됨.");
		
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println(
				"[MyServletRequestListener] requestInitialized() 호출됨.");
		
	}
}