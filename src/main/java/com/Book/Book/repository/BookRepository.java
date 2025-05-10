package com.Book.Book.repository;

import com.Book.Book.model.Book;

public interface BookRepository {

    // Belirli bir ISBN'e göre kitap bilgisini döndürür.
    Book getByIsbn(String isbn);
}
