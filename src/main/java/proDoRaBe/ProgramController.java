package proDoRaBe;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProgramController {


    @RequestMapping("/")
    public String pierwszaStrona() {
        return "pierwszaStrona_form";
    }

}