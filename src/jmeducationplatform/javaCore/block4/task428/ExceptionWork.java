package jmeducationplatform.javaCore.block4.task428;

public class ExceptionWork {

    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        // мой код
    }

    public static class RobotConnectionManagerImplementation implements RobotConnectionManager {

        private int throwNumberMove;
        private int throwNumberClose;
        private boolean isException;
        private int connectionAttempt;
        private int curCA = 0;
        private int curNM = 0;
        private int curNC = 0;

        public RobotConnectionManagerImplementation(int tnm, int tnc, boolean ie, int ca) {
            throwNumberMove = tnm;
            throwNumberClose = tnc;
            isException = ie;
            connectionAttempt = ca;
        }

@Override
        public RobotConnection getConnection() {

          if (curCA < connectionAttempt) {
              curCA++;
              throw new RobotConnectionException("CONNECTION EXCEPTION");
          }
          boolean isTC = false;
          boolean isTM = false;
          if (curNC < throwNumberClose) {
              isTC = true;
              curNC++;
          }
          if (curNM < throwNumberMove) {
              isTM = true;
              curNM++;
          }
          RobotConnection rc = new Robot(0,0, Direction.DOWN, isTM, isTC, isException);
          return rc;
        }
    }
}