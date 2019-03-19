package proDoRaBe.db;

import java.util.HashMap;

public class ReferencjeCzestotliwoscCzasEkspozycji {

    HashMap<String, Double> listaCzestotliwoscCzasEkspozycji;

    public ReferencjeCzestotliwoscCzasEkspozycji() {
        listaCzestotliwoscCzasEkspozycji.put("Raz w roku", 0.5);
        listaCzestotliwoscCzasEkspozycji.put("Co miesiąc", 1.0);
        listaCzestotliwoscCzasEkspozycji.put("Co tydzień", 2.0);
        listaCzestotliwoscCzasEkspozycji.put("Codziennie", 3.0);
        listaCzestotliwoscCzasEkspozycji.put("Co godzinę", 4.0);
        listaCzestotliwoscCzasEkspozycji.put("Ciągle", 5.0);

    }
}
