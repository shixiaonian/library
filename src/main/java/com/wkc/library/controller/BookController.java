package com.wkc.library.controller;

import com.wkc.library.entity.Book;
import com.wkc.library.mapper.BookMapper;
import com.wkc.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author xiaoniao
 * @date 2023/2/28 15:16
 */
@Controller
@ResponseBody
@RequestMapping("book")
public class BookController {

    @Autowired
    BookMapper bookMapper;

    @Autowired
    BookService bookService;

    @GetMapping("/get")
    public Book getBookByName(HttpServletRequest request){
        String name = request.getParameter("name");
        Book book = bookMapper.getByName(name);
        return book;
    }

    @GetMapping("/all")
    public List<Book> getAllBook(){
        List<Book> list = bookService.list();
        return list;
    }
}
