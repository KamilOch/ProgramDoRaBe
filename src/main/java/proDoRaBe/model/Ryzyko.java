package proDoRaBe.model;

import java.util.HashMap;

public class Ryzyko {

    private double numerRyzyka;
    private String tytulRyzyka;
    private String lokalizacjaRyzyka;
    private ElementyCiala zagrozonyElementCiala;
    private String typPracyMaszyny;
    private String zadanie;
    private String podZadanie;
    private TypRyzyka typRyzyka;
    private TypRyzyka podTypRyzyka;
    private String opisRyzyka;

// osobne klasy
    //private StopienMozliwychObrazen stopienMozliwychObrazen;
    //private PrawdopodobienstwoWystapieniaZdarzeniaNiebezpiecznego prawdopodobienstwoWystapieniaZdarzeniaNiebezpiecznego;
    //private PrawdopodobienstwoUniknieciaZagrozenia prawdopodobienstwoUniknieciaZagrozenia;
    //private CzestotliwoscCzasEkspozycji czestotliwoscCzasEkspozycji;
// moze lepiej listy a nie klasy
    private HashMap <String, Double> listaMozliwychObrazen = new HashMap<>();
    private HashMap <String, Double> listaPrawdopodobienstwoWystapieniaZdarzeniaNiebezpiecznego = new HashMap<>();
    private HashMap<String, Double> listaPrawdopodobienstwoUniknieciaZagrozenia = new HashMap<>();
    private HashMap<String, Double> listaCzestotliwoscCzasEkspozycji = new HashMap<>();




    private String opisPropozycjiRegukcjiRyzyka;
    private String spisWykorzystanychNorm;

    private int prawdopodobienstwoWystapieniaZdarzeniaNiebezpiecznegoPoRedukcji;




    public Double obliczanieWspolczynnikaWysokosciRyzyka (String stopienMozliwychObrazen,String prawdopodobienstwoWystapieniaZdarzeniaNiebezpiecznego, String prawdopodobienstwoUniknieciaZagrozenia, String czestotliwoscCzasEkspozycji ){
        return listaMozliwychObrazen.get(stopienMozliwychObrazen)
                *listaPrawdopodobienstwoWystapieniaZdarzeniaNiebezpiecznego.get(prawdopodobienstwoWystapieniaZdarzeniaNiebezpiecznego)
                *listaPrawdopodobienstwoUniknieciaZagrozenia.get(prawdopodobienstwoUniknieciaZagrozenia)
                *listaCzestotliwoscCzasEkspozycji.get(czestotliwoscCzasEkspozycji);
    }

    public String wyswietlObliczonyPoziomRyzyka (Double obliczanieWspolczynnikaWysokosciRyzyka){
        if (obliczanieWspolczynnikaWysokosciRyzyka >=1 && obliczanieWspolczynnikaWysokosciRyzyka <=10){
            return "Ryzyko pomijalne";
        } else if (obliczanieWspolczynnikaWysokosciRyzyka >=11 && obliczanieWspolczynnikaWysokosciRyzyka <=20){
            return "Ryzyko bardzo niskie";
        } else if (obliczanieWspolczynnikaWysokosciRyzyka >=21 && obliczanieWspolczynnikaWysokosciRyzyka <=45) {
            return "Ryzyko niskie";
        } else if (obliczanieWspolczynnikaWysokosciRyzyka >=46 && obliczanieWspolczynnikaWysokosciRyzyka <=160) {
            return "Ryzyko znaczące";
        } else if (obliczanieWspolczynnikaWysokosciRyzyka >=161 && obliczanieWspolczynnikaWysokosciRyzyka <=500) {
            return "Ryzyko wysokie";
        } else if (obliczanieWspolczynnikaWysokosciRyzyka >=501) {
            return "Ryzyko bardzo wysokie";
        } else return "nie udało się obliczyć wysokości ryzyka!";
    }

    public String wyswietlKomentarzDoObliczonegoPoziomuRyzyka (String wyswietlObliczonyPoziomRyzyka){
        if(wyswietlObliczonyPoziomRyzyka.equals("Ryzyko pomijalne")){
            return "Praktycznie bez wpływu na zdrowie i bezpieczeństwo, środki zaradcze nie są wymagane.";
        } else if(wyswietlObliczonyPoziomRyzyka.equals("Ryzyko bardzo niskie")){
            return "Bardzo niskie ryzyko dla zdrowia i bezpieczeństwa, znaczące środki zaradcze nie są wymagane. Konieczne użycie środków ochrony osobistej i/lub szkolenie pracowników.";
        } else if(wyswietlObliczonyPoziomRyzyka.equals("Ryzyko niskie")){
            return "Występuje ryzyko dla zdrowia i bezpieczeństwa, ale niskie. Należy rozważyć wprowadzenie środków zaradczych.";
        } else if(wyswietlObliczonyPoziomRyzyka.equals("Ryzyko znaczące")){
            return "Ryzyko znaczące, wymagające wdrożenia środków zaradczych, które powinny być zaimplementowane przy najbliższej odpowiedniej okazji.";
        } else if(wyswietlObliczonyPoziomRyzyka.equals("Ryzyko wysokie")){
            return "Potencjalnie niebezpieczne, wymagające implementacji środków zaradczych niezwłocznie.";
        } else if(wyswietlObliczonyPoziomRyzyka.equals("Ryzyko bardzo wysokie")){
            return "Środki zaradcze powinny być zaimplementowane natychmiast. Wymagane poinformowanie zarządu korporacyjnego.";
        } else return "nie udało się wygenerować komentarza do obliczonego poziomu ryzyka! ";
    }


}