package com.library.librarysystem;

import java.time.LocalDate;

public class Loan {
    private Member member;
    private Book book;
    private LocalDate borrowDate;
    private LocalDate dueDate;
    
    public Loan(Member member, Book book, LocalDate borrowDate, LocalDate dueDate){
     this.member = member;
     this.book = book;
     this.borrowDate = borrowDate;
     this.dueDate = dueDate;
    }
    public Member getMember(){
        return member;
    }
    public Book getBook(){
        return book;
    }
    public LocalDate getBorrowDate(){
        return dueDate;
    }
    @Override
    public String toString(){
        return"[Loan[Member=" + member.getName() + ", Book=" + book.getTitle() + ", BorrowDate=" + borrowDate + ", DueDate=" + dueDate + "]";
    }
}
