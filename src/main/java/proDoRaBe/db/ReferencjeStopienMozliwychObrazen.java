package proDoRaBe.db;


import java.util.HashMap;


public class ReferencjeStopienMozliwychObrazen {

        HashMap<String, Double> referencjeStopienMozliwychObrazen = new HashMap<>();

        referencjeStopienMozliwychObrazen.put("Zadrapanie/Stłuczenie", 0.25);
        referencjeStopienMozliwychObrazen.put("Skaleczenie / łagodny skutek", 0.5);
        referencjeStopienMozliwychObrazen.put("Złamanie drobne – palca od ręki lub nogi", 30.0);
        referencjeStopienMozliwychObrazen.put("Złamanie ręki, ramienia lub nogi", 5.0);
        referencjeStopienMozliwychObrazen.put("Utrata 1 lub kilku palców", 8.0);
        referencjeStopienMozliwychObrazen.put("Amputacja ręki lub nogi, częściowa utrata wzroku lub słuchu", 11.0);
        referencjeStopienMozliwychObrazen.put("Amputacja obu rąk, całkowita utrata wzroku lub słuchu", 15.0);
        referencjeStopienMozliwychObrazen.put("Zagrożenie życia lub trwała utrata zdrowia", 25.0);
        referencjeStopienMozliwychObrazen.put("Fatalne – pojedyńcza ofiara śmiertelna", 40.0);
        referencjeStopienMozliwychObrazen.put("Katastrofa – kilka ofiar śmiertelnych", 65.0);



}
