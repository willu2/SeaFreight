package seafreight.my.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SeaFreight {
    public static void main(String[] args) {

        boolean exit = false;

        MenuBuilder menu = new MenuBuilder();
        PortController controller = new PortController();
        controller.loadAllDataFreigts();

        do {
            int price = 0;

            menu.mainManu();

            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));   //get strig data
            try {
                switch (Integer.parseInt(in.readLine())) {
                    case 1:
                        controller.printAllVariants();
                        break;
                    case 2:
                        menu.priceEnter();
                        try {
                            price = Integer.parseInt(in.readLine());
                        }catch(IOException e){
                            System.out.println("Input error");
                            System.exit(1);
                        }
                        catch(NumberFormatException e)
                        {
                            System.out.println(e.getMessage() + " is not numeric");
                        }

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
                        break;
                    case 8:
                        controller.showMaxMass();
                        break;
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
