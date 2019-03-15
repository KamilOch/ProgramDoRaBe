package proDoRaBe;

public class DaneZamawiajacegoRaport {

    private String nazwaFirmy;
    private String adresFirmy;
    private String adresEmjlowyFirmy;
    private String telefonKontaktowyFirmy;

    private String osobaOdpowiedzialnaPoStronieZamawiajacejRaport;
    private String telefonKontaktowyDoOsobyOsobyOdpowiedzialnejPoStronieZamawiajacego;
    private String adresEmailDoOsobyOdpowiedzialnejPoStronieZamawiajacego;

    public void dodajDaneZamawiajacegoRaport (String nazwaFirmy, String adresFirmy,String adresEmjlowyFirmy, String telefonKontaktowyFirmy, String osobaOdpowiedzialnaPoStronieZamawiajacejRaport, String telefonKontaktowyDoOsobyOsobyOdpowiedzialnejPoStronieZamawiajacego, String adresEmailDoOsobyOdpowiedzialnejPoStronieZamawiajacego ){

        if (czyPodanoWartosc(nazwaFirmy)){
            this.nazwaFirmy = nazwaFirmy;
        }
        if (czyPodanoWartosc(adresFirmy)){
            this.adresFirmy = adresFirmy;
        }
        if(czyPodanoWartosc(adresEmjlowyFirmy)) {
            this.adresEmjlowyFirmy = adresEmjlowyFirmy;
        }
        if(czyPodanoWartosc(telefonKontaktowyFirmy)) {
            this.telefonKontaktowyFirmy = telefonKontaktowyFirmy;
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

    public String getAdresEmjlowyFirmy() {
        return adresEmjlowyFirmy;
    }

    public String getTelefonKontaktowyFirmy() {
        return telefonKontaktowyFirmy;
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
