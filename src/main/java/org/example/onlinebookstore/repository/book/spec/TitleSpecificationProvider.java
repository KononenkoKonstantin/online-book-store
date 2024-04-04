package org.example.onlinebookstore.repository.book.spec;

import java.util.Arrays;
import org.example.onlinebookstore.model.Book;
import org.example.onlinebookstore.repository.SpecificationProvider;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class TitleSpecificationProvider implements SpecificationProvider<Book> {

    @Override
    public String getKey() {
        return BookSpecification.TITLE.getValue();
    }

    public Specification<Book> getSpecification(String[] params) {
        return (root, query, criteriaBuilder) ->
                root.get(BookSpecification.TITLE.getValue()).in(Arrays.stream(params).toArray());
    }
}
