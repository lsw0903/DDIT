package homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HorseRace {

    static int currRank = 1;  // 현재 순위 정보

    public static void main(String[] args) {

        List<Horse> horseList = new ArrayList<Horse>();
        horseList.add(new Horse("1번말"));
        horseList.add(new Horse("2번말"));
        horseList.add(new Horse("3번말"));
        horseList.add(new Horse("4번말"));
        horseList.add(new Horse("5번말"));
        horseList.add(new Horse("6번말"));
        horseList.add(new Horse("7번말"));
        horseList.add(new Horse("8번말"));
        horseList.add(new Horse("9번말"));
        horseList.add(new Horse("10번말"));

        // 모든 말 스레드를 시작
//        for (Horse horse : horseList) {
//            horse.start();
//        }
        
        for(int i=0; i<horseList.size(); i++) {
        	horseList.get(i).start();
        }

        // 경기 중간에 위치를 출력하는 스레드
        RaceMonitor monitor = new RaceMonitor(horseList);
        Thread monitorThread = new Thread(monitor);
        monitorThread.start();

        // 모든 말 스레드가 종료될 때까지 대기
        for (Horse horse : horseList) {
            try {
                horse.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 모니터링 스레드도 종료
        try {
            monitorThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 경주가 끝난 후 순위에 따라 정렬
        Collections.sort(horseList);

        // 경기 종료 후 순위 출력
        System.out.println("\n경기 끝...");
        System.out.println("-----------------");
        System.out.println("경기 결과");
        System.out.println("=================");
        System.out.println("순위\t:\t이름");
        System.out.println("-----------------");

        for (Horse horse : horseList) {
            System.out.println(horse.getRank() + "등\t:\t" + horse.getHorseName());
        }
    }
}

class Horse extends Thread implements Comparable<Horse> {
	
    private String horseName;
    private int rank;
    private int position;

    public Horse(String horseName) {
        this.horseName = horseName;
    }

    public String getHorseName() {
        return horseName;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getPosition() {
        return position;
    }

    public void printPosition() {
        System.out.print(horseName + " ");
        for (int i = 1; i <= 50; i++) {
            if (i == position) {
                System.out.print(">");
            } else {
                System.out.print("-");
            }
        }
        System.out.println();
    }

    @Override
    public void run() {
        for (int i = 1; i <= 50; i++) {
            position = i;
            try {
            	// sleep() 메서드의 시간을 200~500 사이의 난수로 설정
                Thread.sleep((int) (Math.random() * 301 + 200));
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        setRank(HorseRace.currRank++);
        System.out.println(horseName + " 경주 끝...");
    }

    @Override
    public int compareTo(Horse otherHorse) {
        return Integer.compare(this.rank, otherHorse.getRank());
    }
}

class RaceMonitor implements Runnable {
    private List<Horse> horseList;

    public RaceMonitor(List<Horse> horseList) {
        this.horseList = horseList;
    }

    @Override
    public void run() {
        while (HorseRace.currRank <= horseList.size()) {
            try {
                Thread.sleep(300);  // 0.3초마다 상태 출력
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println();
            for (Horse horse : horseList) {
                horse.printPosition();  // 각 말의 위치 출력
            }
        }
    }
}