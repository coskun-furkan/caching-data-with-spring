# caching-data-with-spring

This is a small Java Spring Boot project where I explore how caching works in a backend application.  
The idea is to simulate a slow data fetch process and then improve it using Spring's caching mechanism.

---

# Features

- Built with Java 23 and Spring Boot
- Uses `@EnableCaching` and `@Cacheable`
- Simulates a 3-second delay on first-time data calls
- Instant response on repeated calls thanks to caching
- Simple console output via `CommandLineRunner`

---

# Tech Stack

- Java
- Spring Boot
- Spring Caching
- Maven
- SLF4J (for logging)

---

# Folder structure

src  
├── main  
│   ├── java  
│   │   └── com.Book.Book  
│   │       ├── BookApplication.java  
│   │       ├── cache  
│   │       │   └── AppRunner.java  
│   │       ├── model  
│   │       │   └── Book.java  
│   │       └── repository  
│   │           ├── BookRepository.java  
│   │           └── SimpleBookRepository.java  
│   └── resources  
│       └── application.properties  



---

# How it works

The AppRunner class runs a few method calls when the app starts.
The first time you fetch a book by its ISBN, it waits for 3 seconds to simulate a slow service.
Next time you call it with the same ISBN, the response comes back instantly — from memory, thanks to caching.

---

# Sample output

.... Fetching books
isbn-1234 --> Book(isbn=isbn-1234, title=Some book)
isbn-4567 --> Book(isbn=isbn-4567, title=Some book)
isbn-1234 --> Book(isbn=isbn-1234, title=Some book)  # cached
isbn-4567 --> Book(isbn=isbn-4567, title=Some book)  # cached

---

# Notes
This is a console-based example, not a web app.

If you want to expand it, you can add a REST controller and expose endpoints.

You can also try Redis for external caching or add @CacheEvict.

---

👨‍💻 About me
Hey, I'm Furkan, a backend developer exploring Spring Boot and Java.
I'm learning by building and breaking things — this repo is part of that journey.
You can check out more of my work here.

