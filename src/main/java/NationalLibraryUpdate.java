public class NationalLibraryUpdate {
    public static void main(String[] args) {
        /*BookDao bookDao = new BookDao();
        Book book = bookDao.read(2);
        book.setTitle("Casablanca");
        book.setAuthor("Bergmann");
        book.setYear(1922);
        book.setIsbn("11111");
        bookDao.update(book);
        */
        BookDao bookDao1 = new BookDao();
        Book book = bookDao1.delete(2);
        bookDao1.close();
    }
}
