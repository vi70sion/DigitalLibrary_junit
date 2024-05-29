import org.example.DigitalLibrary;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DigitalLibraryTest {

    static DigitalLibrary library;

    @BeforeEach
    public void setupBefore(){
        library = new DigitalLibrary();
        List<String> books = new ArrayList<>();
    }

    @Test
    public void addBookTestWithAddingBook(){
        //Setup
        String book = "Knyga1";
        library.getAllBooks().add(book);
        //Execute
        //Assert
        assertEquals(true, library.getAllBooks().contains(book));
    }

    @Test
    public void addBookTestWithAddingNullBook(){
        //Setup
        String book = null;
        //Execute
        library.addBook(book);
        //Assert
        assertEquals(false, library.getAllBooks().contains(book));
    }

    @Test
    public void addBookTestWithAddingEmptyBook(){
        //Setup
        String book = "";
        //Execute
        library.addBook(book);
        //Assert
        assertEquals(false, library.getAllBooks().contains(book));
    }

    @Test
    public void searchBooksTest(){
        //Setup
        String book = "Knyga111";
        library.getAllBooks().add(book);
        //Execute
        //Assert
        assertEquals(book, library.searchBooks("11").getFirst());
    }

    @Test
    public void getBookCountTestAddingTwoBooks(){
        //Setup
        String book1 = "Knyga1";
        String book2 = "Knyga2";
        library.getAllBooks().add(book1);
        library.getAllBooks().add(book2);
        //Execute
        //Assert
        assertEquals(2, library.getBookCount());
    }

    @Test
    public void getBookCountTestWithEmptyBookList(){
        //Assert
        assertEquals(0, library.getBookCount());
    }

    @Test
    public void isBookAvailableByBookTitle(){
        //Setup
        String book = "Knyga1";
        library.getAllBooks().add(book);
        //Execute
        //Assert
        assertEquals(true, library.getAllBooks().contains(book));
    }

    @Test
    public void isBookNotAvailableByBookTitle(){
        //Setup
        String book1 = "Knyga1";
        String book2 = "Knyga2";
        library.getAllBooks().add(book1);
        //Execute
        //Assert
        assertEquals(false, library.getAllBooks().contains(book2));
    }

    @Test
    public void updateBookTitleTestWithNoBookFound(){
        //Setup
        String book1 = "Knyga1";
        String book2 = "Knyga2";
        String book3 = "Knyga3";
        //Execute
        library.getAllBooks().add(book2);
        //Assert
        assertEquals(false, library.updateBookTitle(book1, book3));
    }

    @Test
    public void updateBookTitleTestWithBookFound(){
        //Setup
        String book1 = "Knyga1";
        String book2 = "Knyga2";
        //Execute
        library.getAllBooks().add(book2);
        //Assert
        assertEquals(false, library.updateBookTitle(book1, book2));
    }

    @Test
    public void removeBookFromBooksListByTitle(){
        //Setup
        String book1 = "Knyga1";
        String book2 = "Knyga2";
        library.getAllBooks().add(book1);
        library.getAllBooks().add(book2);
        //Execute
        library.removeBook(book1);
        //Assert
        assertEquals(false, library.getAllBooks().contains(book1));
    }

}
