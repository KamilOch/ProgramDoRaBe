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
        machineRepository.delete(nazwaMaszyny);
    }

    public String add(String nazwaMaszyny, Maszyna maszyna) {
        return machineRepository.add(nazwaMaszyny,maszyna);
    }

    public  Maszyna get(String id) {
        return machineRepository.get(id);
    }
    public  Set<String> getAll () {
        return machineRepository.getAll();
    }
}
