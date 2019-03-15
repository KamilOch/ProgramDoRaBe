package proDoRaBe;

public class DaneDlaRaportu {

    private String tytulRaportu;
    private String numerDokumentu;
    private String wersjaDokumentu;
    private String dataDokumentu;

    public void dodajDaneDlaRaportu (String tytulRaportu, String numerDokumentu, String wersjaDokumentu, String dataDokumentu){
        if (czyPodanoWartosc(tytulRaportu)){
            this.tytulRaportu = tytulRaportu;
        }
        if (czyPodanoWartosc(numerDokumentu)){
            this.numerDokumentu = numerDokumentu;
        }
        if (czyPodanoWartosc(wersjaDokumentu)){
            this.wersjaDokumentu = wersjaDokumentu;
        }
        if (czyPodanoWartosc(dataDokumentu)){
            this.dataDokumentu = dataDokumentu;
        }
    }

    private boolean czyPodanoWartosc (String watsocSprawdzana){
        if (watsocSprawdzana==null || watsocSprawdzana.isEmpty()){
            return false;
        } else return true;

    }


    public String getTytulRaportu() {
        return tytulRaportu;
    }

    public String getNumerDokumentu() {
        return numerDokumentu;
    }

    public String getWersjaDokumentu() {
        return wersjaDokumentu;
    }

    public String getDataDokumentu() {
        return dataDokumentu;
    }
}
