package proDoRaBe.model;

import java.util.ArrayList;
import java.util.List;

public class ElementyCiala {

private List<String> elementyCiala = new ArrayList<>();

    public List<String> getElementyCiala() {
        elementyCiala.add("Kończyny górne");
        elementyCiala.add("Kończyny dolne");
        elementyCiala.add("Całe ciało");
        elementyCiala.add("Głowa");
        elementyCiala.add("Dłoń/Palec");

        List<String> elementyCialaKopia = new ArrayList<>(elementyCiala);

        return elementyCialaKopia;
    }




}
