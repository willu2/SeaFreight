import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SeaFreight {
    public static void main(String[] args) {

        boolean exit = false;

        MenuBuilder menu = new MenuBuilder();
        PortDB portDB = new PortDB();
        portDB.makePortsMap();

        do {
            int pos = 0;
            double price = 0.0;

            menu.mainManu();

            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));   //get strig data
            try {
                switch (pos = Integer.parseInt(in.readLine())) {
                    case 1:
                        portDB.printAllVariants();
                        break;
                    case 2:
                       // menu.grupeShow();
                       // pos = Integer.parseInt(in.readLine());
                        portDB.searchByPrice();
                        break;
                    case 3:
                        menu.grupeShow();
                        pos = Integer.parseInt(in.readLine());
                        menu.priceEnter();
                        price = Double.parseDouble(in.readLine());
                        //market.showGrupeLowLimit(pos, price);
                        break;
                    case 4:
                        menu.grupeShow();
                        pos = Integer.parseInt(in.readLine());
                        menu.priceEnter();
                        price = Double.parseDouble(in.readLine());
                       // market.showGrupeHightLimit(pos, price);
                        break;
                    case 8:
                        exit = true;
                        break;
                    default:
                        System.out.println("Try again...");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }while (!exit);

    }
}
