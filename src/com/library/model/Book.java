package com.library.model;

public class Book {
    private static  int uid = 0;
    private int id;
    private String title;
    private String author;
    private String isbn;
    private boolean available;

    // Construtor completo
    public Book(String title, String author, String isbn, boolean available) {
        // TODO: Adicionar validações aqui
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title cannot be null or empty");
        }
        if (author == null || author.isBlank()) {
            throw new IllegalArgumentException("Author cannot be null or empty");
        }
        if (isbn == null || isbn.isBlank()) {
            throw new IllegalArgumentException("ISBN cannot be null or empty");
        }
        uid++;
        this.id = uid;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.available = available;
    }

    // Construtor simplificado (livro disponível por padrão)
    public Book( String title, String author, String isbn) {
        this(title, author, isbn, true);
    }


    // Getters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isAvailable() {
        return available;
    }

    // Método para emprestar/devolver
    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", available=" + available +
                '}';
    }
}
