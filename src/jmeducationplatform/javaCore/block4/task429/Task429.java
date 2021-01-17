/*

Реши задачу с использованием try-with-resources!

Вспомним нашего старого знакомого робота. Теперь мы будем давать роботу команды удаленно, подключаясь к нему по
беспроводному каналу связи.

Подключение к роботу представляется в программе интерфейсом RobotConnection:
public interface RobotConnection extends AutoCloseable {
    void moveRobotTo(int x, int y);
    @Override
    void close();
}

Да, робот с тех пор поумнел и стал понимать команду на перемещение в заданную точку (метод moveRobotTo). Ему больше не
нужны пошаговые инструкции.
RobotConnection - это временно устанавливаемое соединение, которое надо закрывать, когда оно больше не нужно.
Для закрытия соединения в интерфейсе есть метод close().

За установку соединения отвечает RobotConnectionManager:

public interface RobotConnectionManager {
    RobotConnection getConnection();
}

Метод getConnection() делает попытку соединиться с роботом и возвращает установленное соединение, через которое можно
отдавать роботу команды.
Установка соединения может завершиться неуспешно, а также уже установленное соединение может внезапно разорваться.
Всякое бывает. Поэтому любой метод RobotConnectionManager и RobotConnection может бросить непроверяемое
исключение RobotConnectionException:

public class RobotConnectionException extends RuntimeException {

    public RobotConnectionException(String message) {
        super(message);
    }
    public RobotConnectionException(String message, Throwable cause) {
        super(message, cause);
    }
}

Ваша задача - реализовать метод который устанавливает соединение с роботом, отдает ему команду на перемещение в
заданную точку и затем закрывает соединение, выполняя при необходимости повтор этой последовательности до трех раз.

При этом:

Попытка отдать команду роботу считается успешной, если удалось установить соединение и выполнить метод
RobotConnection.moveRobotTo() без исключений. Ошибка закрытия соединения не важна и должна игнорироваться.
Если первая попытка подключиться и отдать команду оказалась неуспешной, то закрываем соединение и выполняем
вторую попытку.
Если вторая тоже не удалась, то выполняется третья. После третьей неудачи метод должен бросить исключение
RobotConnectionException.
Метод отвечает за открытие и закрытие соединения. Если соединение удалось установить, то оно обязательно должно быть
закрыто несмотря на возможные исключения, случившиеся в дальнейшем во время работы метода.
Если во время работы метода случилось исключение любого типа, отличного от RobotConnectionException, метод должен
завершиться и выбросить это исключение, не выполняя повторных попыток пообщаться с роботом. Единственное, что метод
должен сделать перед выбросом этого исключения — закрыть открытое соединение RobotConnection.

В решение НЕ должен использоваться классический try-catch.
Реши задачу с использованием try-with-resources!

 */

package jmeducationplatform.javaCore.block4.task429;

public class Task429 {

    public static void main(String[] args) {

        Robot robot = new Robot();
        moveRobot(robot, 2, 2);
    }

    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {

        for (int i = 0; i < 3; i++) {                                                  // пробуем подконектится 3 раза.
            try (RobotConnection robotConnection = robotConnectionManager.getConnection()) {// try открываем connection
                robotConnection.moveRobotTo(toX, toY);                                      //двигаем робота
                i = 3;                                                             // если connection прошел i=3

            } catch (RobotConnectionException rce) {
                if (i == 2) {                              // здесь, если было искл. проверяем кол-во попыток и отключ.
                    throw new RobotConnectionException("ошибка");
                }
            }
        }
    }
}






