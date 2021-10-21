import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws UnirestException, IOException {
        while (true) {
            Scanner scan = new Scanner(System.in);
            String filepath = "C:\\Users\\Redmi\\IdeaProjects\\exersizes1\\parsingXML\\src\\main\\java\\valutes.xml";
            System.out.println("Введите дату в формате dd/mm/yyyy: ");
            System.out.println("Для выхода из программы введите \"exit\"");
            String date = scan.nextLine();
            if (isValidDate(date)) {
                String response = Unirest.get("https://www.cbr.ru/scripts/XML_daily.asp?date_req={date}").routeParam("date", date).asString().getBody();
                response = response.replace("windows-1251", "utf-8");

                Writer writer = new Writer();
                writer.fileWrite(filepath, response);

                DOMxmlReader reader = new DOMxmlReader();
                List<Valute> valutes = reader.readFile(filepath);

                System.out.println("Введите ISO-код валюты: ");
                System.out.println("Для выхода из программы введите \"exit\"");
                String charCode = scan.nextLine().toUpperCase(Locale.ROOT);

                if (isValidCharCode(charCode)) {
                    Valute.findValute(valutes, charCode);
                } else if (charCode.toLowerCase(Locale.ROOT).equals("exit")) {
                    break;
                } else if (!isValidCharCode(charCode)) {
                    System.out.println("ВВЕДЕН НЕКОРРЕКТНЫЙ ISO-КОД ВАЛЮТЫ");
                }

            } else if (date.toLowerCase(Locale.ROOT).equals("exit")) {
                break;
            } else if (!isValidDate(date)) {
                System.out.println("ВВЕДЕН НЕКОРРЕКТНЫЙ ФОРМАТ ДАТЫ");
                System.out.println("Дату необходимо ввести в формате dd/mm/yyyy");
                System.out.println("Например: 12/01/2020");
            }


        }
    }

        public static boolean isValidDate (String inputValue){
            Calendar cal = new GregorianCalendar();
            cal.setLenient(false);
            cal.clear();
            try {
                int d = Integer.parseInt(inputValue.substring(0, 2));
                int m = Integer.parseInt(inputValue.substring(3, 5));
                int y = Integer.parseInt(inputValue.substring(6, 10));
                if (y > 2021) {
                    return false;
                }
                cal.set(y, m - 1, d);
                Date dt = cal.getTime();
                return true;
            } catch (NumberFormatException nfe) {
                return false;
            } catch (IllegalArgumentException iae) {
                return false;
            } catch (StringIndexOutOfBoundsException sie) {
                return false;
            }
        }

        public static Boolean isValidCharCode (String charCode){

            return Valute.getCharCodes().contains(charCode);
        }


    }




