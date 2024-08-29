package homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student implements Comparable<Student> {
    private String studentId;
    private String name;
    private int koreanScore;
    private int englishScore;
    private int mathScore;
    private int totalScore;
    private int rank;

    // 생성자
    public Student(String studentId, String name, int koreanScore, int englishScore, int mathScore) {
        this.studentId = studentId;
        this.name = name;
        this.koreanScore = koreanScore;
        this.englishScore = englishScore;
        this.mathScore = mathScore;
        this.totalScore = koreanScore + englishScore + mathScore;
    }

    // Getters and Setters
    public String getStudentId() {
        return studentId;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    // 학번 오름차순 정렬을 위한 Comparable 인터페이스 메서드 구현
    @Override
    public int compareTo(Student other) {
        return this.studentId.compareTo(other.studentId);
    }

    // toString 메서드
    @Override
    public String toString() {
        return String.format("%s, %s, 국어: %d, 영어: %d, 수학: %d, 총점: %d, 등수: %d",
                studentId, name, koreanScore, englishScore, mathScore, totalScore, rank);
    }

    // 총점 내림차순 정렬을 위한 Comparator
    public static Comparator<Student> totalScoreComparator = new Comparator<Student>() {
        @Override
        public int compare(Student s1, Student s2) {
            if (s1.totalScore != s2.totalScore) {
                return Integer.compare(s2.totalScore, s1.totalScore);
            } else {
                return s2.studentId.compareTo(s1.studentId); // 총점이 같으면 학번의 내림차순으로 정렬
            }
        }
    };
}

public class ListSort {
    public static void main(String[] args) {
        // Student 객체 생성 및 리스트에 추가
        List<Student> students = new ArrayList<>();
        students.add(new Student("11111111", "김춘삼", 65, 90, 95));
        students.add(new Student("22222222", "황덕구", 90, 75, 85));
        students.add(new Student("33333333", "강근식", 80, 95, 90));
        students.add(new Student("44444444", "왕대만", 75, 80, 70));

        // 총점 내림차순 정렬 및 등수 계산
        Collections.sort(students, Student.totalScoreComparator);
        int currentRank = 1;
        for (int i = 0; i < students.size(); i++) {
            if (i > 0 && students.get(i).getTotalScore() == students.get(i - 1).getTotalScore()) {
                students.get(i).setRank(students.get(i - 1).getRank());
            } else {
                students.get(i).setRank(currentRank);
            }
            currentRank++;
        }

        // 학번 오름차순 정렬
        Collections.sort(students);
        System.out.println("학번 오름차순 정렬:");
        for (Student student : students) {
            System.out.println(student);
        }

        // 총점 내림차순 정렬 후 등수 출력
        Collections.sort(students, Student.totalScoreComparator);
        System.out.println("\n총점 내림차순 정렬 (총점이 같으면 학번 내림차순):");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}