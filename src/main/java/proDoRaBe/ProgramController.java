package proDoRaBe;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProgramController {

    DaneRaportu daneRaportu = new DaneRaportu();
    LiniaProdukcyjna liniaProdukcyjna = new LiniaProdukcyjna();
    Raport raport = new Raport (daneRaportu, liniaProdukcyjna);



    @RequestMapping("/dodajDaneRaportu")
    public String dodajDaneRaportu(
            @RequestParam(value = "nazwaFirmy", required = false) String nazwaFirmy,
            @RequestParam(value = "adresFirmy", required = false) String  adresFirmy,
            @RequestParam(value = "nazwaLinii", required = false) String nazwaLinii,
            @RequestParam(value = "autorRaportu", required = false) String autorRaportu,
            @RequestParam(value = "telefonKontaktowyDoAutoraRaportu", required = false) String telefonKontaktowyDoAutoraRaportu,
            @RequestParam(value = "adresEmailDoAutoraRaportu", required = false) String adresEmailDoAutoraRaportu,
            @RequestParam(value = "osobaOdpowiedzialnaPoStronieZamawiajacejRaport", required = false) String osobaOdpowiedzialnaPoStronieZamawiajacejRaport,
            @RequestParam(value = "telefonKontaktowyDoOsobyOsobyOdpowiedzialnejPoStronieZamawiajacego", required = false) String telefonKontaktowyDoOsobyOsobyOdpowiedzialnejPoStronieZamawiajacego,
            @RequestParam(value = "adresEmailDoOsobyOdpowiedzialnejPoStronieZamawiajacego", required = false) String adresEmailDoOsobyOdpowiedzialnejPoStronieZamawiajacego,
            Model model
    ) {

        daneRaportu.dodajDaneRaportu(nazwaFirmy,adresFirmy, nazwaLinii,autorRaportu, telefonKontaktowyDoAutoraRaportu, adresEmailDoAutoraRaportu, osobaOdpowiedzialnaPoStronieZamawiajacejRaport, telefonKontaktowyDoOsobyOsobyOdpowiedzialnejPoStronieZamawiajacego, adresEmailDoOsobyOdpowiedzialnejPoStronieZamawiajacego );

        return "redirect:/dodawanie";
    }

    @RequestMapping ("/dodawanie")
    public String dodawanie (
            Model model
    ) {
        model.addAttribute("nazwaFirmy", daneRaportu.getNazwaFirmy());
        model.addAttribute("adresFirmy",daneRaportu.getAdresFirmy());
        model.addAttribute("nazwaLinii",daneRaportu.getNazwaLinii());
        model.addAttribute("autorRaportu",daneRaportu.getAutorRaportu());
        model.addAttribute("telefonKontaktowyDoAutoraRaportu",daneRaportu.getTelefonKontaktowyDoAutoraRaportu());
        model.addAttribute("adresEmailDoAutoraRaportu",daneRaportu.getAdresEmailDoAutoraRaportu());
        model.addAttribute("osobaOdpowiedzialnaPoStronieZamawiajacejRaport",daneRaportu.getOsobaOdpowiedzialnaPoStronieZamawiajacejRaport());
        model.addAttribute("telefonKontaktowyDoOsobyOsobyOdpowiedzialnejPoStronieZamawiajacego",daneRaportu.getTelefonKontaktowyDoOsobyOsobyOdpowiedzialnejPoStronieZamawiajacego());
        model.addAttribute("adresEmailDoOsobyOdpowiedzialnejPoStronieZamawiajacego",daneRaportu.getAdresEmailDoOsobyOdpowiedzialnejPoStronieZamawiajacego());

        return "daneRaportu_form";
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