/*

Создайте новое проверяемое исключение MyNewException, и создайте метод testExp(), который выбрасывает MyNewException
при вызове.

Требования:
1. Метод testExp() должен быть публичным и иметь тип возвращаемого значения void.
2. Класс исключения должен иметь модификатор доступа по умолчанию.
3. Метод testExp() расположите вне класса исключения.

 */

package jmeducationplatform.javaCore.block4.task417;

import javax.xml.bind.SchemaOutputResolver;

public class Task417 {

    class MyNewException extends Throwable {

    }

    public void testExp() throws MyNewException {

        throw new MyNewException();

    }
}
