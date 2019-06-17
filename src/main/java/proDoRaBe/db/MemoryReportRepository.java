package proDoRaBe.db;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import proDoRaBe.model.ReportRepository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Profile("demo")
class MemoryReportRepository implements ReportRepository {
    @Override
    public List<String> getAll() {
        List<String> mojaLista = new ArrayList<>();
        mojaLista.add("Raport1");
        mojaLista.add("Raport2");
        mojaLista.add("Raport3");
        return mojaLista;
    }
}
