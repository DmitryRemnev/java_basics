import exceptions.IncorrectMailException;
import exceptions.IncorrectPhoneException;
import exceptions.WrongWordCountException;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerStorage {
    private static final String REGEX_MAIL = "^(.+)@(.+)$";
    private static final String REGEX_PHONE = "^(\\+7)\\d{10}$";
    private final Map<String, Customer> storage;

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) throws WrongWordCountException, IncorrectMailException, IncorrectPhoneException {
        final int INDEX_NAME = 0;
        final int INDEX_SURNAME = 1;
        final int INDEX_EMAIL = 2;
        final int INDEX_PHONE = 3;

        String[] components = data.split("\\s+");
        if (components.length != 4) {
            throw new WrongWordCountException();
        }
        if (!isCorrectMail(components[INDEX_EMAIL])) {
            throw new IncorrectMailException();
        }
        if (!isCorrectPhone(components[INDEX_PHONE])) {
            throw new IncorrectPhoneException();
        }

        String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];
        storage.put(name, new Customer(name, components[INDEX_PHONE], components[INDEX_EMAIL]));
    }

    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        storage.remove(name);
    }

    public Customer getCustomer(String name) {
        return storage.get(name);
    }

    public int getCount() {
        return storage.size();
    }

    private boolean isCorrectMail(String mail) {
        Pattern pattern = Pattern.compile(REGEX_MAIL);
        Matcher matcher = pattern.matcher(mail);

        return matcher.find();
    }

    private boolean isCorrectPhone(String phone) {
        Pattern pattern = Pattern.compile(REGEX_PHONE);
        Matcher matcher = pattern.matcher(phone);

        return matcher.find();
    }
}