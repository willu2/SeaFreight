import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SeaFreight {
    public static void main(String[] args) {

        boolean exit = false;

        MenuBuilder menu = new MenuBuilder();
        PortControllerImpl controller = new PortControllerImpl();
        controller.loadAllDataFreigts();

        do {
            int pos = 0;
            int price = 0;

            menu.mainManu();

            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));   //get strig data
            try {
                switch (pos = Integer.parseInt(in.readLine())) {
                    case 1:
                        controller.printAllVariants();
                        break;
                    case 2:
                        menu.priceEnter();
                        price = Integer.parseInt(in.readLine());
                        controller.searchByPrice(price);
                        break;
                    case 3:
                        controller.showHighestPric();
                        break;
                    case 4:
                        controller.showLowPric();
                        break;
                    case 5:
                        controller.showHightSpeed();
                        break;
                    case 6:
                        controller.showLowSpeed();
                        break;
                    case 7:
                        controller.showMinMass();
                    case 8:
                        controller.showMaxMass();
                    case 9:
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
