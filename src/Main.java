import java.util.*;

public class Main {
    public static void main(String[] args) {
        Book bookFirst = new Book(1, "451 градус по Ф.", BookStatus.RESERVED);
        Book bookSecond = new Book(2, "Библия", BookStatus.RESERVED);
        Book bookThird = new Book(3, "код", BookStatus.OVERDUE);
        Book bookFourth = new Book(4, "Как устроена экономика", BookStatus.RESERVED);
        Book bookFifth = new Book(5, "убить пересмешника", BookStatus.OVERDUE);

        Student daniil = new Student(null, List.of(bookThird, bookFourth));
        Student vera = new Student("Вера", List.of(bookFifth, bookFirst));
        Student alex = new Student("Alex", List.of(bookSecond));
        Student tatiana = new Student("Tatiana", List.of());

        List<Student> students = new ArrayList<>();
        students.add(daniil);
        students.add(vera);
        students.add(alex);
        students.add(tatiana);

        //у нас есть студенты, найти тех, у которых имя длиной больше 5 символов.
        //Имена студентов, у которых имя больше 5 символов

        List<String> result = students.stream()
                .map(Student::getName)
                .filter(Objects::nonNull)
                .filter(name -> name.length() > 5)
                .toList();

        System.out.println(result);

        //Имена студентов, у которых больше одной книги

        //long count = students.stream()
        //        .filter(student -> student.getBooks() != null)
        //        .filter(student -> student.getBooks().size() > 1)
        //        .map(Student::getName)
        //        .count();

        //System.out.println(count);


        //Имена студентов, у которых больше одной книги и есть просроченные книги

        List<String> names = students.stream()
                .filter(student -> student.getBooks() != null)
                .filter(student -> student.getBooks().size() > 1)
                .filter(Student::checkOverdueBooks)
                .map(Student::getName)
                .filter(Objects::nonNull)
                .toList();

        System.out.println(names);

        //найти людей, у кого просрочены книжки
        //                .filter(student -> {
        //                    Set<Book> books = student.getBooks();
        //                    for (Book book : books) {
        //                        if (book.getStatus() == BookStatus.OVERDUE) {
        //                            return true;
        //                        }
        //                    }
        //                    return false;
        //                })


        //найти просроченные книжки


        //найти все просроченные книги, длина названия которых больше 8 букв

        List<Book> books = students.stream()
                .map(Student::getBooks)
                .filter(Objects::nonNull)
                .flatMap(books1 -> books1.stream())
                .filter(Objects::nonNull)
                .filter(book -> book.getStatus() == BookStatus.OVERDUE)
                .filter(book -> book.getName() != null)
                .filter(book -> book.getName().length() > 8)
                .toList();

        //найти все зарезервированные книги, на людей с именем на букву A

        List<Book> answer = students.stream()
                .filter(student -> student.getName() != null && student.getName().startsWith("A"))
                .map(Student::getBooks)
                .flatMap(Collection::stream)
                .filter(book -> book != null && book.getStatus() != null && book.getStatus() == BookStatus.RESERVED)
                .toList();

        System.out.println(answer);

        //Найти все книги, которые у студентов, у которых id делится на 2

        //students.stream()


    }
}