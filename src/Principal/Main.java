package Principal;

import servicios.MenuServicios;

public class Main {

    public static void main(String[] args) {

        MenuServicios servicios = new MenuServicios();

        try {
            servicios.Menu();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
