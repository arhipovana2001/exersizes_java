import java.io.File;

public class FileWriter {

    public void writeFile()
    File file = new File("Example.txt");

    // Создание файла
      file.createNewFile();

    // Создание объекта FileWriter
    FileWriter writer = new FileWriter(file);

    // Запись содержимого в файл
      writer.write("Это простой пример,\n в котором мы осуществляем\n с помощью языка Java\n запись в файл\n и чтение из файла\n");
      writer.flush();
      writer.close();
}
