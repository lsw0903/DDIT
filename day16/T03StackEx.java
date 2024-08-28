package day16;

import java.util.Stack;

public class T03StackEx {
	public static void main(String[] args) {
		//Stack 타입 객체에 Coin 객체를 담는다.
		Stack<Coin> coinBox = new Stack<Coin>();
		
		//동전 넣기
		coinBox.push(new Coin(100));
		coinBox.push(new Coin(50));
		coinBox.push(new Coin(500));
		coinBox.push(new Coin(10));
		
		while (!coinBox.isEmpty()) {
			//가장 마지막 부터 pop
			Coin coin  = coinBox.pop();
			System.out.println("꺼내온 동전: " + coin.getValue() + "원");
		}
	}
}
