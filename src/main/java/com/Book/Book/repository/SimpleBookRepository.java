package com.Book.Book.repository;

import com.Book.Book.model.Book;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component // Spring tarafından otomatik olarak tanınır.
public class SimpleBookRepository implements BookRepository {

    @Override
    @Cacheable("books") // Bu metodun çıktısı, "books" adlı cache'e yazılır. Aynı parametreyle çağrıldığında cache'ten gelir.
    public Book getByIsbn(String isbn) {
        simulateSlowService(); // Yavaş işlem simülasyonu (3 saniye bekletir)
        return new Book(isbn, "Some book"); // Yeni Book nesnesi oluşturur
    }

    // Bu metot, pahalı/uzun süren bir servisi taklit eder (gerçek veritabanı çağrısı gibi).
    private void simulateSlowService() {
        try {
            long time = 3000L;
            Thread.sleep(time); // 3 saniye beklet
        } catch (InterruptedException e) {
            throw new IllegalStateException(e); // Hata varsa exception fırlat
        }
    }

}

