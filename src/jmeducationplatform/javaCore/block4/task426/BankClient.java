package jmeducationplatform.javaCore.block4.task426;

public class BankClient {

    private static boolean badCreditHistory;
    private static boolean problemWithLaw;

    public static boolean isBadCreditHistory() {
        return badCreditHistory;
    }

    public static void setBadCreditHistory(boolean badCreditHistory) {
        BankClient.badCreditHistory = badCreditHistory;
    }

    public static boolean isProblemWithLaw() {
        return problemWithLaw;
    }

    public static void setProblemWithLaw(boolean problemWithLaw) {
        BankClient.problemWithLaw = problemWithLaw;
    }
}


