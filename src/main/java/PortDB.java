import java.util.Random;

public class PortDB {

    public static String[] ports = {"Shanghai", "Singapore", "Shenzhen", "Busan", "Dubai",
            "Rotterdam", "Port Clang", "Dalian", "Xiamen", "Hamburg", "Los Angeles", "Qingdao"};

    int colums = 5;

    public String[][] makePortArray(){
        String[][] portArray;
        int k = 0;
        for(int i = 0; i < ports.length ; i++){
            for(int p = i + 1 ; p < ports.length ; p++){
                k++;
                //System.out.println(k);
                //System.out.println(ports[i] + " ----->>> "+ ports[p] +"  _______"+ p );
            }
        }
        portArray = new String[k-1][colums];
       /* for (int i = 0; i < priceList.length; i++) {
            // Цикл по второй размерности выводит колонки - вывод одной строки
            for (int j = 0; j < priceList[i].length; j++) {
                // Используем оператор print - без перехода на следующую строку
                System.out.print(priceList[i][j]+"_____   ");
            }
*/        return portArray;
    }

    //{{from, to, weight, price}}

    public void makePortsMap(String[][] portArray){

        int raw = 0;
        int colum = 0;
        int h = 1;
        for(int from = 0; from < ports.length ; from++){
            for(int to = from + 1 ; to < ports.length ; to++){

                portArray[raw][colum] = ports[from];//your value
                colum++;

                portArray[raw][colum] = ports[to];
                colum --;

                System.out.println(ports[from] + " <<<----->>> "+ ports[to] +"  _______" + h );
                h++;
            }
                raw++;
        }

        System.out.println(h);
       // addPrice(portArray);

       // printArrayMap(portArray);

    }

    public void printArrayMap(String[][] portArray){
        for(String[] g1 : portArray) {
            for(String g2 : g1) {
                // Печатаем строку из массивов
                System.out.print(g2 + " >> " );
            }
            // Переходим на следующую строку
            System.out.println();
        }
    }

    public void sameData(String[][] priceList){
        for (int i = 0; i < priceList.length; i++) {

            for (int j = 0; j < priceList[i].length - 2; j++) {
                // Используем оператор print - без перехода на следующую строку
                if(priceList[i][j] != null){

                    System.out.println("bopa"/*priceList[i][j]*/);
                }

            }
        }
    }
    public void addPrice(String[][] priceList){
        int raw = 0;
        //int colum = 0;
        Random random = new Random();
        for (int i = 0; i < priceList.length; i++) {
            int colum = 0;
            for (int j = 3; j < priceList[i].length; j++) {
                // Используем оператор print - без перехода на следующую строку
               // sameData(priceList);

               // System.out.println(priceList[i][colum]);
                colum++;
                if (j == 2) {
                    priceList[i][j] = String.valueOf(random.nextInt(15000) + 2500);
                } else if (j == 3) {
                    priceList[i][j] = String.valueOf(random.nextInt(1000) + 100);
                } else {
                    priceList[i][j] = "_44__ ";
                }
            }
        }
    }
}








