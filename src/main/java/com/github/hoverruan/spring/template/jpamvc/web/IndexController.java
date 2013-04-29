package com.github.hoverruan.spring.template.jpamvc.web;

import com.github.hoverruan.spring.template.jpamvc.core.Book;
import com.github.hoverruan.spring.template.jpamvc.core.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
    private BookService bookService;

    @Autowired
    public IndexController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index(@RequestParam String name) {
        Book book = new Book(name);
        bookService.persist(book);

        return new ModelAndView("index")
                .addObject(book)
                .addObject(bookService.findBooks());
    }
}
