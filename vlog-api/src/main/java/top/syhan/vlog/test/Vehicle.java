package top.syhan.vlog.test;

/**
 * @program: vlog-api
 * @description:
 * @author: SYH
 * @create: 2022-04-23 20:28
 **/
public class Vehicle {
    private int speed;

    public void move() {
        System.out.println("i’m moving");
    }

    public void setSpeed(int speed) {
        System.out.println("now i’m running with " + speed + " per hour");
    }

    public void speedUp() {
        this.setSpeed(100);
    }

    public void speedDown() {
        this.setSpeed(20);
    }

    public static void main(String[] dsa) {
        Vehicle v = new Vehicle();
        v.speed = 50;
        System.out.println("the initial speed is " + v.speed);
        v.move();
        v.speedUp();
        v.speedDown();
    }
}
