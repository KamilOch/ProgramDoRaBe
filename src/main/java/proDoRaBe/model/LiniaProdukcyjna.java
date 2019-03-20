package proDoRaBe.model;

import java.util.ArrayList;

public class LiniaProdukcyjna {

    private String nazwaLinii;
    private String producentLinii;
    private String typLinii;
    private String numerLinii;
    private String dataProdukcji;
    private String posiadaneCertyfikaty;
    // tego nie ma jeszcze w htmlu, do przemyslenia co  lista maszyn w linii
    private ArrayList<Maszyna> maszynay;

    // opis linii
    private String opisLinii;
    // tego tez nie ma w htmlu
    private Zdjecie zdjecieLinii;

    private String opisSystemuSterowania;
    // tego tez nie ma w htmlu
    private Zdjecie systemuSterowania;

    //Ograniczenia maszyny
    private String srodowiskoPracy;
    private String wymaganyPoziomSzkolenia;
    private String liniaObslugiwanaPrzez;
    private String przeznaczenieLinii;
    private String przewidzianyCzasUzytkowania;
    private String wymiaryMaszyny;
    private String srodowiskoPracyMaszyny;

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

    //Zrodla energi
    private String napiecieWUkladzieSterowania;
    private String zasilanieGlowne;
    private String cisnienieRoboczeWUkladziePneumatyki;
    private String cisnienieRoboczeWUkladzieHydrauliki;


    public void dodajLiniaProdukcyjna (
            String nazwaLinii,
            String producentLinii,
            String typLinii,
            String numerLinii,
            String dataProdukcji,
            String posiadaneCertyfikaty,
            // tego nie ma jeszcze w htmlu, do przemyslenia co  lista maszyn w linii
            //ArrayList<Maszyna> maszynay,

            // opis linii
            String opisLinii,
            // tego tez nie ma w htmlu
            //Zdjecie zdjecieLinii,

            String opisSystemuSterowania,
            // tego tez nie ma w htmlu
            //Zdjecie systemuSterowania,

            //Ograniczenia maszyny
            String srodowiskoPracy,
            String wymaganyPoziomSzkolenia,
            String liniaObslugiwanaPrzez,
            String przeznaczenieLinii,
            String przewidzianyCzasUzytkowania,
            String wymiaryMaszyny,
            String srodowiskoPracyMaszyny,

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
            String sprzatanie,

            //Zrodla energi
            String napiecieWUkladzieSterowania,
            String zasilanieGlowne,
            String cisnienieRoboczeWUkladziePneumatyki,
            String cisnienieRoboczeWUkladzieHydrauliki) {

        if (czyPodanoWartosc(nazwaLinii)) {
            this.nazwaLinii = nazwaLinii;
        }
        if (czyPodanoWartosc(producentLinii)) {
            this.producentLinii = producentLinii;
        }
        if (czyPodanoWartosc(typLinii)) {
            this.typLinii = typLinii;
        }
        if (czyPodanoWartosc(numerLinii)) {
            this.numerLinii = numerLinii;
        }
        if (czyPodanoWartosc(dataProdukcji)) {
            this.dataProdukcji = dataProdukcji;
        }
        if (czyPodanoWartosc(posiadaneCertyfikaty)) {
            this.posiadaneCertyfikaty = posiadaneCertyfikaty;
        }
        if (czyPodanoWartosc(opisLinii)) {
            this.opisLinii = opisLinii;
        }
        if (czyPodanoWartosc(opisSystemuSterowania)) {
            this.opisSystemuSterowania = opisSystemuSterowania;
        }
        if (czyPodanoWartosc(srodowiskoPracy)) {
            this.srodowiskoPracy = srodowiskoPracy;
        }
        if (czyPodanoWartosc(wymaganyPoziomSzkolenia)) {
            this.wymaganyPoziomSzkolenia = wymaganyPoziomSzkolenia;
        }
        if (czyPodanoWartosc(liniaObslugiwanaPrzez)) {
            this.liniaObslugiwanaPrzez = liniaObslugiwanaPrzez;
        }
        if (czyPodanoWartosc(przeznaczenieLinii)) {
            this.przeznaczenieLinii = przeznaczenieLinii;
        }
        if (czyPodanoWartosc(przewidzianyCzasUzytkowania)) {
            this.przewidzianyCzasUzytkowania = przewidzianyCzasUzytkowania;
        }
        if (czyPodanoWartosc(wymiaryMaszyny)) {
            this.wymiaryMaszyny = wymiaryMaszyny;
        }
        if (czyPodanoWartosc(srodowiskoPracyMaszyny)) {
            this.srodowiskoPracyMaszyny = srodowiskoPracyMaszyny;
        }
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
        if (czyPodanoWartosc(napiecieWUkladzieSterowania)) {
            this.napiecieWUkladzieSterowania = napiecieWUkladzieSterowania;
        }
        if (czyPodanoWartosc(zasilanieGlowne)) {
            this.zasilanieGlowne = zasilanieGlowne;
        }
        if (czyPodanoWartosc(cisnienieRoboczeWUkladziePneumatyki)) {
            this.cisnienieRoboczeWUkladziePneumatyki = cisnienieRoboczeWUkladziePneumatyki;
        }
        if (czyPodanoWartosc(cisnienieRoboczeWUkladzieHydrauliki)) {
            this.cisnienieRoboczeWUkladzieHydrauliki = cisnienieRoboczeWUkladzieHydrauliki;
        }
    }

    private boolean czyPodanoWartosc (String watsocSprawdzana){
        if (watsocSprawdzana==null || watsocSprawdzana.isEmpty()){
            return false;
        } else return true;

    }

    public String getNazwaLinii() {
        return nazwaLinii;
    }

    public String getProducentLinii() {
        return producentLinii;
    }

    public String getTypLinii() {
        return typLinii;
    }

    public String getNumerLinii() {
        return numerLinii;
    }

    public String getDataProdukcji() {
        return dataProdukcji;
    }

    public String getPosiadaneCertyfikaty() {
        return posiadaneCertyfikaty;
    }

    public ArrayList<Maszyna> getMaszynay() {
        return maszynay;
    }

    public String getOpisLinii() {
        return opisLinii;
    }

    public Zdjecie getZdjecieLinii() {
        return zdjecieLinii;
    }

    public String getOpisSystemuSterowania() {
        return opisSystemuSterowania;
    }

    public Zdjecie getSystemuSterowania() {
        return systemuSterowania;
    }

    public String getSrodowiskoPracy() {
        return srodowiskoPracy;
    }

    public String getWymaganyPoziomSzkolenia() {
        return wymaganyPoziomSzkolenia;
    }

    public String getLiniaObslugiwanaPrzez() {
        return liniaObslugiwanaPrzez;
    }

    public String getPrzeznaczenieLinii() {
        return przeznaczenieLinii;
    }

    public String getPrzewidzianyCzasUzytkowania() {
        return przewidzianyCzasUzytkowania;
    }

    public String getWymiaryMaszyny() {
        return wymiaryMaszyny;
    }

    public String getSrodowiskoPracyMaszyny() {
        return srodowiskoPracyMaszyny;
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

    public String getNapiecieWUkladzieSterowania() {
        return napiecieWUkladzieSterowania;
    }

    public String getZasilanieGlowne() {
        return zasilanieGlowne;
    }

    public String getCisnienieRoboczeWUkladziePneumatyki() {
        return cisnienieRoboczeWUkladziePneumatyki;
    }

    public String getCisnienieRoboczeWUkladzieHydrauliki() {
        return cisnienieRoboczeWUkladzieHydrauliki;
    }
}
