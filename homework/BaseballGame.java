package homework;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class BaseballGame {
	
	int[] num = new int[3];
    int[] user;
    int strike;
    int ball;

    Scanner sc = new Scanner(System.in);

    public void RanNum() {
        HashSet<Integer> NumSet = new HashSet<>();

        while(NumSet.size()<3){
            NumSet.add( (int)(Math.random() * 9 + 1) );
        }

        Iterator<Integer> a = NumSet.iterator();

        int i = 0;

        while(a.hasNext()){
            num[i++] = a.next();
        }

        for(int j=1; j<=100; j++){
            int ran = (int)(Math.random() * num.length);
            int temp = num[0];
            num[0] = num[ran];
            num[ran] = temp;
        }

    }

    public void InputNum(){
        int n1, n2, n3;

        do{
            System.out.print("숫자 입력 => ");
            n1 = sc.nextInt();
            n2 = sc.nextInt();
            n3 = sc.nextInt();
            if(n1==n2 || n1==n3 || n2==n3){
                System.out.println("숫자가 중복됩니다.");
            }
        }while(n1==n2 || n1==n3 || n2==n3);

        user = new int[]{n1, n2, n3};
    }

    public void BallCount(){
        strike = 0;
        ball = 0;

        for(int i=0; i<num.length; i++){
            for(int j=0; j<user.length; j++){
                if(num[i] == user[j]){
                    if(i==j){
                        strike++;
                    }else{
                        ball++;
                    }
                }
            }
        }

        System.out.println(user[0] + " " + user[1] + " " + user[2] + " ==> " + strike + "S " + ball + "B");

    }

    public void GameStart(){

        RanNum();

        System.out.println("정답 => " + num[0] + " " + num[1] + " " + num[2]);

        int cnt = 0;

        do{
            cnt++;
            InputNum();
            BallCount();
        }while(strike!=3);

        System.out.println("\n" + cnt + "번째만에 맞췄군요.");
    }

    public static void main(String[] args) {
    	BaseballGame baseBall = new BaseballGame();
        baseBall.GameStart();
    }

}