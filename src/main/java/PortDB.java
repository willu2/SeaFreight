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
            // Цикл по второй размерности выводит колонки - вывод одной строки
            for (int j = 0; j < portArray[i].length; j++) {
                // Используем оператор print - без перехода на следующую строку
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
             System.out.println();
        }
    }

    //print All data like table;
    public void printOneRawMap(String[][] portArray){
         for (int i = 0; i < portArray.length; i++) {
            for (int j = 0; j < portArray[i].length; j++) {
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
        printArrayMap(portArray);
    }

    public void searchByPrice() {
        int cash = 120000;
        int dataCash = 0;
        for (int i = 0; i < portArray.length; i++) {
            dataCash = Integer.parseInt(portArray[i][4]);
            if (dataCash < cash) {
                for (int j = 0; j < portArray[i].length; j++) {
                //    printOneRawMap(portArray[i][j]);


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
                System.out.println();
                //  System.out.print(portArray[i][j]+"___");

                    //System.out.println();
                }
            }
        }
    }







