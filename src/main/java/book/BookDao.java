package book;

import book.model.Book;
import jpa.GenericJpaDao;
import user.model.User;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.util.Optional;

public class BookDao extends GenericJpaDao<Book> {

    @Transactional
    Optional<Book> findByIsbn13(String isbn13){
        try {
            return Optional.of(entityManager.createQuery("SELECT u FROM Book u WHERE u.isbn13 = :isbn", Book.class)
                    .setParameter("isbn", isbn13)
                    .getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }
}
