import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Student {

    private String name;

    private List<Book> books;

    public Student(String name, List<Book> books) {
        this.name = name;
        this.books = books;
    }

    public boolean checkOverdueBooks() {
        long count = books.stream()
                .filter(Objects::nonNull)
                .filter(book -> book.getStatus() == BookStatus.OVERDUE)
                .count();

        return count > 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", books=" + books +
                '}';
    }
}
