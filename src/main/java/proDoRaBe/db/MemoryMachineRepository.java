package proDoRaBe.db;

import org.springframework.stereotype.Repository;
import proDoRaBe.model.MachineRepository;
import proDoRaBe.model.Maszyna;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Repository
class MemoryMachineRepository implements MachineRepository {

    private Map<String, Maszyna> maszyny = new HashMap<>();

   public MemoryMachineRepository(){
       maszyny.put("a", new Maszyna("a", "a prd", "aaaa", null, null,null));
       maszyny.put("b", new Maszyna("b", "b pro", "bbb", null, null,null));
       maszyny.put("c", new Maszyna("c", "c prod", "ccc", null, null,null));
   }

    @Override
    public synchronized void delete(String nazwaMaszyny) {
        maszyny.remove(nazwaMaszyny);
    }
    @Override
    public synchronized String add(String nazwaMaszyny, Maszyna maszyna) {
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

    @Override
    public synchronized Maszyna get(String id) {
        return maszyny.get(id);
    }

    @Override
    public synchronized Set<String> getAll() {
        HashMap<String, Maszyna> kopiaMaszyn = new HashMap<>(maszyny);
        return kopiaMaszyn.keySet();
    }
}
