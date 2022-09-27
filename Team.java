package lesson1;

import lesson1.animals.Cat;
import lesson1.animals.Dog;
import lesson1.obstacles.Obstacle;

public class Team {
    private String name;
    private Player players[];

    public Team(String name) {
        this.name = name;
    }

    public Team(String name,Player ... playersGiven ) {
        this.name = name;
        this.players = playersGiven;
    }

    public void getTeamInfo() {
        System.out.println("Команда: " + this.name );
        for (Player player : players) {
            if (player instanceof Dog) {
                System.out.println("Собака " + player.getName());
            }
            if (player instanceof Cat) {
                System.out.println("Кот " + player.getName());
            }
            if (player instanceof Robot) {
                System.out.println("Робот " + player.getName());
            }
        }
    }

    public void showResults(){
        for (Player player : players) {
            //obstacle.doIt(participant);
            if (!player.isOnDistance()) {
                break;
            }
        }
    }

    public void doIt(Obstacle obstacle){
        for (Player player : players) {
            obstacle.doIt(player);
        }
    }
}
