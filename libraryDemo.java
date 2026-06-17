package com.library.librarysystem;

public class libraryDemo {
    public static void main(String[] args) {
        
        // create the library
        Library library = new Library();
        
        // create books
        Book book1 = new Book("978-1", "BEATUY AND THE BEAST", "J.K Rowling");
        Book book2 = new Book("978-2", "The Lion King", "Unknown Author");
        Book book3 = new Book("978-3", "CINDERLLA");
        
        // add books to library
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        
        // create members
        Member member1 = new Member("M001", "Kaira");
        Member member2 = new Member("M002", "David");
        
        // register members
        library.registerMember(member1);
        library.registerMember(member2);
        
        // print library state before
        System.out.println("\n--- LIBRARY STATE BEFORE ---");
        System.out.println(library);
        
        // lend some books
        System.out.println("\n--- LENDING BOOKS ---");
        library.lendBook("M001", "978-1");
        library.lendBook("M002", "978-2");
        
        // try to lend a book already on loan (should be rejected)
        System.out.println("\n--- TRYING TO LEND ALREADY LOANED BOOK ---");
        library.lendBook("M002", "978-1");
        
        // return a book
        System.out.println("\n--- RETURNING A BOOK ---");
        library.returnBook("M001", "978-1");
        
        // print library state after
        System.out.println("\n--- LIBRARY STATE AFTER ---");
        System.out.println(library);
        
        // search for a book
        System.out.println("\n--- SEARCHING FOR 'Java' ---");
        library.searchByTitle("Java");
    }
}
