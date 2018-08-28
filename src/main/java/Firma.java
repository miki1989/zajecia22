public class Firma {
    public static void main(String[] args) {

        PracownikDao dao = new PracownikDao();

        Pracownik pracownik1 = new Pracownik("Elzbieta", "kowalska", 4500);

        dao.save(pracownik1);
    }
}
