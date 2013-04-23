package com.github.hoverruan.spring.template.jpamvc.core;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Transactional
public class BookService {
    @PersistenceContext
    private EntityManager entityManager;

    public void persist(Book book) {
        entityManager.persist(book);
        entityManager.flush();
    }

    @Transactional(readOnly = true)
    public List<Book> findBooks() {
        return entityManager.createQuery("select o from Book o", Book.class).getResultList();
    }
}
