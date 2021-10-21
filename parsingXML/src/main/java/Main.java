import parsing.DOMxmlReader;
import parsing.Valute;

import java.util.*;

public class Main {

    public static void main(String[] args){
        while (true){
            Scanner scan = new Scanner(System.in);
            String filepath = "C:\\Users\\Redmi\\IdeaProjects\\exersizes1\\src\\parsing\\file.xml";
            System.out.println("Введите дату в формате dd/mm/yyyy: ");
            System.out.println("Для выхода из программы введите \"exit\"");
            String date = scan.nextLine();

            System.out.println("Введите ISO-код валюты: ");
            System.out.println("Для выхода из программы введите \"exit\"");
            String valCode = scan.nextLine().toUpperCase(Locale.ROOT);
            if (isValidDate(date) && isValidValute(valCode)){
                System.out.println("ok");
                DOMxmlReader reader = new DOMxmlReader();
                List<Valute> valutes = reader.readFile(filepath);
                for (Valute valute : valutes){
                    if (valute.getCharCode().equals(valCode)){
                        System.out.println(valute);
                    };
                }





            }else if(date.toLowerCase(Locale.ROOT).equals("exit") || valCode.toLowerCase(Locale.ROOT).equals("exit")){
                break;
            }else if(!isValidDate(date)){
                System.out.println("ВВЕДЕН НЕКОРРЕКТНЫЙ ФОРМАТ ДАТЫ");
                System.out.println("Дату необходимо ввести в формате dd/mm/yyyy");
                System.out.println("Например: 12/01/2020");
            }else if(!isValidValute(valCode)){
                System.out.println("ВВЕДЕН НЕКОРРЕКТНЫЙ ФОРМАТ ISO-КОДА ВАЛЮТЫ");
            }



        }
    }

    public static boolean isValidDate (String inputValue) {
        Calendar cal = new GregorianCalendar();
        cal.setLenient (false);
        cal.clear ();
        // Разобрать строку на три составляющие (день, месяц, год)
        try {
            int d = Integer.parseInt (inputValue.substring (0, 2));
            int m = Integer.parseInt (inputValue.substring (3, 5));
            int y = Integer.parseInt (inputValue.substring (6, 10));
            if (y > 2021){
                return false;
            }
            cal.set (y, m - 1, d);
            java.util.Date dt = cal.getTime ();
            return true;
        }
        catch (NumberFormatException nfe) {return false;}
        catch (IllegalArgumentException iae) {return false;}
        catch (StringIndexOutOfBoundsException sie) {return false;}
    }

    public static boolean isValidValute(String valute){
        Boolean result = true;

        valute = valute.toUpperCase(Locale.ROOT);

        return result;
    }
}




