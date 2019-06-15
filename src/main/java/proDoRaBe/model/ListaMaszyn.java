package proDoRaBe.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ListaMaszyn {

    private Map<String, Maszyna> maszyny = new HashMap<>();
   //String wiadomosc;

   public ListaMaszyn(){
       maszyny.put("a", new Maszyna("a", "a prd", "aaaa", null, null,null));
       maszyny.put("b", new Maszyna("b", null, null, null, null,null));
       maszyny.put("c", new Maszyna("c", null, null, null, null,null));
   }

    public synchronized void  usunMaszyne(String nazwaMaszyny) {
        maszyny.remove(nazwaMaszyny);
    }
    public synchronized String dodajMaszyne(String nazwaMaszyny, Maszyna maszyna) {
        String wiadomosc;
        if (nazwaMaszyny.equals("")||nazwaMaszyny.equals("wprowadz dane")) {
            wiadomosc = "Nie podałęś nazwy maszyny";
            System.out.println(wiadomosc);
        } else if (maszyny.containsKey(nazwaMaszyny)) {
            wiadomosc = "Podałeś "+nazwaMaszyny+" ale taka maszyna już istnieje, podaj inną nazwę";
            System.out.println(wiadomosc);
        }   else {
            maszyny.put(nazwaMaszyny, maszyna);
            wiadomosc =  "Dodano nową maszynę o nazwie "+nazwaMaszyny;
            System.out.println(wiadomosc);
        }
        return wiadomosc;
    }

    public synchronized Maszyna podajMaszyny(String kto) {

        return maszyny.get(kto);
    }

    public synchronized Set<String> podajNazwyMaszyn() {
        HashMap<String, Maszyna> kopiaMaszyn = new HashMap<>(maszyny);
        return kopiaMaszyn.keySet();

    }
}
