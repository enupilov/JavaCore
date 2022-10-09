package lesson5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * Главный класс программы
 */
public class CSVFile {
    final static String FILE = "file.csv";      // путь к файлу обмена
    final static String FILE1 = "file1.csv";      // путь к файлу для сравнения

    public static void saveToCSVFile(AppData data){
        // поскольку CSV формат текстовый, то и работать с ним имеет смысл текстовыми средствами
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE))) {
            writer.write(data.getCSVDump());
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static AppData loadFromCSVFile(String file){
        // загрузим данные в строку и воспользуемся конструктором на основе CSV дампа.
        String dump = "";
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while ((line=reader.readLine())!=null){
                dump+=line+'\n';
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        AppData data = new AppData(dump);
        return data;
    }

    public static void main(String[] args) {
        // создадим объект данных и сохраним его в файл
        int[][] array = {{100,200,123},{300,400,500},{600,700,234}};
        AppData data1 = new AppData(2,"Value 1,Value 2,Value 3",array);
        saveToCSVFile(data1);

        //Прочтем его из файла в другой объект, попутно создав его специальным конструктором
        AppData data2 = loadFromCSVFile(FILE);
        AppData data3 = loadFromCSVFile(FILE1);

        /* сравним имеющиеся объекты:
        для проверки равенства объктов сравним строковые выражения в формате CSV
         */
        if (data1.getCSVDump().equals(data2.getCSVDump())) {
            System.out.println("Данные в выгруженном и загруженном объектах идентичны.");
        } else {
            System.out.println("Данные в выгруженном и загруженном объектах различны.");
        }
        // сравним неравные объекты
        if (data1.getCSVDump().equals(data3.getCSVDump())) {
            System.out.println("Данные в выгруженном и загруженном объектах идентичны.");
        } else {
            System.out.println("Данные в выгруженном и загруженном объектах различны.");
        }
    }
}
/*
Вывод программы :
    Данные в выгруженном и загруженном объектах идентичны
    Данные в выгруженном и загруженном объектах различны
*/
