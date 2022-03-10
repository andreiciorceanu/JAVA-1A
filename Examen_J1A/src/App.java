import java.util.Scanner;

public class App {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Aeroport aeroport = Aeroport.getInstance();

    public static void main(String[] args) {
        String comanda = scanner.nextLine();

        while(!"START".equalsIgnoreCase(comanda)) {
            System.out.println("Te rog introdu comanda START!");
            comanda = scanner.nextLine();
        }

        System.out.println("Alege comanda:");
        System.out.println("ADAUGA_CURSA <tip> <pret> <nrPasageri> <destinatie> <escala>");
        System.out.println("AFLA_TIP <idCursa>");
        System.out.println("AFISARE <tip>");
        System.out.println("STERGE_CURSA <idCursa>");
        System.out.println("EXIT");

        comanda = scanner.next();

        Thread thread = new Thread(() -> {
            while(true) {
                try {
                    System.out.println("Numarul curselor curente din aeroport este " + aeroport.getCurse().size());
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        while(!"EXIT".equalsIgnoreCase(comanda)) {
            if ("ADAUGA_CURSA".equalsIgnoreCase(comanda)) {
                String tipZbor = scanner.next();
                int pret = Integer.parseInt(scanner.next());
                int nrPasageri = Integer.parseInt(scanner.next());
                String destinatie = scanner.next();
                String escala = scanner.next();
                boolean es = false;

                if (escala.equalsIgnoreCase("da")) {
                    es = true;
                }

                if ("I".equalsIgnoreCase(tipZbor)) {
                    int durata = Integer.parseInt(scanner.next());
                    CursaInterna cursaInterna = new CursaInterna(0, pret, nrPasageri, destinatie, es, durata);
                    try {
                        aeroport.adaugareCursa(cursaInterna);
                    } catch (PreaMulteCurseException e) {
                        e.printStackTrace();
                    }

                } else {
                    String taraLinieAeriana = scanner.next();
                    CursaExterna cursaExterna = new CursaExterna(0, pret, nrPasageri, destinatie, es, taraLinieAeriana);
                    try {
                        aeroport.adaugareCursa(cursaExterna);
                    } catch (PreaMulteCurseException e) {
                        e.printStackTrace();
                    }
                }

            } else if ("AFISARE".equalsIgnoreCase(comanda)) {
                char tip = scanner.next().charAt(0);
                aeroport.afisare(tip);
            } else if ("STERGE_CURSA".equalsIgnoreCase(comanda)) {
                int id = Integer.parseInt(scanner.next());
                aeroport.stergeCursa(id);
            } else if ("AFLA_TIP".equalsIgnoreCase(comanda)) {
                int id = Integer.parseInt(scanner.next());
                aeroport.aflaTip(id);
            }

            comanda = scanner.next();
        }

        System.out.println("Aplicatia s-a oprit!");
        thread.stop();
    }

}
