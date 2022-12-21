/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huytm.bookstore.dao;

import com.huytm.bookstore.dto.Book;
import com.huytm.bookstore.util.DBUtil;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author acer
 */
public class BookDAO implements Serializable{
    
    private static BookDAO dao;
    private BookDAO(){
        
    }
    public static BookDAO getDAO(){
        if(dao == null)
            dao = new BookDAO();
        
        return dao;
    }
    //Singleton pattern
    
    
    private Connection conn= DBUtil.makeConnection();
    //tao cau noi toi CSDL
    
    public Book getABook(String isbn){
        PreparedStatement stm; //chuan bi cau query
        ResultSet rs;// don cac dong tra ve
        
        try {
            String sql="select * From Book where isbn = ? ";
            stm= conn.prepareStatement(sql);
            //tao se gui may mot cau lenh sql
            //dien vao ngay sau day
            stm.setString(1, isbn);
            rs = stm.executeQuery();
            if(rs.next()){
                return new Book(rs.getString("Isbn"),
                                rs.getString("Title"),
                                rs.getString("Author"),
                                rs.getInt("Edition"),
                                rs.getInt("PublishedYear"));
            }
        } catch (Exception e) {
            
        }
        return null;//neu tim thay sach thi da return o tren roi
    }
    public static void main(String[] args) {
        BookDAO dao = new BookDAO();
        Book x= dao.getABook("2518407786529");
        System.out.println("Get a boook from real DB(not memory): ");
        System.out.println(x);
    }
}
