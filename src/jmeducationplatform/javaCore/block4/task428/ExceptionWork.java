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
            RobotConnection rc = new Robot(0, 0, Direction.DOWN, isTM, isTC, isException);
            return rc;
        }


        public static void main(String[] args) {

            try {
                RobotConnectionManagerImplementation rcm = new RobotConnectionManagerImplementation(3, 3, false, 1);
                moveRobot(rcm, 2, 2);
            } catch (Exception r) {
                System.out.println("TEST #1 " + ((r.getMessage() == "MOVE EXCEPTION") ? "PASS" : "FAILED WITH " + r.getMessage()));
            }

            try {
                RobotConnectionManagerImplementation rcm = new RobotConnectionManagerImplementation(0, 0, false, 0);
                moveRobot(rcm, 2, 2);
                System.out.println("TEST #2 PASS");
            } catch (RobotConnectionException r) {
                System.out.println("TEST #2 FAILED WITH " + r.getMessage());
            }

            try {
                RobotConnectionManagerImplementation rcm = new RobotConnectionManagerImplementation(2, 0, false, 0);
                moveRobot(rcm, 2, 2);
                System.out.println("TEST #3 PASS");
            } catch (Exception r) {
                System.out.println("TEST #3 FAILED WITH " + r.getMessage());
            }

            try {
                RobotConnectionManagerImplementation rcm = new RobotConnectionManagerImplementation(3, 0, false, 0);
                moveRobot(rcm, 2, 2);
            } catch (Exception r) {
                System.out.println("TEST #4 " + ((r.getMessage() == "MOVE EXCEPTION") ? "PASS" : "FAILED WITH " + r.getMessage()));
            }

            try {
                RobotConnectionManagerImplementation rcm = new RobotConnectionManagerImplementation(3, 0, true, 0);
                moveRobot(rcm, 2, 2);
            } catch (Exception r) {
                System.out.println("TEST #5 " + ((r.getMessage() == "ANOTHER EXCEPTION") ? "PASS" : "FAILED WITH " + r.getMessage()));
            }

            try {
                RobotConnectionManagerImplementation rcm = new RobotConnectionManagerImplementation(2, 5, false, 0);
                moveRobot(rcm, 2, 2);
                System.out.println("TEST #6 PASS");
            } catch (Exception r) {
                System.out.println("TEST #6 FAILED WITH " + r.getMessage());
            }

            try {
                RobotConnectionManagerImplementation rcm = new RobotConnectionManagerImplementation(0, 5, false, 2);
                moveRobot(rcm, 2, 2);
                System.out.println("TEST #7 PASS");
            } catch (Exception r) {
                System.out.println("TEST #7 FAILED WITH " + r.getMessage());
            }

            try {
                RobotConnectionManagerImplementation rcm = new RobotConnectionManagerImplementation(1, 0, false, 2);
                moveRobot(rcm, 2, 2);
            } catch (Exception r) {
                System.out.println("TEST #8 " + ((r.getMessage() == "MOVE EXCEPTION") ? "PASS" : "FAILED WITH " + r.getMessage()));
            }
        }
    }
}
