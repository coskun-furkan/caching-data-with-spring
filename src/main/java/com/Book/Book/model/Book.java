package com.Book.Book.model;

import lombok.AllArgsConstructor; // Tüm alanlara sahip constructor oluşturur.
import lombok.Data;               // Getter, Setter, toString, equals ve hashCode otomatik eklenir.

@AllArgsConstructor // isbn ve title alanlarını alan constructor oluşturulur.
@Data               // Kitap nesnesinin özelliklerini kapsayan temel sınıftır.
public class Book {

    private String isbn;   // Kitabın benzersiz ISBN numarası
    private String title;  // Kitabın başlığı

}
