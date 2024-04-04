package org.example.onlinebookstore.repository.book.spec;

public enum BookSpecification {
    TITLE("title"),
    AUTHOR("author");

    private final String value;

    BookSpecification(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
