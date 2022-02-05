/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Entity.BookEntity;

/**
 *
 * @author Anita
 */
public interface BookService {
    
    public BookEntity startNewBook();
    public String addNewBookToTheSet(BookEntity newBook);
    public void menu();
    public Boolean lendBook(String bookToBorrow);
    public Boolean returnBook(String bookToReturn);
    public String showBooksSet();


}
