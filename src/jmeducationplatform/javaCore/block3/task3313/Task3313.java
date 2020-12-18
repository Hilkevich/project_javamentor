/*

На игровом поле находится робот. Позиция робота на поле описывается двумя целочисленным координатами: X и Y.
Ось X смотрит слева направо, ось Y - снизу вверх. (Помните, как рисовали графики функций в школе?)

В начальный момент робот находится в некоторой позиции на поле. Также известно, куда робот смотрит: вверх, вниз,
направо или налево. Ваша задача — привести робота в заданную точку игрового поля.

Робот описывается классом Robot. Вы можете пользоваться следующими его методами (реализация вам неизвестна):

public class Robot {

    public Direction getDirection() {
        // текущее направление взгляда
    }

    public int getX() {
        // текущая координата X
    }

    public int getY() {
        // текущая координата Y
    }

    public void turnLeft() {
        // повернуться на 90 градусов против часовой стрелки
    }

    public void turnRight() {
        // повернуться на 90 градусов по часовой стрелке
    }

    public void stepForward() {
        // шаг в направлении взгляда
        // за один шаг робот изменяет одну свою координату на единицу
    }
}
Direction, направление взгляда робота, - это перечисление:

public enum Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT
}

Пример
В метод передано: toX == 3, toY == 0; начальное состояние робота такое: robot.getX() == 0, robot.getY() == 0,
 robot.getDirection() == Direction.UP

Чтобы привести робота в указанную точку (3, 0), метод должен вызвать у робота следующие методы:

robot.turnRight();
robot.stepForward();
robot.stepForward();
robot.stepForward();

Требования:
1. должен быть метод public static void moveRobot(Robot robot, int toX, int toY)
2. метод moveRobot должен переместить робота в позицию int toX, int toY

 */

package jmeducationplatform.javaCore.block3.task3313;


public class Task3313 {

    public static void main(String[] args) {

        Robot robot = new Robot(-7, -5, Direction.UP);
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
        Direction direction;


        public Robot(int X, int Y, Direction direction) {

            this.X = X;
            this.Y = Y;
            this.direction = direction;

        }


        public Direction getDirection() {               //реализация этих методов НЕ ИЗВЕСТНА!?!!
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

            if (direction == Direction.UP) {
                direction = Direction.LEFT;
            } else if (direction == Direction.LEFT) {
                direction = Direction.DOWN;
            } else if (direction == Direction.DOWN) {
                direction = Direction.RIGHT;
            } else if (direction == Direction.RIGHT) {
                direction = Direction.UP;
            }
        }

        public void turnRight() {

            if (direction == Direction.UP) {
                direction = Direction.RIGHT;
            } else if (direction == Direction.RIGHT) {
                direction = Direction.DOWN;
            } else if (direction == Direction.DOWN) {
                direction = Direction.LEFT;
            } else if (direction == Direction.LEFT) {
                direction = Direction.UP;
            }
        }

        public void stepForward() {
            // шаг в направлении взгляда
            // за один шаг робот изменяет одну свою координату на единицу

            if (direction == Direction.UP) {
                Y++;
            } else if (direction == Direction.DOWN) {
                Y--;
            } else if (direction == Direction.LEFT) {
                X--;
            } else if (direction == Direction.RIGHT) {
                X++;
            }
        }

    }

    public static void moveRobot(Robot robot, int toX, int toY) {     // toX и toY - это куда именно должен прийти.

        // X куда > X где

        System.out.println("иду по оси Х");




        if (toX > robot.getX() & robot.getDirection() == Direction.LEFT) {
            robot.turnRight();
            robot.turnRight();
            for (int i = robot.getX(); i != toX; i++) {
                robot.stepForward();
                System.out.println("шаг на " + (i + 1));
            }
        }
        if (toX > robot.getX() & robot.getDirection() == Direction.RIGHT) {
            for (int i = robot.getX(); i != toX; i++) {
                robot.stepForward();
                System.out.println("шаг на " + (i + 1));
            }
        }
        if (toX > robot.getX() & robot.getDirection() == Direction.UP) {
            robot.turnRight();
            for (int i = robot.getX(); i != toX; i++) {
                robot.stepForward();
                System.out.println("шаг на " + (i + 1));
            }
        }
        if (toX > robot.getX() & robot.getDirection() == Direction.DOWN) {
            robot.turnLeft();
            for (int i = robot.getX(); i != toX; i++) {
                robot.stepForward();
                System.out.println("шаг на " + (i + 1));
            }
        }

        // X куда < X где

        if (toX < robot.getX() & robot.getDirection() == Direction.LEFT) {
            for (int i = robot.getX(); i != toX; i--) {
                robot.stepForward();
                System.out.println("шаг на " + (i - 1));
            }
        }
        if (toX < robot.getX() & robot.getDirection() == Direction.RIGHT) {
            robot.turnRight();
            robot.turnRight();
            for (int i = robot.getX(); i != toX; i--) {
                robot.stepForward();
                System.out.println("шаг на " + (i - 1));
            }
        }
        if (toX < robot.getX() & robot.getDirection() == Direction.UP) {
            robot.turnLeft();
            for (int i = robot.getX(); i != toX; i--) {
                robot.stepForward();
                System.out.println("шаг на " + (i - 1));
            }
        }
        if (toX < robot.getX() & robot.getDirection() == Direction.DOWN) {
            robot.turnRight();
            for (int i = robot.getX(); i != toX; i--) {
                robot.stepForward();
                System.out.println("шаг на " + (i - 1));
            }
        }
        System.out.println("");
        System.out.println("пришел на X = " + toX);

        // Y куда > Y где

        System.out.println("");
        System.out.println("иду по оси Y");

        if (toY > robot.getY() & robot.getDirection() == Direction.LEFT) {
            robot.turnRight();
            for (int i = robot.getY(); i != toY; i++) {
                robot.stepForward();
                System.out.println("шаг на " + (i + 1));
            }
        }
        if (toY > robot.getY() & robot.getDirection() == Direction.RIGHT) {
            robot.turnLeft();
            for (int i = robot.getY(); i != toY; i++) {
                robot.stepForward();
                System.out.println("шаг на " + (i + 1));
            }
        }
        if (toY > robot.getY() & robot.getDirection() == Direction.UP) {
            for (int i = robot.getY(); i != toY; i++) {
                robot.stepForward();
                System.out.println("шаг на " + (i + 1));
            }
        }
        if (toY > robot.getY() & robot.getDirection() == Direction.DOWN) {
            robot.turnLeft();
            robot.turnLeft();
            for (int i = robot.getY(); i != toY; i++) {
                robot.stepForward();
                System.out.println("шаг на " + (i + 1));
            }
        }

        // Y куда < Y где

        if (toY < robot.getY() & robot.getDirection() == Direction.LEFT) {
            robot.turnLeft();
            for (int i = robot.getY(); i != toY; i--) {
                robot.stepForward();
                System.out.println("шаг на " + (i - 1));
            }
        }
        if (toY < robot.getY() & robot.getDirection() == Direction.RIGHT) {
            robot.turnRight();
            for (int i = robot.getY(); i != toY; i--) {
                robot.stepForward();
                System.out.println("шаг на " + (i - 1));
            }
        }
        if (toY < robot.getY() & robot.getDirection() == Direction.UP) {
            robot.turnRight();
            robot.turnRight();
            for (int i = robot.getY(); i != toY; i--) {
                robot.stepForward();
                System.out.println("шаг на " + (i - 1));
            }
        }
        if (toY < robot.getY() & robot.getDirection() == Direction.DOWN) {
            for (int i = robot.getY(); i != toY; i--) {
                robot.stepForward();
                System.out.println("шаг на " + (i - 1));
            }
        }
        System.out.println("");
        System.out.println("пришел на Y = " + toY);
    }
}

