package com.example.librosYa.application.mappers.Book;

import com.example.librosYa.application.dto.request.BookRequest;
import com.example.librosYa.application.dto.response.BookResponse;
import com.example.librosYa.domain.entities.BookEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-08T18:33:38-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.39.0.v20240620-1855, environment: Java 17.0.11 (Eclipse Adoptium)"
)
@Component
public class BookMapperImpl implements BookMapper {

    @Override
    public BookEntity toEntity(BookRequest bookRequest) {
        if ( bookRequest == null ) {
            return null;
        }

        BookEntity.BookEntityBuilder bookEntity = BookEntity.builder();

        bookEntity.author( bookRequest.getAuthor() );
        bookEntity.genre( bookRequest.getGenre() );
        bookEntity.idBook( bookRequest.getIdBook() );
        bookEntity.isbn( bookRequest.getIsbn() );
        bookEntity.publicationYear( bookRequest.getPublicationYear() );
        bookEntity.titleBook( bookRequest.getTitleBook() );

        return bookEntity.build();
    }

    @Override
    public BookResponse toResponse(BookEntity book) {
        if ( book == null ) {
            return null;
        }

        BookResponse.BookResponseBuilder bookResponse = BookResponse.builder();

        bookResponse.genre( book.getGenre() );
        bookResponse.idBook( book.getIdBook() );
        bookResponse.isbn( book.getIsbn() );
        bookResponse.publicationYear( book.getPublicationYear() );
        bookResponse.titleBook( book.getTitleBook() );

        return bookResponse.build();
    }

    @Override
    public List<BookResponse> toGetBookList(List<BookEntity> bookList) {
        if ( bookList == null ) {
            return null;
        }

        List<BookResponse> list = new ArrayList<BookResponse>( bookList.size() );
        for ( BookEntity bookEntity : bookList ) {
            list.add( toResponse( bookEntity ) );
        }

        return list;
    }

    @Override
    public List<BookEntity> toEntityList(List<BookRequest> bookRequestList) {
        if ( bookRequestList == null ) {
            return null;
        }

        List<BookEntity> list = new ArrayList<BookEntity>( bookRequestList.size() );
        for ( BookRequest bookRequest : bookRequestList ) {
            list.add( toEntity( bookRequest ) );
        }

        return list;
    }

    @Override
    public void updateEntityFromDto(BookRequest dto, BookEntity entity) {
        if ( dto == null ) {
            return;
        }

        entity.setAuthor( dto.getAuthor() );
        entity.setGenre( dto.getGenre() );
        entity.setIdBook( dto.getIdBook() );
        entity.setIsbn( dto.getIsbn() );
        entity.setPublicationYear( dto.getPublicationYear() );
        entity.setTitleBook( dto.getTitleBook() );
    }
}
