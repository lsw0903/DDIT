package day13.exam06;

public class MyException extends RuntimeException {
	public MyException(String msg, Throwable e) {
		super(msg);
	}
}