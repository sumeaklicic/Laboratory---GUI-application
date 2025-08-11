

public class AdminAuthenticator {
    private static final String KORISNICKO_IME = "sumea";
    private static final String LOZINKA = "2011";

    public static boolean provjeriLogin(String korisnickoIme, String lozinka) {
        return KORISNICKO_IME.equals(korisnickoIme) && LOZINKA.equals(lozinka);
    }
}