package jmeducationplatform.javaCore.block7.task7213;

import java.util.*;
import java.util.function.Consumer;

/**
 * Сервис который обрабатывает как зарплаты так и сообщения
 *
 * @param <T> сообщения или зарплаты
 */
public class MailService<T> implements Consumer<Sendable<T>> {

    /**
     * Почтовый ящик как для зарплат так и для сообщений
     */
    Map<String, List<T>> mailBox = new HashMap<String, List<T>>(); //{

    // @Override                                           // переопределим метод get у HashMap
    // public List<T> get(Object key) {
    //  return super.getOrDefault(key, new ArrayList<>()); //getOrDefault - вернет значение указанного ключа, или defaultValue, если эта карта не содержит значения для ключа
    //  }
    // };


    /**
     * Получает почтовый ящик как для зарплат так и для сообщений
     *
     * @return mailBox
     */
    public Map<String, List<T>> getMailBox() {


        Map<String, List<T>> resultMailBox = new HashMap<String, List<T>>() {

            @Override
            public List<T> get(Object key) {

                if (mailBox.containsKey(key)) {
                    return mailBox.get(key);
                } else {
                    return new ArrayList<>();
                }
            }
        };

        return resultMailBox;
    }


    List<T> chat = new ArrayList<>();

    /**
     * Наполняет mailBox контентом (зарплаты, сообщения)
     *
     * @param t Сообщения или зарплаты
     */
    @Override
    public void accept(Sendable<T> t) {

        if (mailBox.containsKey(t.getTo())) {
            chat = mailBox.get(t.getTo());
            chat.add(t.getContent());
            mailBox.put(t.getTo(), chat);
        } else {
            List<T> newChat = new ArrayList<>();
            newChat.add(t.getContent());
            mailBox.put(t.getTo(), newChat);

        }
    }
}

