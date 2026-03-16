package com.library.main;

import com.library.model.Book;
import com.library.model.Library;
import com.library.model.Member;
import com.library.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        // Testa conexão com banco
        System.out.println("=== TESTANDO CONEXÃO ===");
        try (Connection conn = DatabaseConnection.getConnection()) {
            if (conn != null) {
                System.out.println("✅ Conexão com PostgreSQL estabelecida!");
            }
        } catch (SQLException e) {
            System.out.println("❌ Erro ao conectar: " + e.getMessage());
        }
        System.out.println();

        // ADICIONA ISSO AQUI:
        System.out.println("=== TESTANDO SAVE BOOK ===");
        Library library = new Library("Biblioteca Central");

        Book testBook = new Book("Test Driven Development", "Kent Beck", "978-0321146533");

        try {
            library.saveBook(testBook);
        } catch (SQLException e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        }
        System.out.println();

    }
}
