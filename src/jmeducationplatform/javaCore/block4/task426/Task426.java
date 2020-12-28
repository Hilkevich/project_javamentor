/*

Есть класс BankClient - это класс, описывающий клиента банка.

Есть интерфейс BankWorker. Объект класса, который реализует этот интерфейс является работником банка, в задачу
которого входит одобрение или отклонение заявок на кредиты.

У него есть метод checkClientForCredit, который на вход принимает экземпляр BankClient и возвращает true,
 1) если всё впорядке и кредит переданному клиенту можно выдавать, или false - если клиент не подходит под условия кредита.
 2) Также, этот метод может выбросить исключение BadCreditHistoryException, если у клиента плохая кредитная история.
Или ProblemWithLawException, если у клиента есть проблемы с законом.

Ваша задача:

Реализовать метод getCreditForClient, который принимает работника банка и клиента, который хочет получить кредит.
Метод должен возвращать true - если кредит выдать можно и все условия соблюдены и false если есть какие-то проблемы.
Если клиенту отказали в выдаче кредита по причине плохой банковской истории - метод должен выводить в консоль сообщение
"Проблемы с банковской историей", если клиенту отказали по причине проблем с законом то ничего выводить на экран
не нужно.

 */


package jmeducationplatform.javaCore.block4.task426;

public class Task426 {

    public static void main(String[] args) {

        BankClient bankClient = new BankClient();
        Employee employee = new Employee();

        BankClient.setBadCreditHistory(false);
        BankClient.setProblemWithLaw(false);

        getCreditForClient(employee, bankClient);

    }

    public static boolean getCreditForClient(BankWorker bankWorker, BankClient bankClient) {

        try {
            return bankWorker.checkClientForCredit(bankClient);

        } catch (BadCreditHistoryException e) {
            System.out.println("Проблемы с банковской историей");
            return false;

        } catch (ProblemWithLawException e) {
            return false;
        }
    }
}

