package homeWork.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListTest {

    private final int size = 100_000;
    private final List<Integer> arrayList = new ArrayList<>(size);
    private final List<Integer> linkedList = new LinkedList<>();
    private final MyDynamicArray myDynamicArray = new MyDynamicArrayImpl();

    public void run() {

        create();
//        read();
//        update();
        delete();
        }

        private void create() {
            System.out.println("Create lists");
            System.out.println("Start arrayList");
            long start = System.currentTimeMillis();
            for (int i = 0; i < size; i++) {
                arrayList.add(i);
            }
            long end = System.currentTimeMillis() - start;
            System.out.println("Finish arrayList - " + end);

            System.out.println("Start linkedList");
            start = System.currentTimeMillis();
            for (int i = 0; i < size; i++) {
                linkedList.add(i);
            }
            end = System.currentTimeMillis() - start;
            System.out.println("Finish linkedList - " + end);

            System.out.println("Start MyDynamicArray");
            start = System.currentTimeMillis();
            for (int i = 0; i < size; i++) {
                myDynamicArray.add(i);
            }
            end = System.currentTimeMillis() - start;
            System.out.println("Finish MyDynamicArray - " + end);
        }

        private void read() {
            System.out.println("Read lists");
            System.out.println("Start arrayList");
            long start = System.currentTimeMillis();
            for (int i = 0; i < size; i++) {
                arrayList.get(i);
            }
            long end = System.currentTimeMillis() - start;
            System.out.println("Finish arrayList - " + end);

            System.out.println("Start linkedList");
            start = System.currentTimeMillis();
            for (int i = 0; i < size; i++) {
                linkedList.get(i);
            }
            end = System.currentTimeMillis() - start;
            System.out.println("Finish linkedList - " + end);

            System.out.println("Start MyDynamicArray");
            start = System.currentTimeMillis();
            for (int i = 0; i < size; i++) {
                myDynamicArray.get(i);
            }
            end = System.currentTimeMillis() - start;
            System.out.println("Finish MyDynamicArray - " + end);
        }
        private void update() {
            System.out.println("Update lists");
            System.out.println("Start arrayList");
            long start = System.currentTimeMillis();
            for (int i = 0; i < size; i++) {
                arrayList.set(i, i);
            }
            long end = System.currentTimeMillis() - start;
            System.out.println("Finish arrayList - " + end);

            System.out.println("Start linkedList");
            start = System.currentTimeMillis();
            for (int i = 0; i < size; i++) {
                linkedList.set(i, i);
            }
            end = System.currentTimeMillis() - start;
            System.out.println("Finish linkedList - " + end);

            System.out.println("Start MyDynamicArray");
            start = System.currentTimeMillis();
            for (int i = 0; i < size; i++) {
                myDynamicArray.set(i, i);
            }
            end = System.currentTimeMillis() - start;
            System.out.println("Finish MyDynamicArray - " + end);
        }

        //удалять нужно аккуратно, тк удаляя по индексу, освобождаются ячейки, джава в любой момент может принять решение
        //уменьшить размер массива, и тогда следующий в списке индекс может остаться за пределами массива
        //правильно удалять коллекции через итераторы - каждая коллекция может его вернуть, это ее внутренний счетчик,
        // который предоставляет методы для получения элемента
        private void delete() {
            System.out.println("ListTest.delete");
            Iterator<Integer> iteratorArrayList = arrayList.iterator();
            Iterator<Integer> iteratorLinkedList = linkedList.iterator();
            Iterator<Integer> iteratorMyDynamicArray = myDynamicArray.iterator();

            System.out.println("Start arrayList");
            long start = System.currentTimeMillis();
//            проверяем, что есть следующий элемент, и побежим итератором, не фором
            while (iteratorArrayList.hasNext()) {
                iteratorArrayList.next();
                iteratorArrayList.remove();
            }
            long end = System.currentTimeMillis() - start;
            System.out.println("Finish arrayList - " + end);

            System.out.println("Start linkedList");
            start = System.currentTimeMillis();
            while (iteratorLinkedList.hasNext()) {
                iteratorLinkedList.next();
                iteratorLinkedList.remove();
            }
            end = System.currentTimeMillis() - start;
            System.out.println("Finish MyDynamicArray - " + end);

            while (iteratorMyDynamicArray.hasNext()) {
                iteratorMyDynamicArray.next();
                iteratorMyDynamicArray.remove();
            }
            end = System.currentTimeMillis() - start;
            System.out.println("Finish MyDynamicArray - " + end);
        }
}
