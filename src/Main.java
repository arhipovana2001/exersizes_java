import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException, AccountAlreadyExistsException, AccountBlockedException, WrongCredentialsException {

        Account a = new Account("Артемов", "Егор",
                "Сергеевич", "09.01.2002", "egor@mail.ru", "pass00");
        FileAccountManager f = new FileAccountManager();
        f.register(a);
        try {
            f.register(a);
        } catch (AccountAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }
        try {
            f.login("egor@mail.ru", "pass0077");
        } catch (WrongCredentialsException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("-----------------");

        f.login("egor@mail.ru", "pass00");


        f.removeAccount("egor@mail.ru", "pass00");


    }

}


