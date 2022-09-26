package lesson1.obstacles;

import lesson1.Player;

public class Wall extends Obstacle{
    private int height;
    public Wall(int height) {this.height = height;}
    @Override
    public void doIt(Player player) {player.jump(height);}
}
