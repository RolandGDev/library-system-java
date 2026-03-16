package com.library.model;

import com.library.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private String name;
    private List<Book> books;
    private List<Member> members;

    public Library(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Library name cannot be null or blank");
        }
        this.name = name;
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    // TODO: Adicionar métodos aqui
    public void addBook(Book book) {
        if(book == null){
            throw new IllegalArgumentException("Book cannot be null");
        }
        this.books.add(book);
        System.out.println("Book added");
    }
    public void addMember(Member member) {
        if(member == null){
            throw new IllegalArgumentException("Member cannot be null");
        }
        this.members.add(member);
        System.out.println("Member added");
    }

    public void listBooks(){
        for (Book book : books) {
            System.out.println(book);
        }
    }
    public void listMembers(){
        for (Member member : members) {
            System.out.println(member);
        }
    }
    public Book findBookByTitle(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title cannot be null or blank");
        }

        // TODO: Percorrer lista de books
        // TODO: Comparar title (ignora maiúsculas/minúsculas)
        // TODO: Se encontrar, retorna o book
        // TODO: Se não encontrar, retorna null
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }

        return null; // Temporário
    }
    public boolean removeBook(int id) {
        // TODO: Percorrer lista de books
        // TODO: Comparar id
        // TODO: Se encontrar, remove e retorna true
        // TODO: Se não encontrar, retorna false
       for(Book book : books){
           if(book.getId() == id){
               books.remove(book);
               return true;
           }
       }

        return false; // Temporário
    }

    public void saveBook(Book book) throws SQLException {
        String sql = "INSERT INTO books(title, author, isbn, available) VALUES (?, ?, ?, ?)";
        // TODO: Criar Connection (usar DatabaseConnection.getConnection())
        // TODO: Criar PreparedStatement com o SQL
        // TODO: Setar os valores (?, ?, ?, ?)
        // TODO: Executar executeUpdate()
        // TODO: Imprimir confirmação
       try(Connection conn = DatabaseConnection.getConnection();
           PreparedStatement pstmt = conn.prepareStatement(sql)){
           pstmt.setString(1, book.getTitle());
           pstmt.setString(2, book.getAuthor());
           pstmt.setString(3, book.getIsbn());
           pstmt.setBoolean(4, book.isAvailable());
           int rowsAffected = pstmt.executeUpdate();
           System.out.println("Book saved! Rows Affected: " + rowsAffected);
       }catch (SQLException e){
           System.out.println("Error no insert" + e.getMessage());
           throw e;// realanca a excecao pra quem chamou saber
       }
    }

}
