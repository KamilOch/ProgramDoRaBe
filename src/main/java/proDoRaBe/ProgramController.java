package proDoRaBe;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProgramController {

    Raport raport = new Raport (new DaneRaportu(), new LiniaProdukcyjna());



    @RequestMapping("/daneRaportu")
    public String DaneRaportu(
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

        raport.getDaneRaportu().dodajDaneRaportu(nazwaFirmy,adresFirmy, nazwaLinii,autorRaportu, telefonKontaktowyDoAutoraRaportu, adresEmailDoAutoraRaportu, osobaOdpowiedzialnaPoStronieZamawiajacejRaport, telefonKontaktowyDoOsobyOsobyOdpowiedzialnejPoStronieZamawiajacego, adresEmailDoOsobyOdpowiedzialnejPoStronieZamawiajacego );
/*
        model.addAttribute("nazwaFirmy", nazwaFirmy);
        model.addAttribute("adresFirmy",adresFirmy);
        model.addAttribute("nazwaLinii",nazwaLinii);
        model.addAttribute("autorRaportu",autorRaportu);
        model.addAttribute("telefonKontaktowyDoAutoraRaportu",telefonKontaktowyDoAutoraRaportu);
        model.addAttribute("adresEmailDoAutoraRaportu",adresEmailDoAutoraRaportu);
        model.addAttribute("osobaOdpowiedzialnaPoStronieZamawiajacejRaport",osobaOdpowiedzialnaPoStronieZamawiajacejRaport);
        model.addAttribute("telefonKontaktowyDoOsobyOsobyOdpowiedzialnejPoStronieZamawiajacego",telefonKontaktowyDoOsobyOsobyOdpowiedzialnejPoStronieZamawiajacego);
        model.addAttribute("adresEmailDoOsobyOdpowiedzialnejPoStronieZamawiajacego",adresEmailDoOsobyOdpowiedzialnejPoStronieZamawiajacego);
*/
        return "/daneRaportu_form";
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