package proDoRaBe.db;

import org.springframework.stereotype.Repository;
import proDoRaBe.model.Maszyna;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Repository
public class MaschineRepository {

    private Map<String, Maszyna> maszyny = new HashMap<>();

   public MaschineRepository(){
       maszyny.put("a", new Maszyna("a", "a prd", "aaaa", null, null,null));
       maszyny.put("b", new Maszyna("b", "b pro", "bbb", null, null,null));
       maszyny.put("c", new Maszyna("c", "c prod", "ccc", null, null,null));
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
