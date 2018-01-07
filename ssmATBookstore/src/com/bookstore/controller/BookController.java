package com.bookstore.controller;


import com.bookstore.common.Page;
import com.bookstore.entity.Book;
import com.bookstore.entity.CriteriaBook;
import com.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;
    /*
    * 按价格区间分页查询，传给页面Page<Book>对象
    * */
    @RequestMapping(value = "/book/list1.html")
    public String getBooks1(Model model, Integer pageNo,
                            Integer  minPrice,
                            Integer maxPrice){
        System.out.println(pageNo);
        System.out.println(""+"进来了");
        if(pageNo==null||pageNo.equals("")){
            pageNo=1;
        }
        System.out.println(pageNo);
        if(maxPrice==null||maxPrice.equals("")){maxPrice=Integer.MAX_VALUE;}
        if(minPrice==null||minPrice.equals("")){minPrice=0;}
        CriteriaBook criteriaBook=new CriteriaBook(minPrice,maxPrice,(pageNo-1)*3);//第三个参数实际上是limit的第一个数，分页查询的起始位置
        Page<Book> bookPage=bookService.getPriceBook(criteriaBook,pageNo);
       model.addAttribute("bookpage",bookPage);

        return "books";
    }
    /*
    *测试查询所有图书
    * */
  @RequestMapping("/book/list.html")
  public String getBooks(){
      List<Book> books = bookService.getAllBook();

      for (Book book:books
              ) {
          System.out.print(book.getTitle());
          System.out.println(book.getRemark());
      }

      return "insertOK";
  }
}
