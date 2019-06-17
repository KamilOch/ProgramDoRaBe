package proDoRaBe.ui;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import proDoRaBe.db.MachineRepository;
import proDoRaBe.model.Raport;
import proDoRaBe.model.*;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.io.UnsupportedEncodingException;


@Controller
public class ProgramController {

    public ProgramController(ReportService reportService, MachineService machineService) {
        this.reportService = reportService;
        this.machineService = machineService;
    }

    private final ReportService reportService;
    private final MachineService machineService;


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


    private static String encodeValue(String value) {
        try {
            return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException ex) {
            throw new RuntimeException(ex.getCause());
        }
    }

    @RequestMapping ("/usuwanieMaszyny")
    public String usuwanieMaszyny (
            @RequestParam(value = "wybranaMaszyna", required = false) String nazwaMaszyny,
            Model model
    ){
        machineService.delete(nazwaMaszyny);
        return "redirect:/listaMaszyn";
    }
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
        machineService.delete(nazwaMaszyny);
        Maszyna nowaMaszyna = new Maszyna (nazwaMaszyny,producentMaszyny, typMaszyny,numerMaszyny,dataProdukcji, posiadaneCertyfikaty);
        machineService.add(nazwaMaszyny,nowaMaszyna);

        return "redirect:/edytowanie?wybranaMaszyna="+nazwaMaszyny;
    }
    @RequestMapping("/edytowanie")
    public String edytowanie (
            @RequestParam(value = "wybranaMaszyna", required = false) String wybranaMaszyna,
            Model model
    ){
        //Maszyna mojaMaszyna = maszyny.get(wybranaMaszyna);
        Maszyna mojaMaszyna = machineService.get(wybranaMaszyna);
        if (mojaMaszyna != null) {
              model.addAttribute("maszyna", mojaMaszyna);
        }
        return "edycjaMaszyny_form";
    }
    @RequestMapping("/listaMaszyn")
    public String listaMaszyn (
            Model model
    ){
       // model.addAttribute("maszyny",maszyny.getAll());
        model.addAttribute("maszyny",machineService.getAll());

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
        Maszyna maszyna = new Maszyna(nazwaMaszyny,producentMaszyny,typMaszyny,numerMaszyny,dataProdukcji,posiadaneCertyfikaty);

        String wiadomosc = encodeValue(machineService.add(nazwaMaszyny,maszyna));

        return "redirect:/dodawanieMaszyny?nazwaMaszyny="+nazwaMaszyny+"&wiadomosc="+wiadomosc;
    }
    @RequestMapping ("/dodawanieMaszyny")
    public String dodawanieMaszyny (
            @RequestParam(value = "nazwaMaszyny", required = false) String nazwaMaszyny,
            @RequestParam(value = "wiadomosc", required = false) String wiadomosc,
            Model model
    ) {
        Maszyna mojaMaszyna = machineService.get(nazwaMaszyny);
        if (mojaMaszyna == null) {
            mojaMaszyna = new Maszyna("wprowadz dane", "wprowadz dane", "wprowadz dane", "wprowadz dane", "wprowadz dane", "wprowadz dane");
        }
        model.addAttribute("wiadomosc", wiadomosc);
        model.addAttribute("maszyna", mojaMaszyna);
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

    @RequestMapping("/raporty")
    public String raporty(
            Model model
    ){
        model.addAttribute("raporty", reportService.getAll());
        return "raporty";
    }

}