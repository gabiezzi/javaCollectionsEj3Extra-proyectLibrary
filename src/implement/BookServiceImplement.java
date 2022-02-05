/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implement;

import Entity.BookEntity;
import java.util.HashSet;
import java.util.Scanner;
import service.BookService;

/**
 *
 * @author Anita
 */
public class BookServiceImplement implements BookService {

    HashSet<BookEntity> books;

    Scanner read;

    public BookServiceImplement() {
        this.books = new HashSet<>();
        this.read = new Scanner(System.in).useDelimiter("\n");
    }

    @Override
    public BookEntity startNewBook() {
        BookEntity newBook = new BookEntity();

        System.out.println(constants.BookConstants.SERVICE_CREATEBOOK_MESSAGE + "Name");
        newBook.setBookName(read.next());

        System.out.println(constants.BookConstants.SERVICE_CREATEBOOK_MESSAGE + "Autor");
        newBook.setBookAutor(read.next());

        System.out.println(constants.BookConstants.SERVICE_CREATEBOOK_MESSAGE + "Quantity of books");
        newBook.setBookQuantity(read.nextInt());

        System.out.println(constants.BookConstants.SERVICE_CREATEBOOK_MESSAGE + "quantity available of books");
        newBook.setBookAvailable(read.nextInt());

        return newBook;
    }

    @Override
    public String addNewBookToTheSet(BookEntity newBook) {

        books.add(newBook);

        return newBook.toString() + "added to the bookSet";
    }

    @Override
    public Boolean lendBook(String bookToBorrow) {

        for (BookEntity unitaryBook : books) {

            if (unitaryBook.getBookName().equals(bookToBorrow)) {

                System.out.println("How many books you want to take ?");
                int numberOfBooks = read.nextInt();
                if (unitaryBook.getBookAvailable() == 0) {
                    System.out.println("This book is not available.");
                    return false;
                } else {

                    while (numberOfBooks > unitaryBook.getBookAvailable()) {

                        System.out.println("There are not enough books available.");
                        System.out.println("Insert another quantity!");
                        numberOfBooks = read.nextInt();
                    }
                }
                return true;
            }

        }

        return false;
    }

    
    @Override
    public Boolean returnBook(String bookToReturn) {

        for (BookEntity unitaryBook : books) {

            if (unitaryBook.getBookName().equals(bookToReturn)) {

                System.out.println("How many books are you returning ?");

                int returnedBooks = read.nextInt();
                
                if (unitaryBook.getBookQuantity() < (unitaryBook.getBookAvailable() + returnedBooks)) {

                    System.out.println("This book is not for this library!");
                    return false;
                } else {

                    System.out.println("You have returned " + returnedBooks + "books");
                    unitaryBook.setBookAvailable(unitaryBook.getBookAvailable() + returnedBooks);
                    return true;
                }

            }
        }

        return false;
    }
    
    @Override
    public void menu(){
       int option;

        do {

            System.out.println(constants.BookConstants.MENU_MESSAGE);

            option = read.nextInt();

            switch (option) {
                case 1:

                    addNewBookToTheSet(startNewBook());

                    break;
                
                case 2:
                    System.out.println("Insert the book to take:");
                    String bookToBorrow = read.next();
                    if (!lendBook(bookToBorrow)) {
                        System.out.println("Book is not available or doesnt exist in our library.");
                    }
                    break;
                case 3:
                    System.out.println("Insert the book to return:");
                    String bookToReturn = read.next();
                    if (!lendBook(bookToReturn)) {
                        System.out.println("Book doesnt exist in our library.");
                    }
                    break;
                case 4:
                    
                    System.out.println(showBooksSet());
                    
                    break;
                case 5:

                    String optExit;

                    System.out.println("Do you want to exit ?");

                    optExit = read.next();

                    if (optExit.equalsIgnoreCase("y")) {
                        System.out.println("The program has finished.");
                    } else {

                        option = 0;
                    }
                    break;
                default:
                    throw new AssertionError();
            }

        } while (option != 5);

    }
    
    @Override
    public String showBooksSet(){
        
        String bookSet = "Book set of the library : \n";
        
        for (BookEntity unitaryBook : books) {
            
            bookSet += unitaryBook + "\n";
            
        }
        
        return bookSet;
    }
    
}
