package proDoRaBe.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ListaMaszyn {

    private Map<String, Maszyna> maszyny = new HashMap<>();
   String wiadomosc;

    public synchronized void  usunMaszyne(String nazwaMaszyny) {
        maszyny.remove(nazwaMaszyny);
    }
    public synchronized void /*String*/ dodajMaszyne(String nazwaMaszyny, Maszyna maszyna) {

        if (nazwaMaszyny.equals("")) {
            wiadomosc = "Nie podałęś nazwy maszyny";
            System.out.println(wiadomosc);

        } else if (maszyny.containsKey(nazwaMaszyny)) {
            wiadomosc = "Podałeś "+nazwaMaszyny+" ale taka maszyna już istnieje, podaj innyą nazwę";
            System.out.println(wiadomosc);

        }   else {
            maszyny.put(nazwaMaszyny, maszyna);
            wiadomosc =  "Dodano nową maszynę";
            System.out.println(wiadomosc);

        }
    }

    public synchronized Maszyna podajMaszyny(String kto) {

        return maszyny.get(kto);
    }

    public synchronized Set<String> podajNazwyMaszyn() {
        HashMap<String, Maszyna> kopiaMaszyn = new HashMap<>(maszyny);
        return kopiaMaszyn.keySet();

    }

    public String getWiadomosc() {
        return wiadomosc;
    }
}
