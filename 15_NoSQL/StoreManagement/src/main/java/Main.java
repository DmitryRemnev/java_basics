import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        StoreManager manager = new StoreManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String text = scanner.nextLine();

            if (text.equals("")) {
                break;
            }

            if (text.contains(Constants.ADD_STORE)) {
                manager.addStore(text.replace(Constants.ADD_STORE, "").trim());

            } else if (text.contains(Constants.ADD_PRODUCT)) {

                text = text.replace(Constants.ADD_PRODUCT, "").trim();
                String price = Utils.getPrice(text);
                String name = text.replace(price, "").trim();

                manager.addProduct(name, Integer.parseInt(price));

            } else if (text.contains(Constants.PRODUCT_ON_SALE)) {

                text = text.replace(Constants.PRODUCT_ON_SALE, "").trim();
                String name = Utils.getName(text.trim());

                manager.productOnSale(name, text.replace(name, "").trim());

            } else if (text.contains(Constants.PRODUCT_STATISTICS)) {
                manager.getStatistics();

            } else {
                System.out.println(Constants.ENTER_COMMAND);
            }
        }
    }
}