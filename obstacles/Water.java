package lesson1.obstacles;

import lesson1.Player;

public class Water extends Obstacle{
    private int length;
    public Water(int length) {this.length = length;}
    @Override
    public void doIt(Player player) {player.swim(length);}
}
