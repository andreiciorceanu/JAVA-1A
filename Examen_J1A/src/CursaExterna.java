public class CursaExterna extends Cursa {
    private String taraLinieAeriana;

    public CursaExterna(int id, int pret, int nrPasageri, String destinatie, boolean escala, String taraLinieAeriana) {
        super(id, pret, nrPasageri, destinatie, escala);
        this.taraLinieAeriana = taraLinieAeriana;
    }

    public String getTaraLinieAeriana() {
        return taraLinieAeriana;
    }

    public void setTaraLinieAeriana(String taraLinieAeriana) {
        this.taraLinieAeriana = taraLinieAeriana;
    }

    @Override
    public String toString() {
        return "Cursa{" +
                "id=" + super.getId() +
                ", pret=" + super.getPret() +
                ", nrPasageri=" + super.getNrPasageri() +
                ", destinatie='" + super.getDestinatie() + '\'' +
                ", escala=" + super.isEscala() +
                ", taraLinieAeriana=" + taraLinieAeriana +
                '}';
    }


}
