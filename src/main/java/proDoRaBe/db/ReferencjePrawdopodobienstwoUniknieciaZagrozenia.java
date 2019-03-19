package proDoRaBe.db;

import java.util.HashMap;

public class ReferencjePrawdopodobienstwoUniknieciaZagrozenia {

    HashMap<String, Double> listaPrawdopodobienstwoUniknieciaZagrozenia;

    public ReferencjePrawdopodobienstwoUniknieciaZagrozenia() {
        listaPrawdopodobienstwoUniknieciaZagrozenia.put("Możliwe", 0.75);
        listaPrawdopodobienstwoUniknieciaZagrozenia.put("Możliwe pod pewnymi warunkami", 2.5);
        listaPrawdopodobienstwoUniknieciaZagrozenia.put("Niemożliwe", 5.0);

    }

}
