package day42;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyHttpSessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println(
				"[MyHttpSessionListener] sessionCreated() 호출됨."
					+ " => " + se.getSession().getId());
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println(
				"[MyHttpSessionListener] sessionDestroyed() 호출됨."
					+ " => " + se.getSession().getId());
		
	}
}