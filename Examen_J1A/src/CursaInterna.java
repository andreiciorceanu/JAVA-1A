public class CursaInterna extends Cursa{
    private int durata;

    public CursaInterna(int id, int pret, int nrPasageri, String destinatie, boolean escala, int durata) {
        super(id, pret, nrPasageri, destinatie, escala);
        this.durata = durata;
    }

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    @Override
    public String toString() {
        return "Cursa{" +
                "id=" + super.getId() +
                ", pret=" + super.getPret() +
                ", nrPasageri=" + super.getNrPasageri() +
                ", destinatie='" + super.getDestinatie() + '\'' +
                ", escala=" + super.isEscala() +
                ", durata=" + durata +
                '}';
    }



}
