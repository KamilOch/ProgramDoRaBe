package proDoRaBe.model;

public class Maszyna {

    private String nazwaMaszyny;
    private String producentMaszyny;
    private String typMaszyny;
    private String numerMaszyny;
    private String dataProdukcji;
    private String posiadaneCertyfikaty;

    public Maszyna(String nazwaMaszyny, String producentMaszyny, String typMaszyny, String numerMaszyny, String dataProdukcji, String posiadaneCertyfikaty) {
        this.nazwaMaszyny = nazwaMaszyny;
        this.producentMaszyny = producentMaszyny;
        this.typMaszyny = typMaszyny;
        this.numerMaszyny = numerMaszyny;
        this.dataProdukcji = dataProdukcji;
        this.posiadaneCertyfikaty = posiadaneCertyfikaty;
    }

    public Maszyna() {
    }

    public String getNazwaMaszyny() {
        return nazwaMaszyny;
    }

    public String getProducentMaszyny() {
        return producentMaszyny;
    }

    public String getTypMaszyny() {
        return typMaszyny;
    }

    public String getNumerMaszyny() {
        return numerMaszyny;
    }

    public String getDataProdukcji() {
        return dataProdukcji;
    }

    public String getPosiadaneCertyfikaty() {
        return posiadaneCertyfikaty;
    }
//  zastanawiam sie jak to ustawic czy maszyna ma ryzyka czy linia czytez sa ryzyka z roznymi maszynami (3opcje widze)
//    private Ryzyko ryzyko;




}
