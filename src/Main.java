public class Main {
    public static void main(String[] args) throws RecordNotValid, PhoneNumberAlreadyExists {
        Record r1 = new Record("9876", "nastya");
        Record r2 = new Record("9876", "anya");
        Record r3 = new Record();
        Record r4 = new Record();
        PhoneBook book = new PhoneBook();

        System.out.println("-------------------");
        book.createRecord(r1);
        try {
            book.createRecord(r2);
        }catch (PhoneNumberAlreadyExists e){
            System.out.println(e.getMessage());
        }
        book.getInfo();
        System.out.println("-------------------");
        book.createRecord(r3);
        try {
            book.updateRecord(r3);
        }catch (RecordNotValid e){
            System.out.println(e.getMessage());
        }
        //book.updateRecord(r4);
        System.out.println("-------------------");
        book.deleteRecord(4);
        System.out.println("-------------------");

    }
}

