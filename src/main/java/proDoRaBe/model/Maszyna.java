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
//  zastanawiam sie jak to ustawic czy maszyna ma ryzyka czy linia czytez sa ryzyka z roznymi maszynami (3opcje widze)
//    private Ryzyko ryzyko;




}
