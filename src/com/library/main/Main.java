package com.library.main;

import com.library.model.Book;
import com.library.model.Library;
import com.library.model.Member;
import com.library.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== LIBRARY SYSTEM - JDBC TEST ===\n");

        Library library = new Library("Biblioteca Central");

        try {
            // 1. Carrega livros do banco
            System.out.println("📚 Carregando livros do banco...");
            library.loadBooks();

            // 2. Lista livros carregados
            System.out.println("\n=== LIVROS NO BANCO ===");
            library.listBooks();

            // 3. Adiciona novo livro
            System.out.println("\n📖 Adicionando novo livro...");
            Book newBook = new Book("Effective Java", "Joshua Bloch", "978-0134685991");
            library.saveBook(newBook);

            // 4. Recarrega e mostra todos
            System.out.println("\n📚 Recarregando livros...");
            library.loadBooks();

            System.out.println("\n=== TODOS OS LIVROS ===");
            library.listBooks();

            // 5. Busca livro específico
            System.out.println("\n🔍 Buscando livro ID 1...");
            Book found = library.findBookById(1);
            if (found != null) {
                System.out.println("Encontrado: " + found);
            } else {
                System.out.println("Livro não encontrado!");
            }

// 6. Tenta buscar ID inexistente
            System.out.println("\n🔍 Buscando livro ID 999...");
            Book notFound = library.findBookById(999);
            if (notFound != null) {
                System.out.println("Encontrado: " + notFound);
            } else {
                System.out.println("❌ Livro não encontrado!");
            }


        } catch (SQLException e) {
            System.out.println("❌ Erro: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
