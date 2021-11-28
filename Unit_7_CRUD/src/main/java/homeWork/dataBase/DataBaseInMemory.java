package homeWork.dataBase;

import homeWork.customer.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

//использование паттерна singleton гарантирует, что дата класс существует в единственном экземпляре в heap
//и сколько бы у нас не появилось сервисов, которые будут обращаться к этому классу, мы всегда будем иметь один и тот же
//instance класс
//иными словами, только данный класс может создать новый экземпляр своего класса, другие классы не могут создать ему новый экземпляр
public class DataBaseInMemory {

    private final List<Customer> customerList = new ArrayList<>();

    //создаем внутри класса приватную статическую переменную, называть их принятно instance
    private final static DataBaseInMemory instance = new DataBaseInMemory();
    //затем создадим интерфейс взаимодействия с этим instance - getInstance

    //паттерн синглтон:
/*    private DataBaseInMemory () { }
    public static DataBaseInMemory getInstance() {
        if (instance == null) {
            instance = new DataBaseInMemory();
        }
        return instance;
    }
*/
    //или ленивый синглтон, при котором следует переменную instance сделать final

    private DataBaseInMemory () { }
    public static DataBaseInMemory getInstance() {
        return instance;
    }
    //инициализируем методы, указав параметры:
    public void insert (Customer customer) {
        customer.setId(generateId()); //генерирует айди
        customerList.add(customer); //кладем в список нового кастомера
    }

    public Customer selectById (String id) {
        for (Customer customer : customerList) {
            if (customer.getId().equals(id)) {
                return customer;
            }
        }
        return null;
    }

    public List<Customer> selectAll () {
        return customerList;
    }

    public void delete (String id) {

//        for (Customer customer : customerList) {        <---- плохой способ удаления
//                if (customer.getId().equals(id)) {      <---- плохой способ удаления
//                customerList.remove(customer);          <---- плохой способ удаления
//                }                                       <---- плохой способ удаления
//            }                                           <---- плохой способ удаления

        customerList.removeIf(customer -> customer.getId().equals(id));      // способ "Удали если соответствует условию"
    }

    public void update (Customer customer) {
        for (Customer current : customerList) {
            //тк уже есть переменная customer в параметрах метода, поэтому создаем с другим названием в той же области видимости

            if (current.getId().equals(customer.getId())) {
                current = customer;
            }
        }
    }

    public boolean existByPassportNumber(String passportnumber) {
        for (Customer customer : customerList) {
            if (customer.getPassportNumber().equals(passportnumber)) {
                return true;
            }
        }
        return false;
    }

    public boolean existByPhone(String phone) {
        for (Customer customer : customerList) {
            String phoneString = Integer.toString(customer.getPhone());
            if (phoneString.equals(phone)) {
                return true;
            }
        }
        return false;
    }

    //метод для генерации id
    private String generateId () {
        String id = UUID.randomUUID().toString();
        //перед тем, как создать пользователя с айдишником, проверим, нет ли уже таких айди в бд, и если есть, перегенерируем айди
        for (Customer customer : customerList) {
            if (customer.getId().equals(id)) {
                return generateId();
            }
        }
        return id;
    }

   }
