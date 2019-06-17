package proDoRaBe.model;

import java.util.Set;

public interface MachineRepository {
    void delete(String nazwaMaszyny);

    String add(String nazwaMaszyny, Maszyna maszyna);

    Maszyna get(String id);

    Set<String> getAll();
}
