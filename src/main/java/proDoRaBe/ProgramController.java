package proDoRaBe;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProgramController {

    DaneZamawiajacegoRaport daneZamawiajacegoRaport = new DaneZamawiajacegoRaport();
    DaneWykonujacegoRaport daneWykonujacegoRaport = new DaneWykonujacegoRaport();
    DaneDlaRaportu daneDlaRaportu = new DaneDlaRaportu();

    DaneRaportu daneRaportu = new DaneRaportu();
    LiniaProdukcyjna liniaProdukcyjna = new LiniaProdukcyjna();

    Raport raport = new Raport (daneRaportu, liniaProdukcyjna);



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