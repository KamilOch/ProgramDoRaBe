package proDoRaBe.model;

import java.util.ArrayList;

public class LPOpisLinii {

    // opis linii
    private String opisLinii;
    // tego tez nie ma w htmlu
    private Zdjecie zdjecieLinii;
    //System sterowania
    private String opisSystemuSterowania;
    // tego tez nie ma w htmlu
    private Zdjecie systemuSterowania;
    //Zrodla energi
    private String napiecieWUkladzieSterowania;
    private String zasilanieGlowne;
    private String cisnienieRoboczeWUkladziePneumatyki;
    private String cisnienieRoboczeWUkladzieHydrauliki;

    public LPOpisLinii() {
    }

    public void dodajLPOpisLinii (

            // opis linii
            String opisLinii,
            // tego tez nie ma w htmlu
            //Zdjecie zdjecieLinii,

            String opisSystemuSterowania,
            // tego tez nie ma w htmlu
            //Zdjecie systemuSterowania,

            //Zrodla energi
            String napiecieWUkladzieSterowania,
            String zasilanieGlowne,
            String cisnienieRoboczeWUkladziePneumatyki,
            String cisnienieRoboczeWUkladzieHydrauliki) {


        if (czyPodanoWartosc(opisLinii)) {
            this.opisLinii = opisLinii;
        }
        if (czyPodanoWartosc(opisSystemuSterowania)) {
            this.opisSystemuSterowania = opisSystemuSterowania;
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
