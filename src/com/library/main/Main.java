package com.library.main;

import com.library.model.Book;
import com.library.model.Library;
import com.library.model.Member;

public class Main {
    public static void main(String[] args) {
        // Cria biblioteca
        Library library = new Library("Biblioteca Central");

        // Cria livros
        Book book1 = new Book("Clean Code", "Robert Martin", "978-0132350884");
        Book book2 = new Book("Effective Java", "Joshua Bloch", "978-0134685991");
        Book book3 = new Book("Java: The Complete Reference", "Herbert Schildt", "978-1260440232");

        // Cria membros
        Member member1 = new Member(1, "Alice", "alice@email.com");
        Member member2 = new Member(2, "Bob", "bob@email.com");

        // Adiciona à biblioteca
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        library.addMember(member1);
        library.addMember(member2);

        // Testa busca
        System.out.println("\n=== BUSCAR LIVRO ===");
        Book found = library.findBookByTitle("clean code");
        if (found != null) {
            System.out.println("Encontrado: " + found);
        } else {
            System.out.println("Livro não encontrado");
        }

        // Testa remover
        System.out.println("\n=== REMOVER LIVRO ===");
        boolean removed = library.removeBook(2);
        if (removed) {
            System.out.println("Livro ID 2 removido!");
        } else {
            System.out.println("Livro não encontrado");
        }

        // Lista de novo para confirmar remoção
        System.out.println("\n=== BOOKS APÓS REMOÇÃO ===");
        library.listBooks();


        // Lista tudo
        System.out.println("\n=== BOOKS ===");
        library.listBooks();

        System.out.println("\n=== MEMBERS ===");
        library.listMembers();

    }
}
