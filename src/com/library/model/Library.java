package com.library.model;

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

}
