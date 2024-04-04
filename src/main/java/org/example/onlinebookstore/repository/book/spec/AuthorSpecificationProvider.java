package org.example.onlinebookstore.repository.book.spec;

import java.util.Arrays;
import org.example.onlinebookstore.model.Book;
import org.example.onlinebookstore.repository.SpecificationProvider;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class AuthorSpecificationProvider implements SpecificationProvider<Book> {
    @Override
    public String getKey() {
        return BookSpecification.AUTHOR.getValue();
    }

    public Specification<Book> getSpecification(String[] params) {
        return (root, query, criteriaBuilder) ->
                root.get(BookSpecification.AUTHOR.getValue()).in(Arrays.stream(params).toArray());
    }
}
