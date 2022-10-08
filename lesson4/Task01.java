package lesson4;

import java.util.*;

public class Task01 {
    public static void main(String[] args){
        List<String> words = Arrays.asList(
                "Mathematics", "Languages", "Technology", "History", "Geography",
                "Biology", "Music", "Art", "Social Sciences", "Life Orientation",
                "Physical Sciences", "Design", "Languages", "Art", "Geography",
                "Chemistry", "Music", "Languages", "Art", "History"
        );

        Set<String> unique = new HashSet<String>(words);

        System.out.println("Начальный массив");
        System.out.println(words.toString());
        System.out.println("Уникальные слова");
        System.out.println(unique.toString());
        System.out.println("Частота повторяющихся слов");
        for (String key : unique) {
            System.out.println(key + ": " + Collections.frequency(words, key));
        }
    }
}
