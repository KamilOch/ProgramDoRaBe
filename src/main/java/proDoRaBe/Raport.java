package proDoRaBe;

public class Raport {

    private DaneRaportu daneRaportu;
    private LiniaProdukcyjna liniaProdukcyjna;

    public Raport(DaneRaportu daneRaportu, LiniaProdukcyjna liniaProdukcyjna) {
        this.daneRaportu = daneRaportu;
        this.liniaProdukcyjna = liniaProdukcyjna;
    }

    public DaneRaportu getDaneRaportu() {
        return daneRaportu;
    }

    public LiniaProdukcyjna getLiniaProdukcyjna() {
        return liniaProdukcyjna;
    }

}
