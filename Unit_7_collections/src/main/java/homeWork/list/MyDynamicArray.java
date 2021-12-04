package homeWork.list;

import java.util.Iterator;

public interface MyDynamicArray {

    //пишем контракт, что будем использовать
    void add(Object o);         //добавляет объект
    Object get(int i);          //возвращает объект по индексу
    void set(int i, Object o);  //изменяет объект по индексу, и само значение
    void delete(int i);         //удаляет объект по индексу
    Object[] findAll();         //отображает все объекты списка, т.е. возвращает массив объектов

    Iterator<Integer> iterator();
}
