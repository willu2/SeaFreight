import java.util.Random;

public class PortDB {

    public static String[] ports = {"Shanghai", "Singapore", "Shenzhen", "Busan", "Dubai",
            "Rotterdam", "Port Clang", "Dalian", "Xiamen", "Hamburg", "Los Angeles", "Qingdao"};

    int colums = 5;

    public String[][] makePortArray(){
        String[][] portArray;
        int k = 0;
        for(int i = 0; i < ports.length ; i++){
            for(int p = 0; p < ports.length ; p++){
                if(i == p) continue;
                k++;
                //System.out.println(ports[i] + " ----->>> "+ ports[p] +"  _______"+ p );
            }
        }
        portArray = new String[k][colums];
       /* for (int i = 0; i < priceList.length; i++) {
            // Цикл по второй размерности выводит колонки - вывод одной строки
            for (int j = 0; j < priceList[i].length; j++) {
                // Используем оператор print - без перехода на следующую строку
                System.out.print(priceList[i][j]+"_____   ");
            }
*/        return portArray;
    }

    ;//{{from, to, weight, price}}

    public void makePortsMap(String[][] portArray){

        int raw = 0;
        int colum = 0;

        for(int from = 0; from < ports.length ; from++){
            for(int to = 0; to < ports.length ; to++){
                if(from == to) continue;

                portArray[raw][colum] = ports[from];//your value
                colum++;
                portArray[raw][colum] = ports[to];
                colum --;
                //System.out.println(ports[i] + " ----->>> "+ ports[p] +"  _______"+ p );
                raw++;
            }
        }
        addPrice(portArray);

        printArrayMap(portArray);

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

    public void addPrice(String[][] priceList){
        int raw = 0;
        int colum = 0;
        Random random = new Random();
        for (int i = 0; i < priceList.length; i++) {
            for (int j = 2; j < priceList[i].length; j++) {
                // Используем оператор print - без перехода на следующую строку
                if(j==2){
                    priceList[i][j] = String.valueOf(random.nextInt(15000)+2500);
                }else if(j==3){
                    priceList[i][j] = String.valueOf(random.nextInt(1000)+100);
                }else {
                    priceList[i][j] = "_44__ ";
                }
            }
        }
    }
}

