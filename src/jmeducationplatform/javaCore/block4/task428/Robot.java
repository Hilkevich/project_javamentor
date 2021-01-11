package jmeducationplatform.javaCore.block4.task428;

public class Robot implements RobotConnection, RobotConnectionManager{

    private int X;
    private int Y;
    private boolean connection;


    public Robot(int X, int Y, boolean connection) {

        this.X = X;
        this.Y = Y;
        this.connection = connection;

    }

    public int getX() {                                   // текущая координата X
        return X;
    }

    public int getY() {                                   // текущая координата Y
        return Y;
    }

    public boolean getConnection() {                       // подключение есть/нет
        return connection;
    }

    @Override
    public void moveRobotTo(int x, int y) throws RobotConnectionException {

    }

    @Override
    public void close() {

    }
}


