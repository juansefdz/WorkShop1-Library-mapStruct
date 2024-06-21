package com.example.librosYa.util.mappers;

import com.example.librosYa.api.dto.DtoBook;
import com.example.librosYa.domain.entities.BookEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-21T12:16:01-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 18.0.2 (Amazon.com Inc.)"
)
@Component
public class BookMapperImpl implements BookMapper {

    @Autowired
    private LoanMapper loanMapper;

    @Override
    public DtoBook toGetDTO(BookEntity book) {
        if ( book == null ) {
            return null;
        }

        DtoBook.DtoBookBuilder dtoBook = DtoBook.builder();

        dtoBook.idBook( book.getIdBook() );
        dtoBook.titleBook( book.getTitleBook() );
        dtoBook.publicationYear( book.getPublicationYear() );
        dtoBook.genre( book.getGenre() );
        dtoBook.isbn( book.getIsbn() );
        dtoBook.loans( loanMapper.toGetLoanList( book.getLoans() ) );

        return dtoBook.build();
    }

    @Override
    public BookEntity toEntity(DtoBook getBook) {
        if ( getBook == null ) {
            return null;
        }

        BookEntity.BookEntityBuilder bookEntity = BookEntity.builder();

        bookEntity.idBook( getBook.getIdBook() );
        bookEntity.titleBook( getBook.getTitleBook() );
        bookEntity.author( getBook.getAuthor() );
        bookEntity.publicationYear( getBook.getPublicationYear() );
        bookEntity.genre( getBook.getGenre() );
        bookEntity.isbn( getBook.getIsbn() );
        bookEntity.loans( loanMapper.toEntityLoanList( getBook.getLoans() ) );

        return bookEntity.build();
    }

    @Override
    public List<DtoBook> toGetBookList(List<BookEntity> bookEntityList) {
        if ( bookEntityList == null ) {
            return null;
        }

        List<DtoBook> list = new ArrayList<DtoBook>( bookEntityList.size() );
        for ( BookEntity bookEntity : bookEntityList ) {
            list.add( toGetDTO( bookEntity ) );
        }

        return list;
    }

    @Override
    public List<BookEntity> toEntityList(List<DtoBook> bookRequestList) {
        if ( bookRequestList == null ) {
            return null;
        }

        List<BookEntity> list = new ArrayList<BookEntity>( bookRequestList.size() );
        for ( DtoBook dtoBook : bookRequestList ) {
            list.add( toEntity( dtoBook ) );
        }

        return list;
    }
}
