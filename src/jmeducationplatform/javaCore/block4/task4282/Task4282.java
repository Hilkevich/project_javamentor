package jmeducationplatform.javaCore.block4.task4282;

public class Task4282 {

    public static void main(String[] args) {

        Robot robot = new Robot();
        moveRobot(robot, 2, 2);
    }

    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {

        RobotConnection robotConnection = null;                                        // пока соединения нет.

        for (int i = 0; i < 3; i++) {                                                  // пробуем подконектится 3 раза.

            try {                                                                      // try
                robotConnection = robotConnectionManager.getConnection();              //открываем connection
                robotConnection.moveRobotTo(toX, toY);                                 //двигаем робота
                                                                                       // если connection прошел i=3
                i = 3;
                robotConnection.close();

            } catch (RobotConnectionException rce) {
                                                           // здесь, если было искл. проверяем кол-во попыток и отключ.
                if (i == 2) {
                    throw new RobotConnectionException("ошибка");
                }

            } finally {
                try {
                    robotConnection.close();

                } catch (Exception e) {

                }
            }
        }
    }
}

