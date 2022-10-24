package ru.netology.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


public class TestProducts {
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);

    Book book1 = new Book(1, "book", 245, "DIY", "Tom Smith");
    Book book2 = new Book(2, "book", 1400, "War and Peace", "Tolstoy L.N.");
    Book book3 = new Book(3, "magazine", 350, "Auto&moto", "John Collins");

    Smartphone phone1 = new Smartphone(4, "cellphone", 10_000, "Nokia 3310", "Nokia");
    Smartphone phone2 = new Smartphone(5, "smartphone", 120_000, "Iphone 14 Pro Max", "Apple");
    Smartphone phone3 = new Smartphone(6, "smartphone", 99_000, "Pixel 7", "Google");


    @Test
    public void shouldSaveAndFindAll() {

        repository.save(book1);
        repository.save(book2);
        repository.save(book3);

        repository.save(phone1);
        repository.save(phone2);
        repository.save(phone3);

        repository.findAll();

        Product[] actual = repository.findAll();
        Product[] expected = {book1, book2, book3, phone1, phone2, phone3};

        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchById() {

        repository.save(book1);
        repository.save(book2);
        repository.save(book3);

        repository.removeById(2);

        Product[] actual = repository.findAll();
        Product[] expected = {book1, book3};

        assertArrayEquals(expected, actual);


    }


    @Test
    public void shouldSearchByTextIfConsist() {

        repository.save(book1);
        repository.save(book2);
        repository.save(book3);


        repository.save(phone2);
        repository.save(phone3);

        manager.searchBy("magazine");

        Product[] actual = manager.searchBy("magazine");
        Product[] expected = {book3};

        assertArrayEquals(expected, actual);


    }

    @Test
    public void souldSearchByTextIfAllMatche() {

        repository.save(book1);
        repository.save(book2);

        manager.searchBy("book");

        Product[] actual = manager.searchBy("book");
        Product[] expected = {book1, book2};

        assertArrayEquals(expected, actual);


    }


    @Test
    public void shouldNotSearchByTextIfEmpty() {

        repository.save(book1);
        repository.save(book2);
        repository.save(book3);

        repository.save(phone1);
        repository.save(phone2);
        repository.save(phone3);

        manager.searchBy("Samsung");

        Product[] actual = manager.searchBy("Samsung");
        Product[] expected = {};

        assertArrayEquals(expected, actual);


    }

    @Test
    public void shouldMatchesTrue() {

        repository.save(book1);
        repository.save(book2);
        repository.save(book3);

        repository.save(phone1);
        repository.save(phone2);
        repository.save(phone3);

        manager.matches(phone3, "smartphone");

        boolean actual = manager.matches(phone3, "smartphone");
        boolean expected = true;

        assertEquals(expected, actual);


    }

    @Test
    public void shouldMatchesFalse() {

        repository.save(book1);
        repository.save(book2);
        repository.save(book3);

        repository.save(phone1);
        repository.save(phone2);
        repository.save(phone3);

        manager.matches(phone3, "Samsung");

        boolean actual = manager.matches(phone3, "Samsung");
        boolean expected = false;

        assertEquals(expected, actual);


    }


}















