package jmeducationplatform.javaCore.block4.task437;

/*

Интерфейс, который задает класс, который может каким-либо образом обработать почтовый объект.

*/

public interface MailService {       // моделирует работу почтового сервиса.

    Sendable processMail(Sendable mail);
}

