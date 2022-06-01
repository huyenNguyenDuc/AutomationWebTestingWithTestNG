package testSteps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;
import io.cucumber.java.Transpose;
import io.cucumber.java.en.Given;
import objects.Book;
import objects.BookDetail;

import java.util.List;
import java.util.Map;


public class DataTableStepdefs {
    // Create a domain object (Book, BookDetails), when we want to reuse it anywhere in this project
    // If we don't want to reuse it, use Datatable type)
    @DataTableType
    public Book listBook(List<String> inputBook) {
        return new Book(inputBook.get(0), inputBook.get(1));
    }

    //must create other object when the type is different (e.x: List<String> # List<List<String>> # Map<String, String>)
    @DataTableType
    public BookDetail mapBook( Map<String, String> inputBook) {
        return new BookDetail(inputBook.get("book name"), inputBook.get("author"));
    }

    @Given("I have the book below on the book store")
    public void iHaveTheBookBelowOnTheBookStore(Book enteredBook) {
        System.out.print("\nI GET THE BOOK NAME: " + enteredBook.getBookName());
        System.out.print("\nI GET THE AUTHOR NAME: " + enteredBook.getAuthor());
    }

    @Given("I have the books below on the book store")
    public void iHaveTheBooksBelowOnTheBookStore(List<Book> enteredBook) {
        System.out.print("\nI GET THE BOOK NAME OF 1ST BOOK: " + enteredBook.get(0).getBookName());
        System.out.print("\nI GET THE AUTHOR NAME OF 1ST BOOK: " + enteredBook.get(0).getAuthor());
        System.out.print("\nI GET THE BOOK NAME OF 2nd BOOK: " + enteredBook.get(1).getBookName());
        System.out.print("\nI GET THE AUTHOR NAME OF 2nd BOOK: " + enteredBook.get(1).getAuthor());
    }


    // Map<String, String> will ignore the first row in the given data table and set it as object keys
    @Given("I have the details of the book on the book store as below")
    public void iHaveTheDetailOfBookOnTheBookStore(BookDetail enteredBook) {
        System.out.print("\nI GET THE BOOK NAME: " + enteredBook.getBookName());
        System.out.print("\nI GET THE AUTHOR NAME: " + enteredBook.getAuthor());
    }


    @Given("I have the details of the books on the book store as below")
    public void iHaveTheDetailOfBooksOnTheBookStore(List<BookDetail> enteredBook) {
        System.out.print("\nI GET THE BOOK NAME OF 1ST BOOK: " + enteredBook.get(0).getBookName());
        System.out.print("\nI GET THE AUTHOR NAME OF 1ST BOOK: " + enteredBook.get(0).getAuthor());
        System.out.print("\nI GET THE BOOK NAME OF 2nd BOOK: " + enteredBook.get(1).getBookName());
        System.out.print("\nI GET THE AUTHOR NAME OF 2nd BOOK: " + enteredBook.get(1).getAuthor());
    }

    // Use DataTable to process the given data. dataTable is just local variable
    @Given("I have the book on the book store as below column")
    public void iHaveTheBookAsBelowColumn(DataTable dataTable) {
        List<String> book = dataTable.asList();
        System.out.print("\nI GET THE BOOK NAME: " + book.get(0));
        System.out.print("\nI GET THE AUTHOR NAME: " + book.get(1));
    }

    @Given("I have the book and its detail on the book store as below columns")
    public void iHaveTheBookAndDetailAsBelowColumns(DataTable dataTable) {
        Map<String, String> book = dataTable.asMap();
        System.out.print("\nI GET THE BOOK NAME: " + book.get("book name"));
        System.out.print("\nI GET THE AUTHOR NAME: " + book.get("author"));
    }

    @Given("I have the book as below column")
    public void theBookAsBelowColumn(@Transpose DataTable dataTable) {
        List<String> book = dataTable.row(0);
        System.out.print("\nI GET THE BOOK NAME: " + book.get(0));
        System.out.print("\nI GET THE AUTHOR NAME: " + book.get(1));
    }

    // Transpose the given data, then the data becomes the same with case "Single row with header"
    @Given("I have the book and its detail as below columns")
    public void theBookAndDetailAsBelowColumns(@Transpose BookDetail dataTable) {
        System.out.print("\nI GET THE BOOK NAME: " + dataTable.getBookName());
        System.out.print("\nI GET THE AUTHOR NAME: " + dataTable.getAuthor());
    }

    @Given("draft {int} test")
    public void draftTest( int arg0, @Transpose BookDetail table) {
        System.out.print("\nI GET THE BOOK NAME: " + table.getBookName());
        System.out.print("\nI GET THE AUTHOR NAME: " + table.getAuthor());
    }

    // transpose the given data to the case "Multiple rows with header"
    @Given("I have the books and its detail on the book store as below columns")
    public void theBooksAndDetailAsBelowColumns(@Transpose List<BookDetail> dataTable) {
        System.out.print("\nI GET THE BOOK NAME 1ST BOOK: " + dataTable.get(0).getBookName());
        System.out.print("\nI GET THE AUTHOR NAME 1ST BOOK: " + dataTable.get(0).getAuthor());
        System.out.print("\nI GET THE BOOK NAME OF 2nd BOOK: " + dataTable.get(1).getBookName());
        System.out.print("\nI GET THE AUTHOR NAME OF 2nd BOOK: " + dataTable.get(1).getAuthor());
    }
}
