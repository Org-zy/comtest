package com.bookstore.service;

import com.bookstore.common.Page;
import com.bookstore.dao.BookMapper;
import com.bookstore.entity.Book;
import com.bookstore.entity.BookExample;
import com.bookstore.entity.CriteriaBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookMapper bookMapper;
    /**
     * 查询所有图书
    */

    public List<Book> getAllBook(){
        BookExample bookExample=new BookExample();
        List<Book> books = bookMapper.selectByExampleWithBLOBs(bookExample);
        return books;
    }
    /**
     * 根据条件查询所以图书
     * 图书价格
     */
    public Page<Book> getPriceBook(CriteriaBook criteriaBook,int pageNo){
        //根据图书价格区间查询所有图书总记录数
        BookExample bookExample=new BookExample();
        BookExample.Criteria criteria = bookExample.createCriteria().
                andPriceGreaterThanOrEqualTo(criteriaBook.getMinPrice()).
                andPriceLessThanOrEqualTo(criteriaBook.getMaxPrice());
        int i = bookMapper.countByExample(bookExample);
        //System.out.println(i);
        //根据图书价格区间查询和pageNo分页查询图书
        List<Book> books = bookMapper.getMyBookPage(criteriaBook);
        Page<Book> bookPage=new Page<>(pageNo);
        bookPage.setTotalItemNumber(i);
        bookPage.setList(books);
        return bookPage;
    }

}
