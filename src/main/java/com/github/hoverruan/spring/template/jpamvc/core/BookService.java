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
    }

    @Transactional(readOnly = true)
    public List<Book> findNewestBooks() {
        return entityManager.createQuery("select o from Book o order by o.id desc", Book.class)
                .setMaxResults(10)
                .getResultList();
    }
}
