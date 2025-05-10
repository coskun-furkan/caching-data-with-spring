# caching-data-with-spring

Bu küçük Spring Boot projesi, uygulamalarda önbelleklemenin (caching) nasıl çalıştığını anlamak için yaptığım basit bir denemedir.  
Amaç, yavaş çalışan bir veri alma işlemini taklit edip, Spring’in cache sistemiyle bunu nasıl hızlandırabileceğimizi göstermektir.

---

# Özellikler

- Java 17+ ve Spring Boot ile yazıldı  
- `@EnableCaching` ve `@Cacheable` anotasyonları kullanıldı  
- İlk veri çekiminde 3 saniyelik gecikme simüle ediliyor  
- Aynı veri tekrar istendiğinde direkt bellekteki önbellekten geliyor  
- Konsol çıktısı üzerinden test ediliyor (`CommandLineRunner`)

---

# Kullanılan Teknolojiler

- Java  
- Spring Boot  
- Spring Framework Cache  
- Maven  
- SLF4J (loglama için)

---

# Klasör Yapısı

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

# Nasıl Çalışıyor?

Uygulama başladığında bazı kitaplar `AppRunner` üzerinden çağrılıyor.  
İlk çağrıda, sistem 3 saniye bekliyor — yani yavaş bir servis davranışı taklit ediliyor.  
Aynı ISBN ile yapılan sonraki çağrılarda veri cache'ten alındığı için anında geri dönüyor.

---

# Örnek Çıktı

```
.... Fetching books
isbn-1234 --> Book(isbn=isbn-1234, title=Some book)
isbn-4567 --> Book(isbn=isbn-4567, title=Some book)
isbn-1234 --> Book(isbn=isbn-1234, title=Some book)  # cache'ten geldi
isbn-4567 --> Book(isbn=isbn-4567, title=Some book)  # cache'ten geldi
```

---

# Notlar

- Bu proje web tabanlı değil, sadece komut satırında çalışan örnek bir uygulamadır.  
- Geliştirmek istersen:
  - REST API endpoint’leri ekleyebilirsin  
  - `@CacheEvict` ve `@CachePut` gibi anotasyonları deneyebilirsin  
  - Redis gibi harici cache sistemleriyle çalışmayı test edebilirsin

---

## 👨‍💻 Hakkımda

Ben Furkan, Java ve Spring Boot üzerine çalışan bir backend geliştiricisiyim.  
Kod yazarak öğreniyorum, bazen bozarak da tabii :)  
Bu repo da öğrendiklerimi pekiştirmek için yaptığım küçük bir çalışma.  
Profilime göz atmak istersen: [coskun-furkan](https://github.com/coskun-furkan)

---

Eğer proje hoşuna gittiyse bir yıldız bırakabilirsin ⭐ :)
