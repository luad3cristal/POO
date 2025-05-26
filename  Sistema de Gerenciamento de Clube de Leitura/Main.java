import java.util.*;

class ReadingClub {
  private Set<Book> books;
  private Set<Member> members;

  public ReadingClub() {
    books = new LinkedHashSet<Book>();
    members = new LinkedHashSet<Member>();
  }

  public void setMember(Member member) {
    members.add(member);
  }

  public void setBook(Book book) {
    books.add(book);
  }

  public int membersAmount() {
    return Member.getMembersAmount();
  }

  public Book mostRecommendedBook() {
    Iterator<Book> count = books.iterator();
    int max = 0;
    Book book = null;
    Book recommended = null;

    while (count.hasNext()) {
      book = count.next();
      if (book.getRecommendations() > max) {
        recommended = book;
        max = recommended.getRecommendations();
      }
    }
    return recommended;
  }

  public void showDetails() {
    System.out.println("Reading Club details: ");
    System.out.println("Amount of Members: " + membersAmount());

    if (books == null || books.isEmpty()) {
      System.out.println("No books registered");
    } else {
      System.out.println("Most Recommended Book: " + mostRecommendedBook());
    }
    System.out.println("Members:");
    for (Member member : members) {
      System.out.println(member);
    }
    System.out.println("Books:");
    for (Book book : books) {
      System.out.println(book);
    }

  }
}

class Member {
  private String name;
  private String address;
  private String birthDate;
  private static int membersAmount;
  private Set<Book> books;

  public Member(String name, String address, String birthDate) {
    this.name = name;
    this.address = address;
    this.birthDate = birthDate;
    books = new LinkedHashSet<Book>();
    membersAmount++;
  }

  public static int getMembersAmount() {
    return membersAmount;
  }

  public void addBook(Book book) {
    books.add(book);
  }

  public String getName() {
    return name;
  }

  public String getAddress() {
    return address;
  }

  public String getBirthDate() {
    return birthDate;
  }

  public String getReadBooks() {
    StringBuilder readBooks = new StringBuilder();
    for (Book book : books) {
      readBooks.append(book.toString()).append('\n');
    }
    return readBooks.toString();
  }

  @Override
  public String toString() {
    return name + " - " + address + " - Born: " + birthDate;
  }

  public void showDetails() {
    System.out.println("Member details: ");
    System.out.println("Name: " + getName());
    System.out.println("Address: " + getAddress());
    System.out.println("Birth Date: " + getBirthDate());
    System.out.println("Books Read: " + getReadBooks());
  }
}

class Book {
  private String title;
  private String author;
  private int year;
  private int recommendationsAmount;

  public Book(String title, String author, int year) {
    this.title = title;
    this.author = author;
    this.year = year;
  }

  public void incrementRecommendations() {
    recommendationsAmount++;
  }

  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }

  public int getYear() {
    return year;
  }

  public int getRecommendations() {
    return recommendationsAmount;
  }

  @Override
  public String toString() {
    return String.format("%s (%s, %d) - Recommendations: %d", title, author, year, recommendationsAmount);
  }

  public void showDetails() {
    System.out.println("Book details: ");
    System.out.println("Title: " + getTitle());
    System.out.println("Author: " + getAuthor());
    System.out.println("Year: " + getYear());
    System.out.println("Amount of Recommendations: " + getRecommendations());
    System.out.println("\n");
  }

}

class Meeting {
  private String date;
  private String theme;
  private Set<Member> members;
  private Set<Book> books;

  public Meeting(String date, String theme) {
    this.date = date;
    this.theme = theme;
    members = new HashSet<Member>();
    books = new HashSet<Book>();
  }

  public void registerMember(Member member) {
    members.add(member);
  }

  public void addBook(Book book) {
    books.add(book);
  }

  public String getDate() {
    return date;
  }

  public String getTheme() {
    return theme;
  }

  public String getMembers() {
    StringBuilder participants = new StringBuilder();
    for (Member member : members) {
      participants.append(member.toString()).append('\n');
    }
    return participants.toString();
  }

  public String getDiscussedBooks() {
    StringBuilder discussedBooks = new StringBuilder();
    for (Book book : books) {
      discussedBooks.append(book.toString()).append('\n');
    }
    return discussedBooks.toString();
  }

  public void showDetails() {
    System.out.println("Meeting details: ");
    System.out.println("Date: " + getDate());
    System.out.println("Theme: " + getTheme());
    System.out.println("Members Names: " + getMembers());
    System.out.println("Discussed Books: " + getDiscussedBooks());
  }
}

// Main desenvolvida pelo chat gpt para melhor utilização de todos os métodos no
// código.
public class Main {
  public static void main(String[] args) {
    // Criando livros
    Book b1 = new Book("1984", "George Orwell", 1949);
    Book b2 = new Book("Brave New World", "Aldous Huxley", 1932);
    Book b3 = new Book("Fahrenheit 451", "Ray Bradbury", 1953);

    // Recomendando livros
    b1.incrementRecommendations();
    b1.incrementRecommendations();
    b2.incrementRecommendations();

    // Criando membros
    Member m1 = new Member("Alice", "Rua A", "01/01/1990");
    Member m2 = new Member("Bob", "Rua B", "02/02/1992");

    // Membros leem livros
    m1.addBook(b1);
    m1.addBook(b2);
    m2.addBook(b2);
    m2.addBook(b3);

    // Criando clube e adicionando membros e livros
    ReadingClub club = new ReadingClub();
    club.setMember(m1);
    club.setMember(m2);
    club.setBook(b1);
    club.setBook(b2);
    club.setBook(b3);

    // Criando reunião
    Meeting meeting = new Meeting("25/05/2025", "Distopias literárias");
    meeting.registerMember(m1);
    meeting.registerMember(m2);
    meeting.addBook(b1);
    meeting.addBook(b2);

    // Exibindo detalhes de todos os elementos
    System.out.println("==== Livro 1 ====");
    b1.showDetails();

    System.out.println("==== Livro 2 ====");
    b2.showDetails();

    System.out.println("==== Livro 3 ====");
    b3.showDetails();

    System.out.println("==== Membro 1 ====");
    m1.showDetails();

    System.out.println("==== Membro 2 ====");
    m2.showDetails();

    System.out.println("==== Reunião ====");
    meeting.showDetails();

    System.out.println("==== Clube de Leitura ====");
    club.showDetails();
  }
}
