package p02_BookShop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.reflect.Method;
import java.util.Locale;

public class Main {
    public static void main(String[] args) throws IOException, IllegalClassFormatException {
        try {
            Locale.setDefault(Locale.ROOT);
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String author = reader.readLine();
            String title = reader.readLine();
            Double price = Double.valueOf(reader.readLine());

            Book book = new Book(title, author, price);
            GoldenEditionBook goldenEditionBook = new GoldenEditionBook(title, author, price);

            Method[] bookDeclaredMethods = Book.class.getDeclaredMethods();
            Method[] goldenBookDeclaredMethods = GoldenEditionBook.class.getDeclaredMethods();
            if (goldenBookDeclaredMethods.length > 1) {
                throw new IllegalClassFormatException("Code duplication in GoldenEditionBook!");
            }
            System.out.println(book.toString());
            System.out.println(goldenEditionBook.toString());
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
        }
    }
}
