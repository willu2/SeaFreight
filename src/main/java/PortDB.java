public class PortDB {

    int colums = 4;

    int col = 2;

    //String
    ;//{{from, to, weight, price}}

    public static String[] ports = {"Shanghai", "Singapore", "Shenzhen", "Busan", "Dubai",
            "Rotterdam", "Port Clang", "Dalian", "Xiamen", "Hamburg", "Los Angeles", "Qingdao"};

    public String[][] makeDestination(String[] ports){
        String[][] priceList;
        int k = 0;
        for(int i = 0; i < ports.length ; i++){
             for(int p = 0; p < ports.length ; p++){
                 if(i == p) continue;
                    k++;
                    //System.out.println(ports[i] + " ----->>> "+ ports[p] +"  _______"+ p );
            }
        }
         priceList = new String[k][colums];

        int colu = 0;
        int raw = 0;

        for(int i = 0; i < ports.length ; i++){
            for(int p = 0; p < ports.length ; p++){
                if(i == p) continue;

                            priceList[raw][colu] = ports[i];//your value
                            colu++;
                            priceList[raw][colu] = ports[p];
                            colu --;
                            //System.out.println(ports[i] + " ----->>> "+ ports[p] +"  _______"+ p );
                raw++;
            }

        }

        /*for (int r = 0; r < priceList.length; r++) {
            for (int c = 0; c < priceList[r].length; c++) {
                priceList[r][c] = "  hello" + c;//your value
            }
        }*/
        /*for(int i = 0; i < ports.length ; i++){
            for(int p = 0; p < ports.length ; p++){
                if(i == p) continue;
                k++;
                priceList[i][p] = ports[i];
                //System.out.println(ports[i] + " ----->>> "+ ports[p] +"  _______"+ p );
            }
        }*/

        for(String[] g1 : priceList) {
            for(String g2 : g1) {
                // Печатаем строку из массивов
                System.out.print(g2 + "  " );
            }
            // Переходим на следующую строку
            System.out.println();
        }
       /* for (int i = 0; i < priceList.length; i++) {
            // Цикл по второй размерности выводит колонки - вывод одной строки
            for (int j = 0; j < priceList[i].length; j++) {
                // Используем оператор print - без перехода на следующую строку
                System.out.print(priceList[i][j]+"_____   ");
            }
*/
           // System.out.println(priceList.length);
       return priceList;

    }

    public void addPrice(String[][] priceList, String[] ports){
       // System.out.println(priceList.length);
        for (int i = 0; i < ports.length; i++) {
            for (int j = 0; j < ports.length; j++) {
                //if(i == j) continue;
                    //System.out.println(ports[i] + " ----->>> "+ ports[j] +"  _______"+ j );
                //if(j == 0){
                    priceList[i][j] = String.valueOf(0);
               /* }else if(j == 1){
                    priceList[i][j] = ports[i];
                }else if(j == 2){
                    priceList[i][j] = String.valueOf("LSLSLS");
                }else if(j == 3){
                    priceList[i][j] = String.valueOf(".l,l");
                }*/
            }
        }

        for (int i = 0; i < priceList.length; i++) {
            // Цикл по второй размерности выводит колонки - вывод одной строки
            for (int j = 0; j < priceList[i].length; j++) {
                // Используем оператор print - без перехода на следующую строку
                System.out.print(priceList[i][j]+"_____ ");
            }
            System.out.println();
        }
        System.out.println(priceList.length);
    }
    }

