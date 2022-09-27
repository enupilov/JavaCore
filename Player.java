package lesson1;

public interface Player {
    String getName();
    boolean isOnDistance();
    void run(int distance);
    void jump(int height);
    void swim(int distance);
}
