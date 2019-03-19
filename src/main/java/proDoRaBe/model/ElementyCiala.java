package proDoRaBe.model;

import java.util.ArrayList;
import java.util.List;

public class ElementyCiala {

    public List<String> elementyCiala = new ArrayList<>();

    public List<String> getElementyCiala() {
        List<String> elementyCialaKopia = new ArrayList<>(elementyCiala);
        return elementyCialaKopia;
    }




}
