package homeWork.service;

import homeWork.DataAccessObject.CustomerDao;
import homeWork.DataAccessObject.CustomerDaoImplementation;
import homeWork.customer.Customer;

import java.util.List;

public class CustomerServiceImplementation implements CustomerService {

    private final CustomerDao customerDao = new CustomerDaoImplementation();

    @Override
    public void create(Customer customer) {
        if (!customerDao.existByPassportNumber(customer.getPassportNumber())) {
            customerDao.create(customer);
        }
        else {
            System.out.println("This passport number already exists");
        }
    }

    @Override
    public void update(Customer customer) {
        customerDao.update(customer);
    }

    @Override
    public void delete(String id) {
        customerDao.delete(id);
    }

    @Override
    public Customer findById(String id) {
        return customerDao.findById(id);
    }

    @Override
    public List<Customer> findAll() {
        return customerDao.findAll();
    }

    @Override
    public boolean existByPassportNumber(String passportnumber) {
        return false;
    }
}
