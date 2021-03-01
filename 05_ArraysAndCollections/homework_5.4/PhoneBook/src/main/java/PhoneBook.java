import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneBook {
    TreeMap<String, String> map = new TreeMap<>();

    private String name;
    private String phone;

    public void addContact(String phone, String name) {
        if (UtilsCorrect.isNameCorrect(name) && UtilsCorrect.isPhoneCorrect(phone)) {

            if (map.containsValue(phone)) {
                map.replace(phone, name);
            } else {
                map.put(phone, name);
            }

            this.name = null;
            this.phone = null;
            System.out.println("Контакт сохранен!");
        }
    }

    public String getNameByPhone(String phone) {
        String name = "";

        for (String key : map.keySet()) {
            if (phone.equals(key)) {
                name = map.get(key);
            }
        }
        this.phone = null;

        return name + " - " + phone;
    }

    public Set<String> getPhonesByName(String name) {
        TreeSet<String> setPhones = new TreeSet<>();

        for (String key : map.keySet()) {
            if (map.get(key).equals(name)) {
                setPhones.add(name + " - " + key);
            }
        }
        this.name = null;

        return setPhones;
    }

    public Set<String> getAllContacts() {
        TreeSet<String> set = new TreeSet<>();

        for (String key : map.keySet()) {
            set.add(map.get(key) + " - " + key);
        }

        return set;
    }

    void inputCheck(String input) {

        if (UtilsCorrect.isNameCorrect(input)) {
            name = input;

            if (map.containsValue(name)) {
                for (String item : getPhonesByName(name)) {
                    System.out.println(item);
                }

            } else {
                if (phone == null) {
                    System.out.println("Такого имени в телефонной книге нет.");
                    System.out.println("Введите номер телефона для абонента " + "\"" + name + "\":");

                } else {
                    addContact(phone, name);
                }
            }

        } else if (UtilsCorrect.isPhoneCorrect(input)) {
            phone = input;

            if (map.containsKey(phone)) {

                if (name == null) {
                    System.out.println(getNameByPhone(phone));

                } else {
                    addContact(phone, name);
                }

            } else {
                if (name == null) {
                    System.out.println("Такого номера нет в телефонной книге.");
                    System.out.println("Введите имя абонента для номера " + "\"" + phone + "\":");

                } else {
                    addContact(phone, name);
                }
            }

        } else {
            System.out.println("Неверный формат ввода");
        }
    }

    public void printList() {
        for (String item : getAllContacts()) {
            System.out.println(item);
        }
    }
}