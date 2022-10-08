package lesson4.Task02;

public class Task02 {
    public static void main(String[] args){
        System.out.println("Создание справочника.");
        Phonebook phonebook = new Phonebook();
        System.out.println();

        System.out.println("Наполнение справочника:");
        phonebook.add("Кузнецов", "283319");
        phonebook.add("Попов", "284655");
        phonebook.add("Попов", "284455");
        phonebook.add("Васильев", "284850");
        phonebook.add("Соколов", "285600");
        phonebook.add("Смирнов", "285433");
        System.out.println();

        System.out.println("Запрос номеров:");
        System.out.println("Кузнецов");
        System.out.println(phonebook.get("Кузнецов"));
        System.out.println("Соколов");
        System.out.println(phonebook.get("Соколов"));
        System.out.println("Смирнов");
        System.out.println(phonebook.get("Смирнов"));
        System.out.println();

        System.out.println("Случай отсутствия записи:");
        System.out.println("Петров");
        System.out.println(phonebook.get("Петров"));
        System.out.println();

        System.out.println("Попытка записать существующий номер:");
        phonebook.add("Попов", "284455");
        System.out.println("Попов");
        System.out.println(phonebook.get("Попов"));
    }
}
