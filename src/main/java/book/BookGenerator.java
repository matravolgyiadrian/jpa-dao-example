package book;

import book.model.Book;
import com.github.javafaker.Faker;

import java.time.ZoneId;
import java.util.Locale;

public class BookGenerator {

    private Faker faker = new Faker(new Locale("hu"));

    Book getRandomBook(){
        Book book = Book.builder()
                .author(faker.book().author())
                .title(faker.book().title())
                .isbn13(faker.code().isbn13())
                .available(faker.bool().bool())
                .format(faker.options().option(Book.Format.class))
                .pages(faker.number().numberBetween(1,5000))
                .publicationDate(faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate())
                .publisher(faker.book().publisher())
                .build();

        return book;
    }
}
