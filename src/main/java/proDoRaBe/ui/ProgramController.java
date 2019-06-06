package proDoRaBe.ui;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import proDoRaBe.model.Raport;
import proDoRaBe.model.*;

import java.util.ArrayList;

@Controller
public class ProgramController {

    private ListaMaszyn maszyny = new ListaMaszyn();

    DaneZamawiajacegoRaport daneZamawiajacegoRaport = new DaneZamawiajacegoRaport();
    DaneWykonujacegoRaport daneWykonujacegoRaport = new DaneWykonujacegoRaport();
    DaneDlaRaportu daneDlaRaportu = new DaneDlaRaportu();
    DaneRaportu daneRaportu = new DaneRaportu();

    // nowe podklasy linii produkcyjnej!!
    LPPodstawoweDaneLinii lpPodstawoweDaneLinii = new LPPodstawoweDaneLinii();
    LPOpisLinii lPOpisLinii = new LPOpisLinii();
    LPOgraniczeniaMaszyny lPOgraniczeniaMaszyny = new LPOgraniczeniaMaszyny();
    LPInformacjeOObsludzeIKonserwacji lPInformacjeOObsludzeIKonserwacji = new LPInformacjeOObsludzeIKonserwacji();

    LiniaProdukcyjna liniaProdukcyjna = new LiniaProdukcyjna();

    Raport raport = new Raport (daneRaportu, liniaProdukcyjna);


/*
    void tworzenieMaszynyWMapie (String nazwa, String nazwaMaszyny, String producentMaszyny, String typMaszyny, String numerMaszyny, String dataProdukcji, String posiadaneCertyfikaty){
        String zmienna = nazwa;
        maszyny.dodajMaszyne(zmienna, new Maszyna(nazwaMaszyny,producentMaszyny,typMaszyny,numerMaszyny, dataProdukcji,posiadaneCertyfikaty));
    }
*/

    @RequestMapping("/edytowanieMaszyny")
    public String edytowanieMaszyny (
            @RequestParam(value = "nazwaMaszyny", required = false) String nazwaMaszyny,
            @RequestParam(value = "producentMaszyny", required = false) String  producentMaszyny,
            @RequestParam(value = "typMaszyny", required = false) String typMaszyny,
            @RequestParam(value = "numerMaszyny", required = false) String numerMaszyny,
            @RequestParam(value = "dataProdukcji", required = false) String dataProdukcji,
            @RequestParam(value = "posiadaneCertyfikaty", required = false) String posiadaneCertyfikaty,
            Model model
    ){
        Maszyna mojaMaszyna = maszyny.podajMaszyny(nazwaMaszyny);

        return "/listaMaszyn";
    }

    @RequestMapping("/edytowanie")
    public String edytowanie (
            @RequestParam(value = "wybranaMaszyna", required = false) String wybranaMaszyna,
            Model model
    ){
        Maszyna mojaMaszyna = maszyny.podajMaszyny(wybranaMaszyna);
        if (mojaMaszyna != null) {
            model.addAttribute("nazwaMaszyny", mojaMaszyna.getNazwaMaszyny());
            model.addAttribute("producentMaszyny", mojaMaszyna.getProducentMaszyny());
            model.addAttribute("typMaszyny", mojaMaszyna.getTypMaszyny());
            model.addAttribute("numerMaszyny", mojaMaszyna.getNumerMaszyny());
            model.addAttribute("dataProdukcji", mojaMaszyna.getDataProdukcji());
            model.addAttribute("posiadaneCertyfikaty", mojaMaszyna.getPosiadaneCertyfikaty());
        }
        return "edycjaMaszyny_form";
    }







    @RequestMapping("/listaMaszyn")
    public String listaMaszyn (

            Model model
    ){
        model.addAttribute("maszyny",maszyny.podajNazwyMaszyn());

        return "listaMaszyn_form";
    }


    @RequestMapping("/dodajMaszyne")
    public String dodajMaszyne(
            @RequestParam(value = "nazwaMaszyny", required = false) String nazwaMaszyny,
            @RequestParam(value = "producentMaszyny", required = false) String  producentMaszyny,
            @RequestParam(value = "typMaszyny", required = false) String typMaszyny,
            @RequestParam(value = "numerMaszyny", required = false) String numerMaszyny,
            @RequestParam(value = "dataProdukcji", required = false) String dataProdukcji,
            @RequestParam(value = "posiadaneCertyfikaty", required = false) String posiadaneCertyfikaty,
            Model model
    ) {

        // linia kodu 45 nie dziala, trzeba zmienic
       // maszyny.dodajMaszyne(nazwaMaszyny, new Maszyna(nazwaMaszyny,producentMaszyny,typMaszyny,numerMaszyny,dataProdukcji,posiadaneCertyfikaty));
        Maszyna maszyna = new Maszyna(nazwaMaszyny,producentMaszyny,typMaszyny,numerMaszyny,dataProdukcji,posiadaneCertyfikaty);
        maszyny.dodajMaszyne(nazwaMaszyny,maszyna);
        return "redirect:/dodawanieMaszyny?nazwaMaszyny="+nazwaMaszyny;
    }

    @RequestMapping ("/dodawanieMaszyny")
    public String dodawanieMaszyny (
            @RequestParam(value = "nazwaMaszyny", required = false) String nazwaMaszyny,
            Model model
    ) {
        Maszyna mojaMaszyna = maszyny.podajMaszyny(nazwaMaszyny);
        if (mojaMaszyna != null) {
            model.addAttribute("nazwaMaszyny", mojaMaszyna.getNazwaMaszyny());
            model.addAttribute("producentMaszyny", mojaMaszyna.getProducentMaszyny());
            model.addAttribute("typMaszyny", mojaMaszyna.getTypMaszyny());
            model.addAttribute("numerMaszyny", mojaMaszyna.getNumerMaszyny());
            model.addAttribute("dataProdukcji", mojaMaszyna.getDataProdukcji());
            model.addAttribute("posiadaneCertyfikaty", mojaMaszyna.getPosiadaneCertyfikaty());
        }
        return "daneMaszyny_form";
    }
    @RequestMapping("/dodajLPPDL")
    public String dodajLPPDL(
            @RequestParam(value = "nazwaLinii", required = false) String nazwaLinii,
            @RequestParam(value = "producentLinii", required = false) String producentLinii,
            @RequestParam(value = "typLinii", required = false) String typLinii,
            @RequestParam(value = "numerLinii", required = false) String numerLinii,
            @RequestParam(value = "dataProdukcji", required = false) String dataProdukcji,
            @RequestParam(value = "posiadaneCertyfikaty", required = false) String posiadaneCertyfikaty,
            // brak listy maszyn
            Model model
    ) {
        lpPodstawoweDaneLinii.dodajLPPodstawoweDaneLinii(nazwaLinii, producentLinii, typLinii, numerLinii, dataProdukcji, posiadaneCertyfikaty);
        return "redirect:/dodawanieLPPDL";
    }
    @RequestMapping ("/dodawanieLPPDL")
    public String dodawanieLPPDL (
            Model model
    ) {
        model.addAttribute("nazwaLinii", lpPodstawoweDaneLinii.getNazwaLinii());
        model.addAttribute("producentLinii",lpPodstawoweDaneLinii.getProducentLinii());
        model.addAttribute("typLinii",lpPodstawoweDaneLinii.getTypLinii());
        model.addAttribute("numerLinii",lpPodstawoweDaneLinii.getNumerLinii());
        model.addAttribute("dataProdukcji", lpPodstawoweDaneLinii.getDataProdukcji());
        model.addAttribute("posiadaneCertyfikaty",lpPodstawoweDaneLinii.getPosiadaneCertyfikaty());

        return "daneLPPDL_form";
    }

    @RequestMapping("/dodajLPOpisLinii")
    public String dodajLPOpisLinii(

            @RequestParam(value = "opisLinii", required = false) String opisLinii,
            // brak zdjecia linii
            @RequestParam(value = "opisSystemuSterowania", required = false) String opisSystemuSterowania,
            // brak zdjecia sterowania
            @RequestParam(value = "napiecieWUkladzieSterowania", required = false) String  napiecieWUkladzieSterowania,
            @RequestParam(value = "zasilanieGlowne", required = false) String  zasilanieGlowne,
            @RequestParam(value = "cisnienieRoboczeWUkladziePneumatyki", required = false) String  cisnienieRoboczeWUkladziePneumatyki,
            @RequestParam(value = "cisnienieRoboczeWUkladzieHydrauliki", required = false) String  cisnienieRoboczeWUkladzieHydrauliki,
            Model model
    ) {
        lPOpisLinii.dodajLPOpisLinii(opisLinii,opisSystemuSterowania,napiecieWUkladzieSterowania, zasilanieGlowne, cisnienieRoboczeWUkladziePneumatyki,
                cisnienieRoboczeWUkladzieHydrauliki);
        return "redirect:/dodawanieLPOpisLinii";
    }
    @RequestMapping ("/dodawanieLPOpisLinii")
    public String dodawanieLPOpisLinii (
            Model model
    ) {
        model.addAttribute("opisLinii",lPOpisLinii.getOpisLinii());
        model.addAttribute("opisSystemuSterowania",lPOpisLinii.getOpisSystemuSterowania());
        model.addAttribute("napiecieWUkladzieSterowania", lPOpisLinii.getNapiecieWUkladzieSterowania());
        model.addAttribute("zasilanieGlowne",lPOpisLinii.getZasilanieGlowne());
        model.addAttribute("cisnienieRoboczeWUkladziePneumatyki",lPOpisLinii.getCisnienieRoboczeWUkladziePneumatyki());
        model.addAttribute("cisnienieRoboczeWUkladzieHydrauliki",lPOpisLinii.getCisnienieRoboczeWUkladzieHydrauliki());

        return "daneLPOL_form";
    }

    @RequestMapping("/dodajLPOgraniczeniaMaszyny")
    public String dodajLPOgraniczeniaMaszyny(
            @RequestParam(value = "srodowiskoPracy", required = false) String srodowiskoPracy,
            @RequestParam(value = "wymaganyPoziomSzkolenia", required = false) String wymaganyPoziomSzkolenia,
            @RequestParam(value = "liniaObslugiwanaPrzez", required = false) String liniaObslugiwanaPrzez,
            @RequestParam(value = "przeznaczenieLinii", required = false) String przeznaczenieLinii,
            @RequestParam(value = "przewidzianyCzasUzytkowania", required = false) String przewidzianyCzasUzytkowania,
            @RequestParam(value = "wymiaryMaszyny", required = false) String wymiaryMaszyny,
            @RequestParam(value = "srodowiskoPracyMaszyny", required = false) String srodowiskoPracyMaszyny,
            Model model
    ) {
        lPOgraniczeniaMaszyny.dodajLPOgraniczeniaMaszyny(srodowiskoPracy, wymaganyPoziomSzkolenia, liniaObslugiwanaPrzez, przeznaczenieLinii,
                przewidzianyCzasUzytkowania, wymiaryMaszyny, srodowiskoPracyMaszyny);
        return "redirect:/dodawanieLPOgraniczeniaMaszyny";
    }
    @RequestMapping ("/dodawanieLPOgraniczeniaMaszyny")
    public String dodawanieLPOgraniczeniaMaszyny (
            Model model
    ) {
        model.addAttribute("srodowiskoPracy", lPOgraniczeniaMaszyny.getSrodowiskoPracy());
        model.addAttribute("wymaganyPoziomSzkolenia",lPOgraniczeniaMaszyny.getWymaganyPoziomSzkolenia());
        model.addAttribute("liniaObslugiwanaPrzez",lPOgraniczeniaMaszyny.getLiniaObslugiwanaPrzez());
        model.addAttribute("przeznaczenieLinii",lPOgraniczeniaMaszyny.getPrzeznaczenieLinii());
        model.addAttribute("przewidzianyCzasUzytkowania", lPOgraniczeniaMaszyny.getPrzewidzianyCzasUzytkowania());
        model.addAttribute("czasCykluMaszyny",lPOgraniczeniaMaszyny.getWymiaryMaszyny());
        model.addAttribute("srodowiskoPracyMaszyny",lPOgraniczeniaMaszyny.getSrodowiskoPracyMaszyny());

        return "daneLPOM_form";
    }

    @RequestMapping("/dodajLPInformacjeOObsludzeIKonserwacji")
    public String dodajLPInformacjeOObsludzeIKonserwacji(

            @RequestParam(value = "surowiecDoProdukcji", required = false) String surowiecDoProdukcji,
            @RequestParam(value = "czasZatrzymaniaAwaryjnego", required = false) String czasZatrzymaniaAwaryjnego,
            @RequestParam(value = "czasCykluMaszyny", required = false) String czasCykluMaszyny,
            @RequestParam(value = "liczbaOperatorow", required = false) String liczbaOperatorow,
            @RequestParam(value = "iloscStacjiOperatorskich", required = false) String iloscStacjiOperatorskich,
            @RequestParam(value = "konserwacjaWykonywanaPrzez", required = false) String konserwacjaWykonywanaPrzez,
            @RequestParam(value = "czestotliwoscKonserwacji", required = false) String czestotliwoscKonserwacji,
            @RequestParam(value = "czyszczenie", required = false) String czyszczenie,
            @RequestParam(value = "naprawaZaciec", required = false) String naprawaZaciec,
            @RequestParam(value = "sprzatanie", required = false) String sprzatanie,
            Model model
    ) {
        lPInformacjeOObsludzeIKonserwacji.dodajLPInformacjeOObsludzeIKonserwacji(surowiecDoProdukcji, czasZatrzymaniaAwaryjnego,
                czasCykluMaszyny, liczbaOperatorow, iloscStacjiOperatorskich, konserwacjaWykonywanaPrzez, czestotliwoscKonserwacji,
                czyszczenie, naprawaZaciec, sprzatanie);
        return "redirect:/dodawanieLPInformacjeOObsludzeIKonserwacji";
    }

    @RequestMapping ("/dodawanieLPInformacjeOObsludzeIKonserwacji")
    public String dodawanieLPInformacjeOObsludzeIKonserwacji (
            Model model
    ) {
        model.addAttribute("surowiecDoProdukcji",lPInformacjeOObsludzeIKonserwacji.getSurowiecDoProdukcji());
        model.addAttribute("czasZatrzymaniaAwaryjnego", lPInformacjeOObsludzeIKonserwacji.getCzasZatrzymaniaAwaryjnego());
        model.addAttribute("liczbaOperatorow",lPInformacjeOObsludzeIKonserwacji.getLiczbaOperatorow());
        model.addAttribute("iloscStacjiOperatorskich",lPInformacjeOObsludzeIKonserwacji.getIloscStacjiOperatorskich());
        model.addAttribute("konserwacjaWykonywanaPrzez",lPInformacjeOObsludzeIKonserwacji.getKonserwacjaWykonywanaPrzez());
        model.addAttribute("czestotliwoscKonserwacji", lPInformacjeOObsludzeIKonserwacji.getCzestotliwoscKonserwacji());
        model.addAttribute("czyszczenie",lPInformacjeOObsludzeIKonserwacji.getCzyszczenie());
        model.addAttribute("naprawaZaciec",lPInformacjeOObsludzeIKonserwacji.getNaprawaZaciec());
        model.addAttribute("sprzatanie",lPInformacjeOObsludzeIKonserwacji.getSprzatanie());

        return "daneLPIOOIK_form";
    }

/*
    // TO CHYBA BEDE WYWALAL / ZMIENIAL !!!!!! POCZATEK

    @RequestMapping("/dodajPodstawoweDaneLiniiMaszyny")
    public String dodajPodstawoweDaneLiniiMaszyny(
            @RequestParam(value = "nazwaLinii", required = false) String nazwaLinii,
            @RequestParam(value = "producentLinii", required = false) String producentLinii,
            @RequestParam(value = "typLinii", required = false) String typLinii,
            @RequestParam(value = "numerLinii", required = false) String numerLinii,
            @RequestParam(value = "dataProdukcji", required = false) String dataProdukcji,
            @RequestParam(value = "posiadaneCertyfikaty", required = false) String posiadaneCertyfikaty,
            // brak listy maszyn
            @RequestParam(value = "opisLinii", required = false) String opisLinii,
            // brak zdjecia linii
            @RequestParam(value = "opisSystemuSterowania", required = false) String opisSystemuSterowania,
            // brak zdjecia sterowania
            @RequestParam(value = "srodowiskoPracy", required = false) String srodowiskoPracy,
            @RequestParam(value = "wymaganyPoziomSzkolenia", required = false) String wymaganyPoziomSzkolenia,
            @RequestParam(value = "liniaObslugiwanaPrzez", required = false) String liniaObslugiwanaPrzez,
            @RequestParam(value = "przeznaczenieLinii", required = false) String przeznaczenieLinii,
            @RequestParam(value = "przewidzianyCzasUzytkowania", required = false) String przewidzianyCzasUzytkowania,
            @RequestParam(value = "wymiaryMaszyny", required = false) String wymiaryMaszyny,
            @RequestParam(value = "srodowiskoPracyMaszyny", required = false) String srodowiskoPracyMaszyny,
            @RequestParam(value = "surowiecDoProdukcji", required = false) String surowiecDoProdukcji,
            @RequestParam(value = "czasZatrzymaniaAwaryjnego", required = false) String czasZatrzymaniaAwaryjnego,
            @RequestParam(value = "czasCykluMaszyny", required = false) String czasCykluMaszyny,
            @RequestParam(value = "liczbaOperatorow", required = false) String liczbaOperatorow,
            @RequestParam(value = "iloscStacjiOperatorskich", required = false) String iloscStacjiOperatorskich,
            @RequestParam(value = "konserwacjaWykonywanaPrzez", required = false) String konserwacjaWykonywanaPrzez,
            @RequestParam(value = "czestotliwoscKonserwacji", required = false) String czestotliwoscKonserwacji,
            @RequestParam(value = "czyszczenie", required = false) String czyszczenie,
            @RequestParam(value = "naprawaZaciec", required = false) String naprawaZaciec,
            @RequestParam(value = "sprzatanie", required = false) String sprzatanie,
            @RequestParam(value = "napiecieWUkladzieSterowania", required = false) String  napiecieWUkladzieSterowania,
            @RequestParam(value = "zasilanieGlowne", required = false) String  zasilanieGlowne,
            @RequestParam(value = "cisnienieRoboczeWUkladziePneumatyki", required = false) String  cisnienieRoboczeWUkladziePneumatyki,
            @RequestParam(value = "cisnienieRoboczeWUkladzieHydrauliki", required = false) String  cisnienieRoboczeWUkladzieHydrauliki,
            Model model
    ) {
       liniaProdukcyjna.dodajLiniaProdukcyjna(nazwaLinii, producentLinii, typLinii, numerLinii, dataProdukcji, posiadaneCertyfikaty,
               opisLinii, opisSystemuSterowania, srodowiskoPracy, wymaganyPoziomSzkolenia, liniaObslugiwanaPrzez, przeznaczenieLinii,
               przewidzianyCzasUzytkowania, wymiaryMaszyny, srodowiskoPracyMaszyny, surowiecDoProdukcji, czasZatrzymaniaAwaryjnego,
               czasCykluMaszyny, liczbaOperatorow, iloscStacjiOperatorskich, konserwacjaWykonywanaPrzez, czestotliwoscKonserwacji,
               czyszczenie, naprawaZaciec, sprzatanie, napiecieWUkladzieSterowania, zasilanieGlowne, cisnienieRoboczeWUkladziePneumatyki,
               cisnienieRoboczeWUkladzieHydrauliki);
        return "redirect:/dodawaniePodstawoweDaneLiniiMaszyny";
    }

    @RequestMapping ("/dodawaniePodstawoweDaneLiniiMaszyny")
    public String dodawaniePodstawoweDaneLiniiMaszyny (
            Model model
    ) {
        model.addAttribute("nazwaLinii", liniaProdukcyjna.getNazwaLinii());
        model.addAttribute("producentLinii",liniaProdukcyjna.getProducentLinii());
        model.addAttribute("typLinii",liniaProdukcyjna.getTypLinii());
        model.addAttribute("numerLinii",liniaProdukcyjna.getNumerLinii());

        model.addAttribute("dataProdukcji", liniaProdukcyjna.getDataProdukcji());
        model.addAttribute("posiadaneCertyfikaty",liniaProdukcyjna.getPosiadaneCertyfikaty());
        model.addAttribute("opisLinii",liniaProdukcyjna.getOpisLinii());
        model.addAttribute("opisSystemuSterowania",liniaProdukcyjna.getOpisSystemuSterowania());

        model.addAttribute("srodowiskoPracy", liniaProdukcyjna.getSrodowiskoPracy());
        model.addAttribute("wymaganyPoziomSzkolenia",liniaProdukcyjna.getWymaganyPoziomSzkolenia());
        model.addAttribute("liniaObslugiwanaPrzez",liniaProdukcyjna.getLiniaObslugiwanaPrzez());
        model.addAttribute("przeznaczenieLinii",liniaProdukcyjna.getPrzeznaczenieLinii());

        model.addAttribute("przewidzianyCzasUzytkowania", liniaProdukcyjna.getPrzewidzianyCzasUzytkowania());
        model.addAttribute("czasCykluMaszyny",liniaProdukcyjna.getCzasCykluMaszyny());
        model.addAttribute("srodowiskoPracyMaszyny",liniaProdukcyjna.getSrodowiskoPracyMaszyny());
        model.addAttribute("surowiecDoProdukcji",liniaProdukcyjna.getSurowiecDoProdukcji());

        model.addAttribute("czasZatrzymaniaAwaryjnego", liniaProdukcyjna.getCzasZatrzymaniaAwaryjnego());
        model.addAttribute("liczbaOperatorow",liniaProdukcyjna.getLiczbaOperatorow());
        model.addAttribute("iloscStacjiOperatorskich",liniaProdukcyjna.getIloscStacjiOperatorskich());
        model.addAttribute("konserwacjaWykonywanaPrzez",liniaProdukcyjna.getKonserwacjaWykonywanaPrzez());

        model.addAttribute("czestotliwoscKonserwacji", liniaProdukcyjna.getCzestotliwoscKonserwacji());
        model.addAttribute("czyszczenie",liniaProdukcyjna.getCzyszczenie());
        model.addAttribute("naprawaZaciec",liniaProdukcyjna.getNaprawaZaciec());
        model.addAttribute("sprzatanie",liniaProdukcyjna.getSprzatanie());

        model.addAttribute("napiecieWUkladzieSterowania", liniaProdukcyjna.getNapiecieWUkladzieSterowania());
        model.addAttribute("zasilanieGlowne",liniaProdukcyjna.getZasilanieGlowne());
        model.addAttribute("cisnienieRoboczeWUkladziePneumatyki",liniaProdukcyjna.getCisnienieRoboczeWUkladziePneumatyki());
        model.addAttribute("cisnienieRoboczeWUkladzieHydrauliki",liniaProdukcyjna.getCisnienieRoboczeWUkladzieHydrauliki());

        return "danePodstawoweLiniiMaszyny_form";
    }
    // TO CHYBA BEDE WYWALAL / ZMIENIAL !!!!!! KONIEC
*/
    @RequestMapping("/dodajDaneDlaRaportu")
    public String dodajDaneDlaRaportu(
            @RequestParam(value = "tytulRaportu", required = false) String tytulRaportu,
            @RequestParam(value = "numerDokumentu", required = false) String  numerDokumentu,
            @RequestParam(value = "wersjaDokumentu", required = false) String wersjaDokumentu,
            @RequestParam(value = "dataDokumentu", required = false) String dataDokumentu,
            Model model
    ) {
        daneDlaRaportu.dodajDaneDlaRaportu(tytulRaportu, numerDokumentu, wersjaDokumentu, dataDokumentu );
        return "redirect:/dodawanieDanychDlaRaportu";
    }

    @RequestMapping ("/dodawanieDanychDlaRaportu")
    public String dodawanieDanychDlaRaportu (
            Model model
    ) {
        model.addAttribute("tytulRaportu", daneDlaRaportu.getTytulRaportu());
        model.addAttribute("numerDokumentu",daneDlaRaportu.getNumerDokumentu());
        model.addAttribute("wersjaDokumentu",daneDlaRaportu.getWersjaDokumentu());
        model.addAttribute("dataDokumentu",daneDlaRaportu.getDataDokumentu());

        return "daneDlaRaportu_form";
    }

    @RequestMapping("/dodajDaneWykonujacegoRaport")
    public String dodajDaneWykonujacegoRaport(
            @RequestParam(value = "nazwaFirmy", required = false) String nazwaFirmy,
            @RequestParam(value = "adresFirmy", required = false) String  adresFirmy,
            @RequestParam(value = "adresEmjlowyFirmy", required = false) String adresEmjlowyFirmy,
            @RequestParam(value = "autorRaportu", required = false) String autorRaportu,
            @RequestParam(value = "telefonKontaktowyDoAutoraRaportu", required = false) String telefonKontaktowyDoAutoraRaportu,
            @RequestParam(value = "adresEmailDoAutoraRaportu", required = false) String adresEmailDoAutoraRaportu,
            @RequestParam(value = "osobaZatwierdzajacaRaport", required = false) String osobaZatwierdzajacaRaport,
            @RequestParam(value = "osobaKontaktowaWSprawieRaportu", required = false) String osobaKontaktowaWSprawieRaportu,
            @RequestParam(value = "telefonKontaktowyDoOsobyWSprawieRaportu", required = false) String telefonKontaktowyDoOsobyWSprawieRaportu,
            @RequestParam(value = "adresEmailDoOsobyWSprawieRaportu", required = false) String adresEmailDoOsobyWSprawieRaportu,
            Model model
    ) {
        daneWykonujacegoRaport.dodajDaneWykonujacegoRaport(nazwaFirmy, adresFirmy, adresEmjlowyFirmy, autorRaportu,telefonKontaktowyDoAutoraRaportu,adresEmailDoAutoraRaportu, osobaZatwierdzajacaRaport, osobaKontaktowaWSprawieRaportu, telefonKontaktowyDoOsobyWSprawieRaportu, adresEmailDoOsobyWSprawieRaportu);
        return "redirect:/dodawanieDanychWykonujacegoRaport";
    }

    @RequestMapping ("/dodawanieDanychWykonujacegoRaport")
    public String dodawanieDanychWykonujacegoRaport (
            Model model
    ) {
        model.addAttribute("nazwaFirmy", daneWykonujacegoRaport.getNazwaFirmy());
        model.addAttribute("adresFirmy",daneWykonujacegoRaport.getAdresFirmy());
        model.addAttribute("adresEmjlowyFirmy",daneWykonujacegoRaport.getAdresEmjlowyFirmy());
        model.addAttribute("autorRaportu",daneWykonujacegoRaport.getAutorRaportu());
        model.addAttribute("telefonKontaktowyDoAutoraRaportu",daneWykonujacegoRaport.getTelefonKontaktowyDoAutoraRaportu());
        model.addAttribute("adresEmailDoAutoraRaportu",daneWykonujacegoRaport.getAdresEmailDoAutoraRaportu());
        model.addAttribute("osobaZatwierdzajacaRaport",daneWykonujacegoRaport.getOsobaZatwierdzajacaRaport());
        model.addAttribute("osobaKontaktowaWSprawieRaportu",daneWykonujacegoRaport.getOsobaKontaktowaWSprawieRaportu());
        model.addAttribute("telefonKontaktowyDoOsobyWSprawieRaportu",daneWykonujacegoRaport.getTelefonKontaktowyDoOsobyWSprawieRaportu());
        model.addAttribute("adresEmailDoOsobyWSprawieRaportu",daneWykonujacegoRaport.getAdresEmailDoOsobyWSprawieRaportu());

        return "daneWykonujacegoRaport_form";
    }

    @RequestMapping("/dodajDaneZamawiajacegoRaport")
    public String dodajDaneZamawiajacegoRaport(
            @RequestParam(value = "nazwaFirmy", required = false) String nazwaFirmy,
            @RequestParam(value = "adresFirmy", required = false) String  adresFirmy,
            @RequestParam(value = "adresEmjlowyFirmy", required = false) String adresEmjlowyFirmy,
            @RequestParam(value = "telefonKontaktowyFirmy", required = false) String telefonKontaktowyFirmy,
            @RequestParam(value = "osobaOdpowiedzialnaPoStronieZamawiajacejRaport", required = false) String osobaOdpowiedzialnaPoStronieZamawiajacejRaport,
            @RequestParam(value = "telefonKontaktowyDoOsobyOsobyOdpowiedzialnejPoStronieZamawiajacego", required = false) String telefonKontaktowyDoOsobyOsobyOdpowiedzialnejPoStronieZamawiajacego,
            @RequestParam(value = "adresEmailDoOsobyOdpowiedzialnejPoStronieZamawiajacego", required = false) String adresEmailDoOsobyOdpowiedzialnejPoStronieZamawiajacego,
            Model model
    ) {
        daneZamawiajacegoRaport.dodajDaneZamawiajacegoRaport(nazwaFirmy, adresFirmy, adresEmjlowyFirmy, telefonKontaktowyFirmy, osobaOdpowiedzialnaPoStronieZamawiajacejRaport, telefonKontaktowyDoOsobyOsobyOdpowiedzialnejPoStronieZamawiajacego, adresEmailDoOsobyOdpowiedzialnejPoStronieZamawiajacego);
        return "redirect:/dodawanieDaneZamawiajacegoRaport";
    }

    @RequestMapping ("/dodawanieDaneZamawiajacegoRaport")
    public String dodawanieDaneZamawiajacegoRaport (
            Model model
    ) {
        model.addAttribute("nazwaFirmy", daneZamawiajacegoRaport.getNazwaFirmy());
        model.addAttribute("adresFirmy",daneZamawiajacegoRaport.getAdresFirmy());
        model.addAttribute("adresEmjlowyFirmy",daneZamawiajacegoRaport.getAdresEmjlowyFirmy());
        model.addAttribute("telefonKontaktowyFirmy",daneZamawiajacegoRaport.getTelefonKontaktowyFirmy());
        model.addAttribute("osobaOdpowiedzialnaPoStronieZamawiajacejRaport",daneZamawiajacegoRaport.getOsobaOdpowiedzialnaPoStronieZamawiajacejRaport());
        model.addAttribute("telefonKontaktowyDoOsobyOsobyOdpowiedzialnejPoStronieZamawiajacego",daneZamawiajacegoRaport.getTelefonKontaktowyDoOsobyOsobyOdpowiedzialnejPoStronieZamawiajacego());
        model.addAttribute("adresEmailDoOsobyOdpowiedzialnejPoStronieZamawiajacego",daneZamawiajacegoRaport.getAdresEmailDoOsobyOdpowiedzialnejPoStronieZamawiajacego());

        return "daneZamawiajacegoRaport_form";
    }

    @RequestMapping("/pierwszaStrona_form")
    public String StronaPoczatkowa() {
        return "redirect:/pierwszaStrona_form";
    }

    @RequestMapping("/")
    public String pierwszaStrona() {
        return "pierwszaStrona_form";
    }

}