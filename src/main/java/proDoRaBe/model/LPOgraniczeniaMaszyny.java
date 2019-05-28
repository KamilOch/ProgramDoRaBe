package proDoRaBe.model;

import java.util.ArrayList;

public class LPOgraniczeniaMaszyny {


    //Ograniczenia maszyny
    private String srodowiskoPracy;
    private String wymaganyPoziomSzkolenia;
    private String liniaObslugiwanaPrzez;
    private String przeznaczenieLinii;
    private String przewidzianyCzasUzytkowania;
    private String wymiaryMaszyny;
    private String srodowiskoPracyMaszyny;

    public LPOgraniczeniaMaszyny() {
    }


    public void dodajLPOgraniczeniaMaszyny (

            //Ograniczenia maszyny
            String srodowiskoPracy,
            String wymaganyPoziomSzkolenia,
            String liniaObslugiwanaPrzez,
            String przeznaczenieLinii,
            String przewidzianyCzasUzytkowania,
            String wymiaryMaszyny,
            String srodowiskoPracyMaszyny

          ) {

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
    }

    private boolean czyPodanoWartosc (String watsocSprawdzana){
        if (watsocSprawdzana==null || watsocSprawdzana.isEmpty()){
            return false;
        } else return true;
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

}
