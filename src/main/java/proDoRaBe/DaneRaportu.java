package proDoRaBe;

public class DaneRaportu {

    private String nazwaFirmy;
    private String adresFirmy;
    private String nazwaLinii;
    private String autorRaportu;
    private String telefonKontaktowyDoAutoraRaportu;
    private String adresEmailDoAutoraRaportu;
    private String osobaOdpowiedzialnaPoStronieZamawiajacejRaport;
    private String telefonKontaktowyDoOsobyOsobyOdpowiedzialnejPoStronieZamawiajacego;
    private String adresEmailDoOsobyOdpowiedzialnejPoStronieZamawiajacego;

    public void dodajDaneRaportu (String nazwaFirmy, String adresFirmy, String nazwaLinii, String autorRaportu, String telefonKontaktowyDoAutoraRaportu, String adresEmailDoAutoraRaportu, String osobaOdpowiedzialnaPoStronieZamawiajacejRaport, String telefonKontaktowyDoOsobyOsobyOdpowiedzialnejPoStronieZamawiajacego, String adresEmailDoOsobyOdpowiedzialnejPoStronieZamawiajacego){
        this.nazwaFirmy = nazwaFirmy;
        this.adresFirmy = adresFirmy;
        this.nazwaLinii = nazwaLinii;
        this.autorRaportu = autorRaportu;
        this.telefonKontaktowyDoAutoraRaportu = telefonKontaktowyDoAutoraRaportu;
        this.adresEmailDoAutoraRaportu = adresEmailDoAutoraRaportu;
        this.osobaOdpowiedzialnaPoStronieZamawiajacejRaport = osobaOdpowiedzialnaPoStronieZamawiajacejRaport;
        this.telefonKontaktowyDoOsobyOsobyOdpowiedzialnejPoStronieZamawiajacego = telefonKontaktowyDoOsobyOsobyOdpowiedzialnejPoStronieZamawiajacego;
        this.adresEmailDoOsobyOdpowiedzialnejPoStronieZamawiajacego = adresEmailDoOsobyOdpowiedzialnejPoStronieZamawiajacego;
    }

}
