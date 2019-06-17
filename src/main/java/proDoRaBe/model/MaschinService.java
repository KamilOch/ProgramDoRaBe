package proDoRaBe.model;

import org.springframework.stereotype.Service;
import proDoRaBe.db.MaschineRepository;

import java.util.Set;

@Service
public class MaschinService {

    public MaschinService(MaschineRepository maschineRepository) {
        this.maschineRepository = maschineRepository;
    }

    private final MaschineRepository maschineRepository;

    public synchronized void usun(String nazwaMaszyny) {
        maschineRepository.usunMaszyne(nazwaMaszyny);
    }
    public synchronized Set<String> getAll () {
        return maschineRepository.podajNazwyMaszyn();
    }
}
