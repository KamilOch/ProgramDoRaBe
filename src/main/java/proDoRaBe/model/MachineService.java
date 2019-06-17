package proDoRaBe.model;

import org.springframework.stereotype.Service;
import proDoRaBe.db.MachineRepository;

import java.util.Set;

@Service
public class MachineService {

    public MachineService(MachineRepository machineRepository) {
        this.machineRepository = machineRepository;
    }

    private final MachineRepository machineRepository;

    public  void delete(String nazwaMaszyny) {
        machineRepository.usunMaszyne(nazwaMaszyny);
    }
    public  Set<String> getAll () {
        return machineRepository.podajNazwyMaszyn();
    }
}
