package proDoRaBe.model;

import java.util.ArrayList;

public class LPPodstawoweDaneLinii {

    //podstawowe dane linii
    private String nazwaLinii;
    private String producentLinii;
    private String typLinii;
    private String numerLinii;
    private String dataProdukcji;
    private String posiadaneCertyfikaty;
    // tego nie ma jeszcze w htmlu, do przemyslenia co  lista maszyn w linii
   //private ArrayList<Maszyna> maszynay;

    public void dodajLPPodstawoweDaneLinii (
            String nazwaLinii,
            String producentLinii,
            String typLinii,
            String numerLinii,
            String dataProdukcji,
            String posiadaneCertyfikaty
            // tego nie ma jeszcze w htmlu, do przemyslenia co  lista maszyn w linii
            //ArrayList<Maszyna> maszynay
    ) {

        if (czyPodanoWartosc(nazwaLinii)) {
            this.nazwaLinii = nazwaLinii;
        }
        if (czyPodanoWartosc(producentLinii)) {
            this.producentLinii = producentLinii;
        }
        if (czyPodanoWartosc(typLinii)) {
            this.typLinii = typLinii;
        }
        if (czyPodanoWartosc(numerLinii)) {
            this.numerLinii = numerLinii;
        }
        if (czyPodanoWartosc(dataProdukcji)) {
            this.dataProdukcji = dataProdukcji;
        }
        if (czyPodanoWartosc(posiadaneCertyfikaty)) {
            this.posiadaneCertyfikaty = posiadaneCertyfikaty;
        }
    }

    private boolean czyPodanoWartosc (String watsocSprawdzana){
        if (watsocSprawdzana==null || watsocSprawdzana.isEmpty()){
            return false;
        } else return true;
    }

    public String getNazwaLinii() {
        return nazwaLinii;
    }

    public String getProducentLinii() {
        return producentLinii;
    }

    public String getTypLinii() {
        return typLinii;
    }

    public String getNumerLinii() {
        return numerLinii;
    }

    public String getDataProdukcji() {
        return dataProdukcji;
    }

    public String getPosiadaneCertyfikaty() {
        return posiadaneCertyfikaty;
    }
/*
    public ArrayList<Maszyna> getMaszynay() {
        return maszynay;
    }
*/

}
