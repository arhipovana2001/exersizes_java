import java.util.ArrayList;
import java.util.List;

public class PhoneBook {
    private ArrayList<Record> records = new ArrayList<>();

    public List<Record> getAllRecords(){
        return records;
    }

    public void createRecord(Record record) throws PhoneNumberAlreadyExists {
        //метод сохраняет в справочнике новую запись. Если в справочнике есть запись с
        //таким же номером телефона, выбросить проверяемое исключение PhoneNumberAlreadyExists.
        int toUpdate = -1;

        for(int i = 0; i< records.size(); i++) {
            if (records.get(i).phoneNumber == record.phoneNumber){
                // найдено значение с таким же номером телефона
                toUpdate = i;
            }
        }

        if (toUpdate == -1){
            records.add(record);
        }else {
            throw new PhoneNumberAlreadyExists("в справочнике есть запись с таким же номером телефона");
        }

    }

    public void updateRecord(Record record) throws RecordNotValid{
    /*  метод обновляет запись в справочнике. Если запись с таким идентификатором
        не существует, выбросить непроверяемое исключение RecordNotFound.
        Если в новой записи не заполнено поле name и/или
        поле phoneNumber, выбросить проверяемое исключение RecordNotValid
        */
        int toUpdate = -1;

        for(int i = 0; i< records.size(); i++) {
            //System.out.println(records.get(i).phoneNumber);
            if (records.get(i).id == record.id){
                toUpdate = i;
            }

        }
        if (toUpdate == -1){
            throw new RecordNotFound("Запись не найдена");
        } else {
            // обновить запис
            if ((record.phoneNumber == null || record.phoneNumber.length()==0) &&
                    (record.name == null || record.name.length()==0)){
                throw new RecordNotValid("не заполнено поле name и/или поле phoneNumber");
            }else {
                records.set(toUpdate, record);
            }
            }
        }


    public void deleteRecord(long id){
        //удаляет запись из справочника по идентификатору, если подходящая запись в
        // справочнике не найдена - выбрасывается непроверяемое исключение RecordNotFound.
        int toDelete = -1;

        for(int i = 0; i< records.size(); i++) {
            //System.out.println(records.get(i).phoneNumber);
            if (records.get(i).id == id){
                toDelete = i;
            }

        }
        if (toDelete == -1){
            throw new RecordNotFound("Запись не найдена");
        } else {
            records.remove(toDelete);
        }


    }

    public void getInfo(){
        for (Record rec : records){
            System.out.println(rec.id);
        }
    }
}
