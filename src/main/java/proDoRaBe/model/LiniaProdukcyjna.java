package proDoRaBe.model;

import java.util.ArrayList;

public class LiniaProdukcyjna {

    private String nazwaLinii;
    private String producentLinii;
    private String typLinii;
    private String numerLinii;
    private String dataProdukcji;
    private String posiadaneCertyfikaty;
    private ArrayList<Maszyna> maszynay;

    // opis linii
    private String opisLinii;
    private Zdjecie zdjecieLinii;
    private String opisSystemuSterowania;
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

}
