package homeWork.controller;

import homeWork.DataAccessObject.CustomerDao;
import homeWork.DataAccessObject.CustomerDaoImplementation;
import homeWork.customer.Customer;
import homeWork.service.CustomerService;
import homeWork.service.CustomerServiceImplementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

//класс для меню для пользователя
public class CustomerController {

    private final CustomerService service = new CustomerServiceImplementation();

    public void run() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please select an option");
        menu();
        String option = reader.readLine();
        while ((option = reader.readLine()) != null) {
            switchToOperation(option, reader);
            menu();
        }
    }
//создадим меню нашего приложения
    private void menu () {

        System.out.println();
        System.out.println("To create please enter 1");
        System.out.println("To update please enter 2");
        System.out.println("To delete please enter 3");
        System.out.println("To select customer please enter 4");
        System.out.println("To display all customers please enter 5");
        System.out.println("To exit please enter 0");
        System.out.println();
    }
    private void switchToOperation (String option, BufferedReader reader) throws IOException {
        switch (option) {
            case "1" -> create(reader);
            case "2" -> update(reader);
            case "3" -> delete(reader);
            case "4" -> findById(reader);
            case "5" -> findAll();
            case "0" -> System.exit(0);
            default -> System.out.println("Incorrect input? please try again");
        }
    }

    private void create(BufferedReader reader) throws IOException {
        System.out.println("Create operation");
        System.out.println("Please enter name");
        String name = reader.readLine();
        System.out.println("Please enter passport number");
        String passportNumber = reader.readLine();
        System.out.println("Please enter phone number");
        String phoneString = reader.readLine();
        int phone = Integer.parseInt(phoneString);
        System.out.println("Please enter age");
        String ageString = reader.readLine();
        int age = Integer.parseInt(ageString);
        Customer customer = new Customer();
        customer.setName(name);
        customer.setPassportNumber(passportNumber);
        customer.setPhone(phone);
        customer.setAge(age);
        service.create(customer);
    }
    private void update(BufferedReader reader) throws IOException {
        System.out.println("Update customer operation");
        System.out.println("Please enter id");
        String id = reader.readLine();
        Customer customer = service.findById(id);
        System.out.println("Please enter name");
        String name = reader.readLine();
        System.out.println("Please enter passport number");
        String passportNumber = reader.readLine();
        System.out.println("Please enter phone number in format of 10 digits");
        String phoneString = reader.readLine();
        int phone = Integer.parseInt(phoneString);
        System.out.println("Please enter age");
        String ageString = reader.readLine();
        int age = Integer.parseInt(ageString);
        customer.setName(name);
        customer.setPassportNumber(passportNumber);
        customer.setPhone(phone);
        customer.setAge(age);
        service.update(customer);
    }
    private void delete(BufferedReader reader) throws IOException {
        System.out.println("Delete operation");
        System.out.println("Please enter id");
        String id = reader.readLine();
        service.delete(id);
        System.out.println("Customer deleted");
    }
    private void findById(BufferedReader reader) throws IOException {
        System.out.println("Find by id operation");
        System.out.println("Please enter id");
        String id = reader.readLine();
        Customer customer = service.findById(id);
        System.out.println("customer = " + customer);
    }
    private void findAll() {
        System.out.println("FindAll operation");
        List<Customer> customerList = service.findAll();
        for (Customer customer : customerList) {
            System.out.println("customer = " + customer);
        }
    }
}
