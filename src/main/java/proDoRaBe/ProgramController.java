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
    public String dodajDaneRaportu(
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
    public String dodawanie (
            Model model
    ) {
        model.addAttribute("tytulRaportu", daneDlaRaportu.getTytulRaportu());
        model.addAttribute("numerDokumentu",daneDlaRaportu.getNumerDokumentu());
        model.addAttribute("wersjaDokumentu",daneDlaRaportu.getWersjaDokumentu());
        model.addAttribute("dataDokumentu",daneDlaRaportu.getDataDokumentu());

        return "daneDlaRaportu_form";
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