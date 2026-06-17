package com.library.librarysystem;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class Library {
    private List<Book> books;
    private List<Member> members;

    public Library() {
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.getTitle());
    }

    public void registerMember(Member member) {
        members.add(member);
        System.out.println("Member registered: " + member.getName());
    }

    public void lendBook(String memberId, String isbn) {
        Book book = null;
        for (Book b : books) {
            if (b.getIsbn().equals(isbn)) {
                book = b;
                break;
            }
        }

        Member member = null;
        for (Member m : members) {
            if (m.getMemberId().equals(memberId)) {
                member = m;
                break;
            }
        }

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        if (member == null) {
            System.out.println("Member not found.");
            return;
        }

        if (!book.isAvailable()) {
            System.out.println("Sorry, " + book.getTitle() + " is already on loan.");
            return;
        }

        LocalDate borrowDate = LocalDate.now();
        LocalDate dueDate = borrowDate.plusDays(14);
        Loan loan = new Loan(member, book, borrowDate, dueDate);

        member.addLoan(loan);
        book.setAvailable(false);
        System.out.println("Success! " + member.getName() +
                           " borrowed " + book.getTitle() +
                           ". Due: " + dueDate);
    }

    public void returnBook(String memberId, String isbn) {
        Member member = null;
        for (Member m : members) {
            if (m.getMemberId().equals(memberId)) {
                member = m;
                break;
            }
        }

        Book book = null;
        for (Book b : books) {
            if (b.getIsbn().equals(isbn)) {
                book = b;
                break;
            }
        }

        if (member == null) {
            System.out.println("Member not found.");
            return;
        }

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        Loan loanToRemove = null;
        for (Loan loan : member.getLoans()) {
            if (loan.getBook().getIsbn().equals(isbn)) {
                loanToRemove = loan;
                break;
            }
        }

        if (loanToRemove == null) {
            System.out.println("No active loan found for this book.");
            return;
        }

        member.removeLoan(loanToRemove);
        book.setAvailable(true);
        System.out.println("Success! " + member.getName() +
                           " returned " + book.getTitle());
    }

    public void searchByTitle(String title) {
        for (Book b : books) {
            if (b.getTitle().toLowerCase().contains(title.toLowerCase())) {
                System.out.println(b);
            }
        }
    }

    @Override
    public String toString() {
        return "Library[Books=" + books.size() +
               ", Members=" + members.size() + "]";
    }
}