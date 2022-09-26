package lesson1;

import lesson1.animals.Cat;
import lesson1.animals.Dog;
import lesson1.obstacles.*;

public class Application {

    public static void main(String[] args) {

        Course c = new Course(new Obstacle[] {
                new Cross(6),
                new Wall(4),
                new Water(8)
        });
        Team team = new Team("Непобедимые",
                new Cat("Черныш", 8, 10, 0),
                new Dog("Рекс", 18, 4, 14),
                new Cat("Рыжик", 10, 12, 0),
                new Robot("Марк", 50, 50, 50));  // Создаем команду
        team.getTeamInfo();

        c.doIt(team);
        team.showResults();

    }
}
