package proDoRaBe;

import java.util.HashMap;
import java.util.Map;

public class StopienMozliwychObrazen {

    private String opis;
    private float wspolczynnik;


    private Map<String, float> listaMozliwychObrazen = new HashMap<>();


    public Map<String, float> getListaMozliwychObrazen() {
        listaMozliwychObrażen.put("Zadrapanie / Stłuczenie", 0.25);
        listaMozliwychObrażen.put("Skaleczenie / łagodny skutek", 0.5);
        listaMozliwychObrażen.put("Złamanie drobne – palca od ręki lub nogi", 3);
        listaMozliwychObrażen.put("Złamanie ręki, ramienia lub nogi", 5);
        listaMozliwychObrażen.put("Utrata 1 lub kilku palców", 8);
        listaMozliwychObrażen.put("Amputacja ręki lub nogi, częściowa utrata wzroku lub słuchu", 11);
        listaMozliwychObrażen.put("Amputacja obu rąk, całkowita utrata wzroku lub słuchu", 15);
        listaMozliwychObrażen.put("Zagrożenie życia lub trwała utrata zdrowia", 25);
        listaMozliwychObrażen.put("Fatalne – pojedyńcza ofiara śmiertelna", 40);
        listaMozliwychObrażen.put("Katastrofa – kilka ofiar śmiertelnych", 65);

        return listaMozliwychObrażen;
    }
}
