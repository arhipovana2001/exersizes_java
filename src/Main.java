import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException, AccountAlreadyExistsException, AccountBlockedException, WrongCredentialsException {
        FileAccountManager f = new FileAccountManager();

        Account a1 = new Account("Комаров", "Артем", "Александрович", "09.01.2003", "artem@mail.ru", "pass");
        try {
            f.register(a1);

        }catch (AccountAlreadyExistsException e){
            System.out.println(e.getMessage());

        }

        try {
            f.login("artem@mail.ru", "pass0077");
        }catch (WrongCredentialsException e){
            System.out.println(e.getMessage());
        }

    }

}


