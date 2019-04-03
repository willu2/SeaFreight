import java.util.Arrays;
import java.util.Random;

public class PortDB {

    private int colums = 5;

    private static String[] ports = {"Shanghai", "Singapore", "Shenzhen", "Busan", "Dubai",
            "Rotterdam", "Port Clang", "Dalian", "Xiamen", "Hamburg", "Los Angeles", "Qingdao"};

    private String[][] portArray;

    public String[][] getPortArray() {
        return portArray;
    }

    //Create array size dinamicaly
    private String[][] makePortSizeArray(){
        String[][] portArray;
        int k = 0;
        for(int i = 0; i < ports.length ; i++){
            for(int p = i + 1 ; p < ports.length ; p++){
                k++;
            }
        }
        portArray = new String[k][colums];

        return portArray;
    }

    //creates ports map destinations and prices {from >> to ; weight, price}
    public void makePortsMap(){
        portArray = makePortSizeArray();

        int raw = 0;
        int colum = 0;
        int h = 1;
        for(int from = 0; from < ports.length ; from++){
            for(int to = from + 1 ; to < ports.length ; to++){

                portArray[raw][colum++] = ports[from];//your value
                portArray[raw][colum--] = ports[to];

                raw++;
            }
        }
        addPrice(portArray);
    }

    // add price dinamicaly
    private void addPrice(String[][] priceList){
        Random random = new Random();
        for (int i = 0; i < priceList.length; i++) {
            int colum = 0;
            for (int j = 2; j < priceList[i].length; j++) {
                if (j == 2) {
                    priceList[i][j] = String.valueOf(random.nextInt(14000) + 2500);
                } else if (j == 3) {
                    priceList[i][j] = String.valueOf(random.nextInt(500000) + 100000);
                    colum = Integer.parseInt(priceList[i][j]);
                } else {
                    priceList[i][j] = String.valueOf(random.nextInt(10000) + 2100 + colum);
                }
                colum++;
            }
        }
    }

    }







