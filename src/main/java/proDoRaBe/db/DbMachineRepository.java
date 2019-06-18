package proDoRaBe.db;

import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import proDoRaBe.model.MachineRepository;
import proDoRaBe.model.Maszyna;

import java.util.*;

@Repository
@Profile("!demo")
class DbMachineRepository implements MachineRepository {

    private Map<String, Maszyna> maszyny = new HashMap<>();
    private final JdbcTemplate jdbcTemplate;

   public DbMachineRepository(JdbcTemplate jdbcTemplate){
       this.jdbcTemplate = jdbcTemplate;
   }

    @Override
    public synchronized void delete(String nazwaMaszyny) {
       jdbcTemplate.update("DELETE FROM public.machines WHERE name = ?", new Object[] { nazwaMaszyny });
    }

    @Override
    public synchronized String add(String nazwaMaszyny, Maszyna maszyna) {
        String wiadomosc;


        if (nazwaMaszyny.equals("")||nazwaMaszyny.equals("wprowadz dane")) {
            wiadomosc = "Nie podałęś nazwy maszyny";
            System.out.println(wiadomosc);
        //} else if (maszyny.containsKey(nazwaMaszyny)) {
        } else if (getAll().contains(nazwaMaszyny)) {
            wiadomosc = "Podałeś "+nazwaMaszyny+" ale taka maszyna już istnieje, podaj inną nazwę";
            System.out.println(wiadomosc);
        }   else {
            jdbcTemplate.update(
                    "INSERT INTO public.machines (name, manufacturer, type, number, produtiondate, certificats) VALUES (?, ?, ?, ?, ?, ?)",
                    nazwaMaszyny, maszyna.getProducentMaszyny(),maszyna.getTypMaszyny(), maszyna.getNumerMaszyny(),maszyna.getDataProdukcji(), maszyna.getPosiadaneCertyfikaty()
            );
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
        List <String> listaMaszyn = jdbcTemplate.queryForList("SELECT name FROM public.machines", String.class);
        return new HashSet<String>(listaMaszyn);
   }
}
