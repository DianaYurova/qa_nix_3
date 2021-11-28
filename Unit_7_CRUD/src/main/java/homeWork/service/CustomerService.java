package homeWork.service;

import homeWork.customer.Customer;

import java.util.List;

public interface CustomerService {

    void create(Customer customer);
    void update(Customer customer);
    void delete(String id);
    Customer findById(String id);
    List<Customer> findAll();
    boolean existByPassportNumber(String passportnumber);

}
