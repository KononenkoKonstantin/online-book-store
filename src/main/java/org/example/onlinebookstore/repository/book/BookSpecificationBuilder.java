package org.example.onlinebookstore.repository.book;

import lombok.RequiredArgsConstructor;
import org.example.onlinebookstore.dto.BookSearchParameters;
import org.example.onlinebookstore.model.Book;
import org.example.onlinebookstore.repository.SpecificationBuilder;
import org.example.onlinebookstore.repository.SpecificationProviderManager;
import org.example.onlinebookstore.repository.book.spec.BookSpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class BookSpecificationBuilder implements SpecificationBuilder<Book> {
    private final SpecificationProviderManager<Book> bookSpecificationProviderManager;

    @Override
    public Specification<Book> build(BookSearchParameters searchParameters) {
        Specification<Book> spec = Specification.where(null);
        if (searchParameters.titles() != null && searchParameters.titles().length > 0) {
            spec = spec.and(bookSpecificationProviderManager.getSpecificationProvider(
                    BookSpecification.TITLE.getValue())
                    .getSpecification(searchParameters.titles()));
        }
        if (searchParameters.authors() != null && searchParameters.authors().length > 0) {
            spec = spec.and(bookSpecificationProviderManager.getSpecificationProvider(
                    BookSpecification.AUTHOR.getValue())
                    .getSpecification(searchParameters.authors()));
        }
        return spec;
    }
}
