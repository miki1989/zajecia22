public class NationalLibraryRead {
    public static void main(String[] args) {
        BookDao bookDao = new BookDao();
        Book book = bookDao.read(1);
        System.out.println(book);
        bookDao.close();
    }
}
