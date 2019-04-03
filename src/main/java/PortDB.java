import java.util.Arrays;
import java.util.Random;

public class PortDB {

    public static String[] ports = {"Shanghai", "Singapore", "Shenzhen", "Busan", "Dubai",
            "Rotterdam", "Port Clang", "Dalian", "Xiamen", "Hamburg", "Los Angeles", "Qingdao"};

    String[][] portArray;
    int colums = 5;

    //Create array size dinamicaly
    public String[][] makePortSizeArray(){
        String[][] portArray;
        int k = 0;
        for(int i = 0; i < ports.length ; i++){
            for(int p = i + 1 ; p < ports.length ; p++){
                k++;
                //System.out.println(ports[i] + " ----->>> "+ ports[p] +"  _______"+ p );
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

               //System.out.println(ports[from] + "  <<<------->>> "+ ports[to] +" ___ " + h );
                raw++;
            }
        }
        addPrice(portArray);
        //printArrayMap(portArray);
    }

    //print All data like table;
    public void printArrayMap(String[][] portArray){
         for (int i = 0; i < portArray.length; i++) {
            for (int j = 0; j < portArray[i].length; j++) {
                printByColums(i, j);
            }
             System.out.println();
        }
    }

    //print All data like table;
    public void printOneRawMap(String[][] portArray){
         for (int i = 0; i < portArray.length; i++) {
            for (int j = 0; j < portArray[i].length; j++) {
                printByColums(i, j);
            }
             System.out.println();
        }
    }

    // add price dinamicaly
    public void addPrice(String[][] priceList){
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
    public void printAllVariants() {
        //printArrayMap(portArray);
        showLowestPrice();
    }

    //done
    public void searchByPrice(int casch) {
        int dataCash = 0;
        for (int i = 0; i < portArray.length; i++) {
            dataCash = Integer.parseInt(portArray[i][4]);
            if (dataCash < casch) {
                for (int j = 0; j < portArray[i].length; j++) {
                    printByColums(i, j);
                }
                System.out.println();
                }
            }
        }

        public void showLowestPrice() {
        int temp = 0;
        String[][] firstLowFive = new String[5][5];
        String[][] tempA = new String[5][5];

            //int [] mas = {11, 3, 14, 16, 7};

            int[] buf = new int[66];
                int i = 4;
                for (int ii = 0; ii < portArray.length ; ii++) {
                    // for (int i = 4; i < portArray[ii].length-1; i++) {
                    buf[ii] = Integer.parseInt(portArray[ii][i]);
                    //System.out.println(buf[ii]);
                }

            boolean isSorted = false;
            int buffTemp;
            while(!isSorted) {
                isSorted = true;
                for (int w = 0; w < buf.length-1; w++) {
                    if(buf[w] > buf[w+1]){
                        isSorted = false;

                        buffTemp = buf[w];
                        buf[w] = buf[w+1];
                        buf[w+1] = buffTemp;
                    }
                }
            }
            System.out.println(Arrays.toString(buf));

               /* for (int ii = 0; ii < portArray.length ; ii++) {
                    if(Integer.parseInt(portArray[ii][i]) > Integer.parseInt(portArray[ii+1][i])){
                         // isSorted = false;
                         portArray[ii][i] = portArray[ii+1][i];
                         portArray[ii+1][i] = String.valueOf(buf[ii]);
                    }
               // }
                //}
            }*/


/*                isSorted = true;
                for (int rows = 0; rows < 5; rows++){
                    for (int col = 3; col < firstLowFive[rows].length; col++) {
                        firstLowFive[rows][col] = portArray[0][4];
                        tempA[rows][col] = portArray[0][4];

                        for (int ii = 0; ii < portArray.length; ii++) {
                            for (int i = 4; i < portArray[ii].length; i++) {
                                if(Integer.parseInt(firstLowFive[rows][col]) > Integer.parseInt( portArray[ii][i])){
                                    firstLowFive[rows][4] = portArray[ii][4];
                }}
            }
                }
            }*/
             //   printArrayMap(portArray);
            //System.out.println(Arrays.toString(firstLowFive));
           // int minValue = Integer.parseInt(portArray[0][4]);
            /*for (int rows = 0; rows < 5; rows++){
                   for (int i = 0; i < portArray.length; i++) {
                         // minValue = Integer.parseInt(portArray[i][4]);
                        for (int j = 4; j < portArray[i].length; j++) {
                            if(minValue > Integer.parseInt(portArray[i][4])){
                                minValue = Integer.parseInt(portArray[i][j]);
                                for (int jj = 0; jj < portArray[i].length; j++) {
                                    firstLowFive[rows][jj] = portArray[i][jj];
                            }
                        }
                   }

            System.out.println("Minimum in row is " + minValue);
            System.out.println();
                       printArrayMap(firstLowFive);
                   }
            }*/
    }


        public  void printByColums(int i, int j){
            switch (j){
                case 0:
                    System.out.print(portArray[i][j] + " <<<___>>> " );
                    break;
                case 1:
                    System.out.print(portArray[i][j] + "  ---|Distance >>  ");
                    break;
                case 2:
                    System.out.print(portArray[i][j] + " km ||| ");
                    break;
                case 3:
                    System.out.print(portArray[i][j] + " kg ## price_>> ");
                    break;
                case 4:
                    System.out.print(portArray[i][j] + "_$");
                    break;
            }
        }

    }







