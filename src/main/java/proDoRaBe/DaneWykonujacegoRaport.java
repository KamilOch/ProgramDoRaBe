package proDoRaBe;

public class DaneWykonujacegoRaport {

    private String nazwaFirmy;
    private String adresFirmy;
    private String adresEmjlowyFirmy;

    private String autorRaportu;
    private String telefonKontaktowyDoAutoraRaportu;
    private String adresEmailDoAutoraRaportu;

    private String osobaZatwierdzajacaRaport;

    private String osobaKontaktowaWSprawieRaportu;
    private String telefonKontaktowyDoOsobyWSprawieRaportu;
    private String adresEmailDoOsobyWSprawieRaportu;

    public void dodajDaneWykonujacegoRaport (String nazwaFirmy, String adresFirmy, String adresEmjlowyFirmy, String autorRaportu, String telefonKontaktowyDoAutoraRaportu, String adresEmailDoAutoraRaportu, String osobaZatwierdzajacaRaport, String osobaKontaktowaWSprawieRaportu, String telefonKontaktowyDoOsobyWSprawieRaportu, String adresEmailDoOsobyWSprawieRaportu){
        if (czyPodanoWartosc(nazwaFirmy)){
            this.nazwaFirmy = nazwaFirmy;
        }
        if (czyPodanoWartosc(adresFirmy)){
            this.adresFirmy = adresFirmy;
        }
        if (czyPodanoWartosc(adresEmjlowyFirmy)){
            this.adresEmjlowyFirmy = adresEmjlowyFirmy;
        }
        if (czyPodanoWartosc(autorRaportu)){
            this.autorRaportu = autorRaportu;
        }
        if (czyPodanoWartosc(telefonKontaktowyDoAutoraRaportu)){
            this.telefonKontaktowyDoAutoraRaportu = telefonKontaktowyDoAutoraRaportu;
        }
        if (czyPodanoWartosc(adresEmailDoAutoraRaportu)){
            this.adresEmailDoAutoraRaportu = adresEmailDoAutoraRaportu;
        }
        if (czyPodanoWartosc(osobaZatwierdzajacaRaport)){
            this.osobaZatwierdzajacaRaport = osobaZatwierdzajacaRaport;
        }
        if (czyPodanoWartosc(osobaKontaktowaWSprawieRaportu)){
            this.osobaKontaktowaWSprawieRaportu = osobaKontaktowaWSprawieRaportu;
        }
        if (czyPodanoWartosc(telefonKontaktowyDoOsobyWSprawieRaportu)){
            this.telefonKontaktowyDoOsobyWSprawieRaportu = telefonKontaktowyDoOsobyWSprawieRaportu;
        }
        if (czyPodanoWartosc(adresEmailDoOsobyWSprawieRaportu)){
            this.adresEmailDoOsobyWSprawieRaportu = adresEmailDoOsobyWSprawieRaportu;
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

    public String getAdresEmjlowyFirmy() {
        return adresEmjlowyFirmy;
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

    public String getOsobaZatwierdzajacaRaport() {
        return osobaZatwierdzajacaRaport;
    }

    public String getOsobaKontaktowaWSprawieRaportu() {
        return osobaKontaktowaWSprawieRaportu;
    }

    public String getTelefonKontaktowyDoOsobyWSprawieRaportu() {
        return telefonKontaktowyDoOsobyWSprawieRaportu;
    }

    public String getAdresEmailDoOsobyWSprawieRaportu() {
        return adresEmailDoOsobyWSprawieRaportu;
    }
}
