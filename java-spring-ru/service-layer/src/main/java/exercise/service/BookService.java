package exercise.service;

import exercise.dto.AuthorCreateDTO;
import exercise.dto.AuthorDTO;
import exercise.dto.AuthorUpdateDTO;
import exercise.dto.BookCreateDTO;
import exercise.dto.BookDTO;
import exercise.dto.BookUpdateDTO;
import exercise.exception.ResourceNotFoundException;
import exercise.mapper.AuthorMapper;
import exercise.mapper.BookMapper;
import exercise.repository.AuthorRepository;
import exercise.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class BookService {
    // BEGIN
    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private  BookRepository bookRepository;

    @Autowired
    private BookMapper bookMapper;


    public List<BookDTO> getAll() {
        var books = bookRepository.findAll();
        var res = books.stream()
                .map(bookMapper::map)
                .toList();
        return res;
    }

    public BookDTO create(BookCreateDTO dto) {
        authorRepository.findById(dto.getAuthorId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
        var book = bookMapper.map(dto);
        bookRepository.save(book);
        var bookDTO = bookMapper.map(book);
        return bookDTO;
    }

    public BookDTO findById(Long id) {
        var book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not Found: " + id));
        var bookDTO = bookMapper.map(book);
        return bookDTO;
    }

    public BookDTO update(BookUpdateDTO dto, Long id) {
        authorRepository.findById(dto.getAuthorId().get()).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
        var book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not Found: " + id));
        bookMapper.update(dto, book);
        bookRepository.save(book);
        var bookDTO = bookMapper.map(book);
        return bookDTO;
    }

    public void delete(Long id) {
        bookRepository.deleteById(id);
    }
    // END
}
