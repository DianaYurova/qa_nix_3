package homeWork;

import homeWork.controller.CustomerController;

import java.io.IOException;

public class CrudAppMain {

    public static void main(String[] args) throws IOException {

        CustomerController controller = new CustomerController();
        controller.run();
    }
}
