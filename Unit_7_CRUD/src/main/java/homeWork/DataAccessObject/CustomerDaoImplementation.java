package homeWork.DataAccessObject;

import homeWork.customer.Customer;
import homeWork.dataBase.DataBaseInMemory;

import java.util.List;

public class CustomerDaoImplementation implements CustomerDao {

    //плохой вариант, тк мы не должны мочь создавать новый экземпляр класса, чтобы быть уверенными, что при создании
    //нового класса, мы не создадим несколько экземпляров, а будем обращаться к одному и тому же
    //поэтому нам нужно, чтобы dbInMemory предоставила нам интерфейс для общения с ней всех даошек в проекте
    //также она должна запретить делать себе new - для этого нужно сделать ей свой приватный конструктор
    // private DataBaseInMemory dataBaseInMemory = new DataBaseInMemory();

    //ввиду того, что new теперь создать может только сама DataBaseInMemory, мы обращаемся к методу getInstance,
    // который возвращает нам экземпляр класса для работы с ним:
    private final DataBaseInMemory dataBaseInMemory = DataBaseInMemory.getInstance();


    @Override
    public void create(Customer customer) {
        dataBaseInMemory.insert(customer);
    }

    @Override
    public void update(Customer customer) {
        dataBaseInMemory.update(customer);
    }

    @Override
    public void delete(String id) {
        dataBaseInMemory.delete(id);
    }

    @Override
    public Customer findById(String id) {
        return dataBaseInMemory.selectById(id);
    }

    @Override
    public List<Customer> findAll() {
        return dataBaseInMemory.selectAll();
    }

    @Override
    public boolean existByPassportNumber(String passportnumber) { return dataBaseInMemory.existByPassportNumber(passportnumber);  }

    @Override
    public boolean existByPhone(String phone) { return dataBaseInMemory.existByPhone(phone);  }
}
