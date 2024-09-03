package homework;

public class PlanetArea {
    // Planet 열거형 선언
    public enum Planet {수성(2439),금성(6052),지구(6371),화성(3390),목성(69911),토성(58232),천왕성(25362),해왕성(24622);

        // 괄호속의 값인 행성의 반지름을 저장할 변수 선언
        private int radius;

        // 생성자 만들고 각 행성의 반지름을 초기화 시킨다
        Planet(int radius) {
            this.radius = radius;
        }

        // 반지름을 반환하는 getter 메서드
        public int getRadius() {
            return radius;
        }
    }

    public static void main(String[] args) {
        // 각 행성의 이름과 면적을 출력
        for (Planet planet : Planet.values()) {
            System.out.println(planet.name() + "의 면적: " + Math.round(4 * Math.PI * Math.pow(planet.getRadius(),2)) + " km");
        }
    }
}