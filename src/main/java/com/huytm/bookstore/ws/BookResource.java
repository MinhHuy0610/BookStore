/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huytm.bookstore.ws;


import com.huytm.bookstore.dao.BookDAO;
import com.huytm.bookstore.dto.Book;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.*;
import javax.ws.rs.PathParam;

/**
 *
 * @author acer
 */

//soqf được đến class này mình phải đi qua ủl sau
//contextpath/api/dương dãn đến tài nbguyên, đến l=clas này
//            api/books
@Path("/books")
public class BookResource {
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getHelloMessage(){
        return "Hey, this is the first message come from my own 1st API";
    }
    @GET
    @Path("/get-a-book")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getABook(){
        ArrayList<Book> list= new ArrayList<>();
        list.add(new Book("123", "Đời ngắn lắm đừng ngủ dài", "Japa", 1, 2019));
        list.add(new Book("124", "Tony buổi sáng", "Tony", 13, 2021));
        list.add(new Book("111", "Đắc Nhân Tâm", "US", 50, 1950));
        
        return list;
    }
    @GET
    @Path("{isbn}")
    @Produces(MediaType.APPLICATION_JSON)
    public Book getABookByIsbn(@PathParam("isbn") String isbn){
        BookDAO dao = BookDAO.getDAO();
        return dao.getABook(isbn);
    }
}
