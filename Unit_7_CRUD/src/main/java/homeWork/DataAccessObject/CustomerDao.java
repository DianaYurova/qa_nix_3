package homeWork.DataAccessObject;

import homeWork.customer.Customer;

import java.util.List;

public interface CustomerDao {

    void create(Customer customer);
    void update(Customer customer);
    void delete(String id);
    Customer findById(String id);
    List<Customer> findAll();
    boolean existByPassportNumber(String passportnumber);
    boolean existByPhone(String phone);
    //хотела сделать и поле phone уникальным, но запуталась видимо в обратном приведении, тк в бд кладу phone Integer :(

}
