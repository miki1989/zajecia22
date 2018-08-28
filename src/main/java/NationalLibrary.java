public class NationalLibrary {
    public static void main(String[] args) {

        Book book1 = new Book("Ogniem i mieczem", "Sienkiewicz", 1950, "8939320");
        BookDao bookDao = new BookDao();
        bookDao.save(book1);
        Book book2 = new Book("Przeminęło z wiatrem", "Mitchell", 1940, "876232");
        bookDao.save(book2);
        bookDao.close();
    }
}
