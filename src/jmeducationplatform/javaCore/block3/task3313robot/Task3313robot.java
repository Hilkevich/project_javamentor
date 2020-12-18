package jmeducationplatform.javaCore.block3.task3313robot;

import jmeducationplatform.javaCore.block3.task3313.Task3313;

public class Task3313robot {


    public static void main(String[] args) {

        Task3313.Robot robot = new Task3313.Robot(-7, -5, Task3313.Direction.LEFT);
        moveRobot(robot, 10, 12);
    }

    public enum Direction {                // перечисления(константы) нужно вывести из класса Robot в Task.
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    public static class Robot {

        int X;
        int Y;
        Task3313.Direction direction;


        public Robot(int X, int Y, Task3313.Direction direction) {

            this.X = X;
            this.Y = Y;
            this.direction = direction;

        }


        public Task3313.Direction getDirection() {               //реализация этих методов НЕ ИЗВЕСТНА!?!!
            // текущее направление взгляда
            return direction;
        }

        public int getX() {
            // текущая координата X
            return X;
        }

        public int getY() {
            // текущая координата Y
            return Y;
        }


        public void turnLeft() {

            if (direction == Task3313.Direction.UP) {
                direction = Task3313.Direction.LEFT;
            } else if (direction == Task3313.Direction.LEFT) {
                direction = Task3313.Direction.DOWN;
            } else if (direction == Task3313.Direction.DOWN) {
                direction = Task3313.Direction.RIGHT;
            } else if (direction == Task3313.Direction.RIGHT) {
                direction = Task3313.Direction.UP;
            }
        }

        public void turnRight() {

            if (direction == Task3313.Direction.UP) {
                direction = Task3313.Direction.RIGHT;
            } else if (direction == Task3313.Direction.RIGHT) {
                direction = Task3313.Direction.DOWN;
            } else if (direction == Task3313.Direction.DOWN) {
                direction = Task3313.Direction.LEFT;
            } else if (direction == Task3313.Direction.LEFT) {
                direction = Task3313.Direction.UP;
            }
        }

        public void stepForward() {
            // шаг в направлении взгляда
            // за один шаг робот изменяет одну свою координату на единицу

            if (direction == Task3313.Direction.UP) {
                Y++;
            } else if (direction == Task3313.Direction.DOWN) {
                Y--;
            } else if (direction == Task3313.Direction.LEFT) {
                X--;
            } else if (direction == Task3313.Direction.RIGHT) {
                X++;
            }
        }

    }


    public static void moveRobot(Task3313.Robot robot, int toX, int toY) {

        if (toX > robot.getX()) {
            while (robot.getDirection() != Task3313.Direction.RIGHT) {
                robot.turnRight();
                System.out.println("turn right");
            }

            for (int i = robot.getX(); i != toX; i++) {
                robot.stepForward();
                System.out.println("шаг на " + (i + 1));
            }
        }

        System.out.println("fin toX > getX");

        // X куда < X где

        if (toX < robot.getX()) {
            while (robot.getDirection() != Task3313.Direction.LEFT) {
                robot.turnLeft();
                System.out.println(" turn left");
            }
            for (int i = robot.getX(); i != toX; i--) {
                robot.stepForward();
                System.out.println("шаг на " + (i - 1));
            }
        }

        System.out.println(" fin toX < getX");
        System.out.println("");
        System.out.println("пришел на X = " + toX);

        // Y куда > Y где

        System.out.println("");
        System.out.println("иду по оси Y");

        if (toY > robot.getY()) {
            while (robot.getDirection() != Task3313.Direction.UP) {
                robot.turnRight();
                System.out.println("turn right");
            }
            for (int i = robot.getY(); i != toY; i++) {
                robot.stepForward();
                System.out.println("шаг на " + (i + 1));
            }
        }
        System.out.println(" fin toY > getY");

        // Y куда < Y где

        if (toY < robot.getY()) {
            while (robot.getDirection() != Task3313.Direction.DOWN) {
                robot.turnLeft();
                System.out.println(" turn left");
            }
            for (int i = robot.getY(); i != toY; i--) {
                robot.stepForward();
                System.out.println("шаг на " + (i - 1));
            }
        }

        System.out.println(" fin toY < getY");
        System.out.println("");
        System.out.println("пришел на Y = " + toY);
        System.out.println(" fin! ");
    }
}
