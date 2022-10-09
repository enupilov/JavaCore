package lesson5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;

/**
 * Функциональные интерфейсы для корвертеров массивов
 */
@FunctionalInterface
interface ConverterToInt {
    int[] convert(String[] array);
}

@FunctionalInterface
interface ConverterToStr {
    String[] convert(int[] array);
}

/**
 * Класс данных
 */
public class AppData {
    private String[] headers;
    private int[][] data;
    final String SEPARATOR = ";";

    public AppData(int size, String headerLine, int[][] data) {
        this.headers = headerLine.split(",");
        this.data = data;
    }

    public AppData(String dump) {
        // конструктор объекта на основе CSV дампа,
        String[] csvData = dump.split("\n");
        this.headers = new String[csvData[0].split(SEPARATOR).length];
        this.data = new int[csvData.length - 1][this.headers.length];
        this.setCSVDump(dump);
    }

    public void setCSVDump(String dump) {   // распарсим и загрузим данные из дампа формата CSV

        // анонимный конвертер строкового массива в целочисленный
        ConverterToInt converter = (array) -> {
            int[] res = new int[(array.length)];
            for (int j = 0; j < array.length; j++) {
                res[j]=Integer.valueOf(array[j]);
            }
            return res;
        };

        try {
            String[] csvData = dump.split("\n");
            this.headers = csvData[0].split(";");
            for (int i = 1; i < csvData.length; i++) {
                this.data[i-1]=converter.convert(csvData[i].split(SEPARATOR));
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public String getCSVDump(){     // вернем дамп из объекта в виде строки формата CSV

        // анонимный конвертер числового массива в стоковый
        ConverterToStr converter = (array) -> {
            String[] res = new String[array.length];
            for (int j = 0; j < array.length; j++) {
                res[j]=Integer.toString(array[j]);
            }
            return res;
        };

        String[] dumpArr = new String[(this.data.length+1)];
        dumpArr[0] = String.join(SEPARATOR, this.headers);
        for (int i = 0; i < this.data.length; i++) {
            dumpArr[i+1] = String.join(SEPARATOR, converter.convert(this.data[i]));
        }
        String res = "";
        for (String s : dumpArr) {
            res+=s+'\n';
        }
        return res;
    }
}


