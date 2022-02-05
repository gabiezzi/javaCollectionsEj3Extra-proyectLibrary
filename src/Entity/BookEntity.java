/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Objects;

/**
 *
 * @author Anita
 */
public class BookEntity {
    
    private String bookName;
    
    private String bookAutor;
    
    private Integer bookQuantity;
    
    private Integer bookAvailable;

    public BookEntity(String bookName, String bookAutor, Integer bookQuantity, Integer bookAvailable) {
        this.bookName = bookName;
        this.bookAutor = bookAutor;
        this.bookQuantity = bookQuantity;
        this.bookAvailable = bookAvailable;
    }

    public BookEntity() {
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAutor() {
        return bookAutor;
    }

    public void setBookAutor(String bookAutor) {
        this.bookAutor = bookAutor;
    }

    public Integer getBookQuantity() {
        return bookQuantity;
    }

    public void setBookQuantity(Integer bookQuantity) {
        this.bookQuantity = bookQuantity;
    }

    public Integer getBookAvailable() {
        return bookAvailable;
    }

    public void setBookAvailable(Integer bookAvailable) {
        this.bookAvailable = bookAvailable;
    }

    @Override
    public String toString() {
        return "BookEntity{" + "bookName=" + bookName + ", bookAutor=" + bookAutor + ", bookQuantity=" + bookQuantity + ", bookAvailable=" + bookAvailable + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.bookName);
        hash = 37 * hash + Objects.hashCode(this.bookAutor);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BookEntity other = (BookEntity) obj;
        if (!Objects.equals(this.bookName, other.bookName)) {
            return false;
        }
        if (!Objects.equals(this.bookAutor, other.bookAutor)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
