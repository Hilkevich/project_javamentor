package jmeducationplatform.javaCore.block4.task426;

public class Employee implements BankWorker {

    @Override
    public boolean checkClientForCredit(BankClient bankClient) throws BadCreditHistoryException, ProblemWithLawException {

        if (BankClient.isBadCreditHistory() == true) {
            throw new BadCreditHistoryException();

        } else if (BankClient.isProblemWithLaw() == true) {
            throw new ProblemWithLawException();

        } else return true;
    }
}

