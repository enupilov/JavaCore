package lesson1.obstacles;

import lesson1.Player;

public class Cross extends Obstacle {
    private int length;
    public Cross(int length) {
        this.length = length;
    }
    @Override
    public void doIt(Player animal) {
        animal.run(length);
    }
}
