package proDoRaBe.db;


import java.util.HashMap;


public class ReferencjePWZN {

        HashMap <String, Double> listaPrawdopodobienstwoWystapieniaZdarzeniaNiebezpiecznego;

        public ReferencjePWZN() {
                listaPrawdopodobienstwoWystapieniaZdarzeniaNiebezpiecznego.put("Prawie niemożliwe", 0.05);
                listaPrawdopodobienstwoWystapieniaZdarzeniaNiebezpiecznego.put("Mało prawdopodobne", 1.25);
                listaPrawdopodobienstwoWystapieniaZdarzeniaNiebezpiecznego.put("Możliwe", 2.5);
                listaPrawdopodobienstwoWystapieniaZdarzeniaNiebezpiecznego.put("Prawdopodobne", 4.0);
                listaPrawdopodobienstwoWystapieniaZdarzeniaNiebezpiecznego.put("Pewne", 6.0);

        }
}
