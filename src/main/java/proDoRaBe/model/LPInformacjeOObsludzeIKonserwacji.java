package proDoRaBe.model;

import java.util.ArrayList;

public class LPInformacjeOObsludzeIKonserwacji {

    //Informacje o obsludze i konserwacji
    private String surowiecDoProdukcji;
    private String czasZatrzymaniaAwaryjnego;
    private String czasCykluMaszyny;
    private String liczbaOperatorow;
    private String iloscStacjiOperatorskich;
    private String konserwacjaWykonywanaPrzez;
    private String czestotliwoscKonserwacji;
    private String czyszczenie;
    private String naprawaZaciec;
    private String sprzatanie;

    public LPInformacjeOObsludzeIKonserwacji() {
    }


    public void dodajLPInformacjeOObsludzeIKonserwacji (

            //Informacje o obsludze i konserwacji
            String surowiecDoProdukcji,
            String czasZatrzymaniaAwaryjnego,
            String czasCykluMaszyny,
            String liczbaOperatorow,
            String iloscStacjiOperatorskich,
            String konserwacjaWykonywanaPrzez,
            String czestotliwoscKonserwacji,
            String czyszczenie,
            String naprawaZaciec,
            String sprzatanie
) {
        if (czyPodanoWartosc(surowiecDoProdukcji)) {
            this.surowiecDoProdukcji = surowiecDoProdukcji;
        }
        if (czyPodanoWartosc(czasZatrzymaniaAwaryjnego)) {
            this.czasZatrzymaniaAwaryjnego = czasZatrzymaniaAwaryjnego;
        }
        if (czyPodanoWartosc(czasCykluMaszyny)) {
            this.czasCykluMaszyny = czasCykluMaszyny;
        }
        if (czyPodanoWartosc(liczbaOperatorow)) {
            this.liczbaOperatorow = liczbaOperatorow;
        }
        if (czyPodanoWartosc(iloscStacjiOperatorskich)) {
            this.iloscStacjiOperatorskich = iloscStacjiOperatorskich;
        }
        if (czyPodanoWartosc(konserwacjaWykonywanaPrzez)) {
            this.konserwacjaWykonywanaPrzez = konserwacjaWykonywanaPrzez;
        }
        if (czyPodanoWartosc(czestotliwoscKonserwacji)) {
            this.czestotliwoscKonserwacji = czestotliwoscKonserwacji;
        }
        if (czyPodanoWartosc(czyszczenie)) {
            this.czyszczenie = czyszczenie;
        }
        if (czyPodanoWartosc(naprawaZaciec)) {
            this.naprawaZaciec = naprawaZaciec;
        }
        if (czyPodanoWartosc(sprzatanie)) {
            this.sprzatanie = sprzatanie;
        }
    }

    private boolean czyPodanoWartosc (String watsocSprawdzana){
        if (watsocSprawdzana==null || watsocSprawdzana.isEmpty()){
            return false;
        } else return true;

    }

    public String getSurowiecDoProdukcji() {
        return surowiecDoProdukcji;
    }

    public String getCzasZatrzymaniaAwaryjnego() {
        return czasZatrzymaniaAwaryjnego;
    }

    public String getCzasCykluMaszyny() {
        return czasCykluMaszyny;
    }

    public String getLiczbaOperatorow() {
        return liczbaOperatorow;
    }

    public String getIloscStacjiOperatorskich() {
        return iloscStacjiOperatorskich;
    }

    public String getKonserwacjaWykonywanaPrzez() {
        return konserwacjaWykonywanaPrzez;
    }

    public String getCzestotliwoscKonserwacji() {
        return czestotliwoscKonserwacji;
    }

    public String getCzyszczenie() {
        return czyszczenie;
    }

    public String getNaprawaZaciec() {
        return naprawaZaciec;
    }

    public String getSprzatanie() {
        return sprzatanie;
    }

}
