public class Constants {
    public static final String ADD_STORE = "ДОБАВИТЬ_МАГАЗИН";
    public static final String ADD_PRODUCT = "ДОБАВИТЬ_ТОВАР";
    public static final String PRODUCT_ON_SALE = "ВЫСТАВИТЬ_ТОВАР";
    public static final String PRODUCT_STATISTICS = "СТАТИСТИКА_ТОВАРОВ";
    public static final String ENTER_COMMAND = "Введите команду!";
    public static final String NAME = "Название магазина:";
    public static final String AMOUNT_OF_PRODUCTS = "Общее количество наименований товаров:";
    public static final String AVERAGE_PRICE_OF_PRODUCTS = "Средняя цена товаров:";
    public static final String MAX_PRICE_OF_PRODUCTS = "Самый дорогой товар:";
    public static final String MIN_PRICE_OF_PRODUCTS = "Самый самый дешевый товар:";
    public static final String ID = "_id";
    public static final String CHEAPER_THAN_100 = "Количество товаров дешевле 100 рублей:";
    public static final String $COND_$LT = "{ \"$cond\": [ { \"$lt\": [ \"$product list.price\", 100 ] }, 1, 0 ] }";
}