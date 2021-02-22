/*

Эта задачка совмещает тренировку по материалу предыдущих двух модулей – необходимо разобраться и написать
объект-ориентированный код и при этом коснуться свежих тем – исключений и логирования.

Дан набор классов, описывающих работу гипотетической почтовой системы. Для начала рассмотрим код, описывающий все
используемые сущности.

Вам необходимо описать набор классов, каждый из которых является MailService:
                   UntrustworthyMailWorker, Spy, Thief, Inspector.

Все классы должны быть определены как публичные и статические, так как в процессе проверки ваш код будет подставлен
во внешний класс, который занимается тестированием и проверкой структуры. Для удобства во внешнем классе объявлено
несколько удобных констант и импортировано все содержимое пакета java.util.logging. Для определения, посылкой или
письмом является Sendable объект воспользуйтесь оператором instanceof.

 */

package jmeducationplatform.javaCore.block4.task437;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.logging.*;                                       // ? как импортировать.

public class Task437 {

    public static final String AUSTIN_POWERS = "Austin Powers";
    public static final String WEAPONS = "weapons";
    public static final String BANNED_SUBSTANCE = "banned substance";


    public static void main(String[] args) throws UnsupportedEncodingException {

        Logger logger = Logger.getLogger(Task437.class.getName());    // тесты, взяты из комментов, задача решается без них т.е никак не привязана к ним!
        logger.setLevel(Level.INFO);

        Inspector inspector = new Inspector();
        Spy spy = new Spy(logger);
        Thief thief = new Thief(10000);

        MailService[] variousWorkers = new MailService[]{spy, thief, inspector};
        UntrustworthyMailWorker worker = new UntrustworthyMailWorker(variousWorkers);

        Package pack1 = new Package("ВВЖ", 32);
        Package pack2 = new Package("ракетный двигатель ", 2500000);
        Package pack3 = new Package("stones", 1000);
        Package pack4 = new Package("banned substance", 99);
        Package pack5 = new Package("tiny bomb", 9000);

        AbstractSendable[] correspondence = {
                new MailMessage("Вася", "Петя", "Привет.\n" + "Как дела?"),
                new MailMessage("Петя", "Вася", "Все ок.\n" + "Задачу решаю."),
                new MailMessage("Саша", AUSTIN_POWERS, "Прием.На связь."),
                new MailMessage(AUSTIN_POWERS, "Саша", "На связи."),
                new MailPackage("берег", "море", pack1),
                new MailMessage("NASA", AUSTIN_POWERS, "Найди в России ракетные двигатели и лунные stones"),
                new MailPackage(AUSTIN_POWERS, "NASA", pack2),
                new MailPackage(AUSTIN_POWERS, "NASA", pack3),
                new MailPackage("Китай", "КНДР", pack4),
                new MailPackage(AUSTIN_POWERS, "ИГИЛ (запрещенная группировка", pack5),
                new MailMessage(AUSTIN_POWERS, "Психиатр", "Помогите"),
        };

        Arrays.stream(correspondence).forEach(parcell -> {
            try {
                worker.processMail(parcell);
            } catch (Inspector.StolenPackageException e) {
                logger.log(Level.WARNING, "Inspector found stolen package: " + e);
            } catch (Inspector.IllegalPackageException e) {
                logger.log(Level.WARNING, "Inspector found illegal package: " + e);
            }
        });

        System.out.println(thief.getStolenValue());
    }




    /*
    UntrustworthyMailWorker класс, моделирующий ненадежного работника почты, который вместо того, чтобы передать
    почтовый объект непосредственно в сервис почты, последовательно передает этот объект набору третьих лиц, а затем,
    в конце концов, передает получившийся объект непосредственно экземпляру RealMailService. У UntrustworthyMailWorker
    должен быть конструктор от массива MailService (результат вызова processMail первого элемента массива передается на
    вход processMail второго элемента, и т. д.) и метод getRealMailService, который возвращает ссылку на внутренний
    экземпляр RealMailService, он не приходит масивом в конструкторе и не настраивается извне класса.

    (Из коментов - набор третьих лиц это лица - Spy,Inspector,Thief (то есть все кто реализует интерфейс MailService).
     */

    public static class UntrustworthyMailWorker implements MailService {                    //класс,моделирующий ненадежного работника почты.

        private final RealMailService realMailService = new RealMailService();       // внутренний экземпляр RealMailService! создаем. private final - не настраивается извне класса.
        private MailService[] mailServices;                                          // массив, имя свое, произвольное.

        public UntrustworthyMailWorker(MailService[] blabla) {                             //имя массива произвольное сдесь, тк оно есть ...
            this.mailServices = blabla;                                                        //только внутри скобок! его присваиваем имени массива MailService[].
        }

        public MailService getRealMailService() {                                     // метод по условию
            return realMailService;                                                   // возвращаем ссылку на внутренний! экземпляр RealMailService
        }

        @Override
        public Sendable processMail(Sendable mail) {

            Sendable a = mail;                                           // создаем переменную типа Sendable и приходящее mail засовываем в нее.
            for (MailService check : mailServices) {                   // цикл for-each, в переменную с именем (любым) "check" и обязательно с таким же типом что и перебираемый массив mailServices (т.е MailService)
                a = check.processMail(a);                     //последовательно присваивается значение каждого элемента массива mailServices, после чего выполняется блок ниже.
            }
            return realMailService.processMail(a); // передаем получившийся! ,после всех, объект непосредственно экземпляру RealMailService т.е realMailService-у.
        }
    }

    /*
    Spy – шпион, который логгирует о всей почтовой переписке, которая проходит через его руки. Объект конструируется от
    экземпляра Logger, с помощью которого шпион будет сообщать о всех действиях. Он следит только за объектами класса
    MailMessage и пишет в логгер следующие сообщения (в выражениях нужно заменить части в фигурных скобках на значения
    полей почты):
    2.1) Если в качестве отправителя или получателя указан "Austin Powers", то нужно написать в лог сообщение с
    уровнем WARN: Detected target mail correspondence: from {from} to {to} "{message}"
    2.2) Иначе, необходимо написать в лог сообщение с уровнем INFO: Usual correspondence: from {from} to {to}
     */

    public static class Spy implements MailService {        // шпион, который логгирует о всей почтовой переписке.
        private Logger LOGGER;                                                  // логирование. 436

        public Spy(Logger logger) {
            LOGGER = logger;
        }

        @Override
        public Sendable processMail(Sendable mail) {

            if (mail instanceof MailMessage) {
                if (mail.getFrom() == AUSTIN_POWERS || mail.getTo() == AUSTIN_POWERS) {
                    LOGGER.log(Level.WARNING, "Detected target mail correspondence: from " + mail.getFrom() +
                            " to " + mail.getTo() + " \"" + ((MailMessage) mail).getMessage() + "\""); // сообщение по условию - в кавычках!
                } else {
                    LOGGER.log(Level.INFO, "Usual correspondence: from " + mail.getFrom() + " to " + mail.getTo());
                }
            }

            return mail;
        }
    }

    /*
    Thief – вор, который ворует самые ценные посылки и игнорирует все остальное. Вор принимает в конструкторе
    переменную int – минимальную стоимость посылки, которую он будет воровать. Также, в данном классе должен
    присутствовать метод getStolenValue, который возвращает суммарную стоимость всех посылок, которые он своровал.
    Воровство происходит следующим образом: вместо посылки, которая пришла вору, он отдает новую, такую же,
    только с нулевой ценностью и содержимым посылки "stones instead of {content}".

    ( Из комментов - Задать переменные лимит, сумму. В функции, если стоимость посылки больше лимита,то увеличить сумму
      и вернуть новую посылку с новым содержимым и новой стоимостью.)
     */

    public static class Thief implements MailService {                         // ворует самые ценные посылки и игнорирует все остальное.

        int limit;
        int prise = 0;

        @Override
        public Sendable processMail(Sendable mail) {


            if (mail instanceof MailPackage) {                            // проверяем явл. ли объект mail посылкой
                Package vor = ((MailPackage) mail).getContent();         // если да, то как бы копируем себе в свою переменную vor
                if (vor.getPrice() >= limit) {                          // если prise этой vor посылки >= установленного limit
                    prise = prise + vor.getPrice();                      // записываем ее prise в свой prise плюсуя каждую которая >= limit
                    mail = new MailPackage(mail.getFrom(), mail.getTo(), new Package("stones instead of " + vor.getContent(), 0));
                }
            }

            return mail;
        }

        public Thief(int limit) {
            this.limit = limit;
        }

        public int getStolenValue() {
            return prise;                       // возвращает суммарную int стоимость всех посылок, которые он своровал.
        }
    }

    /*
    Inspector – Инспектор, который следит за запрещенными и украденными посылками и бьет тревогу в виде исключения,
    если была обнаружена подобная посылка. Если он заметил запрещенную посылку с одним из запрещенных
    содержимым ("weapons" и "banned substance"), то он бросает IllegalPackageException. Если он находит посылку,
    состоящую из камней (содержит слово "stones"), то тревога прозвучит в виде StolenPackageException.
    Оба исключения вы должны объявить самостоятельно в виде непроверяемых исключений.

    ( Из комментов - если такой контент-одно исключение, иной - другое.)
     */

    public static class Inspector implements MailService {                // исключения.


        @Override
        public Sendable processMail(Sendable mail) {

            if (mail instanceof MailPackage) {                                      // проверяем явл. ли mail(т.е Sendable объект) письмом или посылкой!
                if (((MailPackage) mail).getContent().getContent().contains(WEAPONS) // раскрываем посылку! добираясь до строки. contains - на наличие подстроки.
                        || ((MailPackage) mail).getContent().getContent().contains(BANNED_SUBSTANCE)) {                    // или(||)
                    throw new IllegalPackageException();
                }
                if (((MailPackage) mail).getContent().getContent().contains("stones")) {
                    throw new StolenPackageException();
                }
            }
            return mail;
        }

        public static class IllegalPackageException extends RuntimeException {
            public IllegalPackageException() {          // конструктор
            }
        }

        public static class StolenPackageException extends RuntimeException {
            public StolenPackageException() {             // конструктор
            }
        }
    }
}

