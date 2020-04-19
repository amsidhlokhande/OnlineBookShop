package com.amsidh.mvc;

import com.amsidh.mvc.entity.Book;
import com.amsidh.mvc.entity.BookCategory;
import com.amsidh.mvc.repository.BookCategoryRepository;
import com.amsidh.mvc.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
@Slf4j
public class OnlineBookShopApplication implements CommandLineRunner {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookCategoryRepository bookCategoryRepository;

    public static void main(String[] args) {
        SpringApplication.run(OnlineBookShopApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Initialization of some records to database");

        //initializeDatabaseManually();
    }

    private void initializeDatabaseManually() {
        List<BookCategory> bookCategories = new ArrayList<>();

        BookCategory bookCategory1 = new BookCategory();
        bookCategory1.setId(1L);
        bookCategory1.setCategoryName("Penguin Books");
        bookCategories.add(bookCategory1);

        BookCategory bookCategory2 = new BookCategory();
        bookCategory2.setId(2L);
        bookCategory2.setCategoryName("Programming");
        bookCategories.add(bookCategory2);

        BookCategory bookCategory3 = new BookCategory();
        bookCategory3.setId(3L);
        bookCategory3.setCategoryName("Novel");
        bookCategories.add(bookCategory3);

        BookCategory bookCategory4 = new BookCategory();
        bookCategory4.setId(4L);
        bookCategory4.setCategoryName("History");
        bookCategories.add(bookCategory4);

        List<Book> books = new ArrayList<>();

        // Book1
        Book book1 = new Book();
        book1.setId(1L);
        book1.setName("The Boys in the Boat: Nine Americans and Their Epic Quest for Gold at the 1936 Berlin Olympics");
        book1.setSku("text-100");
        book1.setDescription("This is The Boys in the Boat");
        book1.setUnitPrice(new BigDecimal(1245.56));
        book1.setImageUrl("assets/images/books/100.jpg");
        book1.setActive(true);
        book1.setUnitsInStock(1234);
        book1.setCreatedOn(LocalDate.now());
        book1.setUpdatedOn(LocalDate.now());
        Set<Book> bookSet1 = new HashSet<>();
        bookSet1.add(book1);
        bookCategory1.setBook(bookSet1);
        book1.setCategory(bookCategory1);
        books.add(book1);

        // Book2
        Book book2 = new Book();
        book2.setId(2L);
        book2.setName("The Time Travelers Wife Audrey Niffenegger");
        book2.setSku("text-101");
        book2.setDescription("This is The Boys in the Boat");
        book2.setUnitPrice(new BigDecimal(1245.56));
        book2.setImageUrl("assets/images/books/101.jpg");
        book2.setActive(true);
        book2.setUnitsInStock(1234);
        book2.setCreatedOn(LocalDate.now());
        book2.setUpdatedOn(LocalDate.now());
        Set<Book> bookSet2 = new HashSet<>();
        bookSet2.add(book2);
        bookCategory2.setBook(bookSet2);
        book2.setCategory(bookCategory2);
        books.add(book2);

        // Book3
        Book book3 = new Book();
        book3.setId(3L);
        book3.setName("The Closing of the Western Mind: The Rise of Faith and the Fall of Reason");
        book3.setSku("text-102");
        book3.setDescription("Charles Freeman");
        book3.setUnitPrice(new BigDecimal(15.56));
        book3.setImageUrl("assets/images/books/102.jpg");
        book3.setActive(true);
        book3.setUnitsInStock(343);
        book3.setCreatedOn(LocalDate.now());
        book3.setUpdatedOn(LocalDate.now());
        Set<Book> bookSet3 = new HashSet<>();
        bookSet3.add(book3);
        bookCategory3.setBook(bookSet3);
        book2.setCategory(bookCategory3);
        books.add(book2);

        // Book4
        Book book4 = new Book();
        book4.setId(1L);
        book4.setName("Time, Space, Stars & Man: The Story of the Big Bang");
        book4.setSku("text-103");
        book4.setDescription("World Scientific Publishing Company");
        book4.setUnitPrice(new BigDecimal(1245.56));
        book4.setImageUrl("assets/images/books/103.jpg");
        book4.setActive(true);
        book4.setUnitsInStock(1234);
        book4.setCreatedOn(LocalDate.now());
        book4.setUpdatedOn(LocalDate.now());
        Set<Book> bookSet4 = new HashSet<>();
        bookSet4.add(book4);
        bookCategory3.setBook(bookSet4);
        book4.setCategory(bookCategory3);
        books.add(book4);

        // Book5
        Book book5 = new Book();
        book5.setId(5L);
        book5.setName("The Tipping Point: How Little Things Can Make a Big Difference");
        book5.setSku("text-104");
        book5.setDescription("Back Bay Books");
        book5.setUnitPrice(new BigDecimal(145.56));
        book5.setImageUrl("assets/images/books/104.jpg");
        book5.setActive(false);
        book5.setUnitsInStock(134);
        book5.setCreatedOn(LocalDate.now());
        book5.setUpdatedOn(LocalDate.now());
        Set<Book> bookSet5 = new HashSet<>();
        bookSet5.add(book5);
        bookCategory4.setBook(bookSet5);
        book5.setCategory(bookCategory4);
        books.add(book5);

        // Book6
        Book book6 = new Book();
        book6.setId(6L);
        book6.setName("Between the World and Me");
        book6.setSku("text-105");
        book6.setDescription("Hardcover");
        book6.setUnitPrice(new BigDecimal(245.56));
        book6.setImageUrl("assets/images/books/105.jpg");
        book6.setActive(true);
        book6.setUnitsInStock(124);
        book6.setCreatedOn(LocalDate.now());
        book6.setUpdatedOn(LocalDate.now());
        Set<Book> bookSet6 = new HashSet<>();
        bookSet6.add(book6);
        bookCategory2.setBook(bookSet6);
        book6.setCategory(bookCategory2);
        books.add(book6);

        // Book7
        Book book7 = new Book();
        book7.setId(7L);
        book7.setName("Baby Penguins Love their Mama");
        book7.setSku("text-100");
        book7.setDescription("Humor");
        book7.setUnitPrice(new BigDecimal(125.99));
        book7.setImageUrl("assets/images/books/106.jpg");
        book7.setActive(false);
        book7.setUnitsInStock(14);
        book7.setCreatedOn(LocalDate.now());
        book7.setUpdatedOn(LocalDate.now());
        Set<Book> bookSet7 = new HashSet<>();
        bookSet7.add(book7);
        bookCategory2.setBook(bookSet7);
        book7.setCategory(bookCategory2);
        books.add(book7);

        // Book8
        Book book8 = new Book();
        book8.setId(8L);
        book8.setName("Tricky Twenty-Two: A Stephanie Plum Novel");
        book8.setSku("text-108");
        book8.setDescription("Tricky Twenty-Two");
        book8.setUnitPrice(new BigDecimal(45.90));
        book8.setImageUrl("assets/images/books/107.jpg");
        book8.setActive(true);
        book8.setUnitsInStock(14);
        book8.setCreatedOn(LocalDate.now());
        book8.setUpdatedOn(LocalDate.now());
        Set<Book> bookSet8 = new HashSet<>();
        bookSet8.add(book8);
        bookCategory3.setBook(bookSet8);
        book8.setCategory(bookCategory3);
        books.add(book8);

        // Book9
        Book book9 = new Book();
        book9.setId(9L);
        book9.setName("A Million Random Digits THE SEQUEL: with Perfectly Uniform Distribution");
        book9.setSku("text-109");
        book9.setDescription("A Million Random Digits THE SEQUEL");
        book9.setUnitPrice(new BigDecimal(654.56));
        book9.setImageUrl("assets/images/books/108.jpg");
        book9.setActive(true);
        book9.setUnitsInStock(334);
        book9.setCreatedOn(LocalDate.now());
        book9.setUpdatedOn(LocalDate.now());
        Set<Book> bookSet9 = new HashSet<>();
        bookSet9.add(book9);
        bookCategory1.setBook(bookSet9);
        book9.setCategory(bookCategory1);
        books.add(book9);

        // Book10
        Book book10 = new Book();
        book10.setId(10L);
        book10.setName("The Sign: The Shroud of Turin and the Secret of the Resurrection");
        book10.setSku("text-1010");
        book10.setDescription("The Sign");
        book10.setUnitPrice(new BigDecimal(5.56));
        book10.setImageUrl("assets/images/books/109.jpg");
        book10.setActive(true);
        book10.setUnitsInStock(14);
        book10.setCreatedOn(LocalDate.now());
        book10.setUpdatedOn(LocalDate.now());
        Set<Book> bookSet10 = new HashSet<>();
        bookSet10.add(book10);
        bookCategory4.setBook(bookSet10);
        book10.setCategory(bookCategory4);
        books.add(book10);

        // Book11
        Book book11 = new Book();
        book11.setId(11L);
        book11.setName("Thug Kitchen Party Grub: For Social Motherf*ckers");
        book11.setSku("text-111");
        book11.setDescription("Thug Kitchen Party Grub");
        book11.setUnitPrice(new BigDecimal(153.08));
        book11.setImageUrl("assets/images/books/1010.jpg");
        book11.setActive(false);
        book11.setUnitsInStock(144);
        book11.setCreatedOn(LocalDate.now());
        book11.setUpdatedOn(LocalDate.now());
        Set<Book> bookSet11 = new HashSet<>();
        bookSet11.add(book11);
        bookCategory3.setBook(bookSet11);
        book11.setCategory(bookCategory3);
        books.add(book11);

        bookCategories.forEach(bookCategoryRepository::saveAndFlush);
        books.forEach(bookRepository::saveAndFlush);
    }

}
