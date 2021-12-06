package ua.com.alevel;

import org.w3c.dom.Node;
import ua.com.alevel.hw_5.CustomMapImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GenericsMain {

    public static <K, V> void main(String[] args) {
        System.out.println("Generics Main");

        CustomMapImpl<String, String> customMapImpl = new CustomMapImpl<>();
        customMapImpl.put(UUID.randomUUID().toString(), "value 1");
        customMapImpl.put(UUID.randomUUID().toString(), "value 2");
        customMapImpl.put(UUID.randomUUID().toString(), "value 3");
        customMapImpl.put(UUID.randomUUID().toString(), "value 4");

        System.out.println("customMapImpl = " + customMapImpl);

        customMapImpl.setKeys();
//        customMapImpl.listValues();
//        customMapImpl.get();

    }
//        BeforeGenerics list = new BeforeGenerics();
//        list.add(1);
//        list.add(1L);
//        list.add(1.9d);
//        list.add("10");
//
//        for (int i = 0; i < 4; i++) {
//            System.out.println("i = " + list.get(i));
//        }
//
//        //второй вариант создания листа, не через дефолтный конструктор, а через создание листа, работающего только с одинм типом данных:
//        //то есть в список передаем класс объекта
//        list = new BeforeGenerics(String.class);
//        list.add("");
//        list.add("");
//        list.add("");
//        list.add("");
////        list.add(5);
//
//        AfterGeneric<String> afterGeneric = new AfterGeneric<>(); //явно укажем, что будем работать с классом String
//        afterGeneric.add("1");
//        afterGeneric.add("2");
//        afterGeneric.add("3");
//        afterGeneric.add("4");
//
//        for (int i = 0; i < 4; i++) {
//            System.out.println("afterGeneric.get(i) = " + afterGeneric.get(i));
//            System.out.println("afterGeneric.get(i) = " + afterGeneric.get(i).getClass().getName()); //проверим тип объекта
//
//        }
//
////        Customer customer = new Customer();
////        customer = ParameterMethod.newInstance();
//        Customer customer = ParameterMethod.newInstance(Customer.class);
//        customer.setAge(15);
//        customer.setName("SomeName");
//
//        System.out.println("customer = " + customer);

}
