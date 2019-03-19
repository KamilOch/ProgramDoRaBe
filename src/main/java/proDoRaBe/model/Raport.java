package proDoRaBe.model;

import proDoRaBe.model.DaneRaportu;
import proDoRaBe.model.LiniaProdukcyjna;

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
