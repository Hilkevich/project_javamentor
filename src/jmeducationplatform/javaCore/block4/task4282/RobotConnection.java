package jmeducationplatform.javaCore.block4.task4282;

public interface RobotConnection extends AutoCloseable{

    void moveRobotTo(int x, int y);
    @Override
    void close();
}
