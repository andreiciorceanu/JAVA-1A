public abstract class Cursa {
    private int id;
    private int pret;
    private int nrPasageri;
    private String destinatie;
    private boolean escala;

    public Cursa(int id, int pret, int nrPasageri, String destinatie, boolean escala) {
        this.id = id;
        this.pret = pret;
        this.nrPasageri = nrPasageri;
        this.destinatie = destinatie;
        this.escala = escala;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPret() {
        return pret;
    }

    public void setPret(int pret) {
        this.pret = pret;
    }

    public int getNrPasageri() {
        return nrPasageri;
    }

    public void setNrPasageri(int nrPasageri) {
        this.nrPasageri = nrPasageri;
    }

    public String getDestinatie() {
        return destinatie;
    }

    public void setDestinatie(String destinatie) {
        this.destinatie = destinatie;
    }

    public boolean isEscala() {
        return escala;
    }

    public void setEscala(boolean escala) {
        this.escala = escala;
    }

    @Override
    public String toString() {
        return "Cursa{" +
                "id=" + id +
                ", pret=" + pret +
                ", nrPasageri=" + nrPasageri +
                ", destinatie='" + destinatie + '\'' +
                ", escala=" + escala +
                '}';
    }
}
