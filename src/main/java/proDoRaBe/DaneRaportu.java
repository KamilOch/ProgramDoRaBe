package proDoRaBe;

public class DaneRaportu {

    private DaneZamawiajacegoRaport;
    private DaneWykonujacegoRaport;

    public void dodajDaneRaportu (String nazwaFirmy, String adresFirmy, String nazwaLinii, String autorRaportu, String telefonKontaktowyDoAutoraRaportu, String adresEmailDoAutoraRaportu, String osobaOdpowiedzialnaPoStronieZamawiajacejRaport, String telefonKontaktowyDoOsobyOsobyOdpowiedzialnejPoStronieZamawiajacego, String adresEmailDoOsobyOdpowiedzialnejPoStronieZamawiajacego){

        if (czyPodanoWartosc(nazwaFirmy)){
            this.nazwaFirmy = nazwaFirmy;
        }
        if (czyPodanoWartosc(adresFirmy)){
            this.adresFirmy = adresFirmy;
        }
        if(czyPodanoWartosc(nazwaLinii)) {
            this.nazwaLinii = nazwaLinii;
        }
        if(czyPodanoWartosc(autorRaportu)) {
            this.autorRaportu = autorRaportu;
        }
        if(czyPodanoWartosc(telefonKontaktowyDoAutoraRaportu)) {
            this.telefonKontaktowyDoAutoraRaportu = telefonKontaktowyDoAutoraRaportu;
        }
        if(czyPodanoWartosc(adresEmailDoAutoraRaportu)) {
            this.adresEmailDoAutoraRaportu = adresEmailDoAutoraRaportu;
        }
        if(czyPodanoWartosc(osobaOdpowiedzialnaPoStronieZamawiajacejRaport)) {
            this.osobaOdpowiedzialnaPoStronieZamawiajacejRaport = osobaOdpowiedzialnaPoStronieZamawiajacejRaport;
        }
        if(czyPodanoWartosc(telefonKontaktowyDoOsobyOsobyOdpowiedzialnejPoStronieZamawiajacego)) {
            this.telefonKontaktowyDoOsobyOsobyOdpowiedzialnejPoStronieZamawiajacego = telefonKontaktowyDoOsobyOsobyOdpowiedzialnejPoStronieZamawiajacego;
        }
        if(czyPodanoWartosc(adresEmailDoOsobyOdpowiedzialnejPoStronieZamawiajacego)) {
            this.adresEmailDoOsobyOdpowiedzialnejPoStronieZamawiajacego = adresEmailDoOsobyOdpowiedzialnejPoStronieZamawiajacego;
        }
    }

    private boolean czyPodanoWartosc (String watsocSprawdzana){
       if (watsocSprawdzana==null || watsocSprawdzana.isEmpty()){
           return false;
       } else return true;

    }

    public String getNazwaFirmy() {
        return nazwaFirmy;
    }

    public String getAdresFirmy() {
        return adresFirmy;
    }

    public String getNazwaLinii() {
        return nazwaLinii;
    }

    public String getAutorRaportu() {
        return autorRaportu;
    }

    public String getTelefonKontaktowyDoAutoraRaportu() {
        return telefonKontaktowyDoAutoraRaportu;
    }

    public String getAdresEmailDoAutoraRaportu() {
        return adresEmailDoAutoraRaportu;
    }

    public String getOsobaOdpowiedzialnaPoStronieZamawiajacejRaport() {
        return osobaOdpowiedzialnaPoStronieZamawiajacejRaport;
    }

    public String getTelefonKontaktowyDoOsobyOsobyOdpowiedzialnejPoStronieZamawiajacego() {
        return telefonKontaktowyDoOsobyOsobyOdpowiedzialnejPoStronieZamawiajacego;
    }

    public String getAdresEmailDoOsobyOdpowiedzialnejPoStronieZamawiajacego() {
        return adresEmailDoOsobyOdpowiedzialnejPoStronieZamawiajacego;
    }
}
