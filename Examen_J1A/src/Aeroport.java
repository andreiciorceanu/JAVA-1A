import java.util.ArrayList;
import java.util.List;

public class Aeroport {
    private static Aeroport SINGLETON;
    private List<Cursa> curse = new ArrayList<>();

    private Aeroport() {

    }

    public static final Aeroport getInstance() {
        if (SINGLETON == null) {
            SINGLETON = new Aeroport();
        }
        return  SINGLETON;
    }

    public List<Cursa> getCurse() {
        return curse;
    }

    public void adaugareCursa(Cursa C) throws PreaMulteCurseException{
        if (curse.size() < 5) {
            if (curse.size() == 0) {
                C.setId(1);
            } else {
                C.setId(curse.indexOf(curse.get(curse.size()-1)) + 2);
            }

            curse.add(C);
            System.out.println("Cursa a fost adaugata!");
        } else {
            throw new PreaMulteCurseException("Aeroportul este plin!");
        }
    }

    public void aflaTip(int id) {
        boolean ok = false;
        for (Cursa cursa : curse) {
            if (cursa.getId() == id) {
                ok = true;
                if (cursa instanceof CursaInterna) {
                    System.out.println("interna");
                } else {
                    System.out.println("externa");
                }
                break;
            }
        }
        if (!ok) {
            System.out.println("Cursa cautata nu exista!");
        }
    }

    public void afisare(char tip) {
        if (tip == 'I') {
            long nr = curse.stream().filter(cursa -> cursa instanceof CursaInterna).count();
            if (nr == 0) {
                System.out.println("Nu exista curse interne!");
            } else {
                curse.stream().filter(cursa -> cursa instanceof CursaInterna).forEach(System.out::println);
            }
        }

        if (tip == 'E') {
            long nr = curse.stream().filter(cursa -> cursa instanceof CursaExterna).count();
            if (nr == 0) {
                System.out.println("Nu exista curse externe!");
            } else {
                curse.stream().filter(cursa -> cursa instanceof CursaExterna).forEach(System.out::println);
            }
        }

        if (tip == 'T') {
            if (curse.size() != 0) {
                curse.forEach(System.out::println);
            } else {
                System.out.println("Nu exista curse!");
            }
        }
    }

    public void stergeCursa(int id) {
        boolean ok = false;
        int poz = -1;
        for (Cursa cursa : curse) {
            if (cursa.getId() == id) {
                ok = true;
                poz = curse.indexOf(cursa);
                break;
            }
        }
        if (ok) {
            curse.remove(poz);
        } else {
            System.out.println("Cursa nu exista!");
        }
    }

}
