package com.Book.Book.cache;

import com.Book.Book.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component // Spring tarafından yönetilen bir bean olarak tanımlanır (otomatik yüklenir).
public class AppRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(AppRunner.class); // Logger nesnesi (log mesajları için)

    private final BookRepository bookRepository; // Kitap bilgilerini sağlayan repository (cache kullanılan sınıf)

    // Constructor ile bağımlılık enjeksiyonu yapılır (BookRepository verilir).
    public AppRunner(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Uygulama başladığında aşağıdaki kodlar sırayla çalışır.
        logger.info(".... Fetching books");

        // Aynı ISBN'lerle tekrar tekrar çağrılar yapılır.
        // İlk çağrı cache'e alır, sonraki çağrılar cache'ten hızlıca döner.
        logger.info("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"));
        logger.info("isbn-4567 -->" + bookRepository.getByIsbn("isbn-4567"));
        logger.info("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"));
        logger.info("isbn-4567 -->" + bookRepository.getByIsbn("isbn-4567"));
        logger.info("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"));
        logger.info("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"));
    }

}
