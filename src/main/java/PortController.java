public class PortController implements DBimplements {

    private PortDB portDB = new PortDB();
    private String[][] portArray;// = portDB.getPortArray();

    @Override
    public void loadAllDataFreigts() {
        portDB.makePortsMap();
        portArray = portDB.getPortArray();
    }

    @Override
    public void showLowestPrice(String[][] portArray) {
        boolean isSorted2 = false;
        String[][] tempA = new String[1][5];

        while(!isSorted2) {
            isSorted2 = true;
            for (int k = 0; k < portArray.length - 1 ; k++) {
                if(Integer.parseInt(portArray[k][4]) > Integer.parseInt(portArray[k+1][4])){
                    isSorted2 = false;
                    for (int ii = 0; ii < portArray[k].length ; ii++) {
                        tempA[0][ii] = portArray[k][ii];
                        portArray[k][ii] = portArray[k+1][ii];
                        portArray[k+1][ii] = tempA[0][ii];
                    }
                }

            }
        }
        printArrayMap(portArray);

    }


    @Override
    public void showHighestPrice(String[][] portArray) {
        boolean isSorted2 = false;
        String[][] tempA = new String[1][5];

        while(!isSorted2) {
            isSorted2 = true;
            for (int k = 0; k < portArray.length - 1 ; k++) {
                if(Integer.parseInt(portArray[k][4]) < Integer.parseInt(portArray[k+1][4])){
                    isSorted2 = false;
                    for (int ii = 0; ii < portArray[k].length ; ii++) {
                        tempA[0][ii] = portArray[k][ii];
                        portArray[k][ii] = portArray[k+1][ii];
                        portArray[k+1][ii] = tempA[0][ii];
                    }
                }

            }
        }
        printArrayMap(portArray);

       // System.out.println();
    }


    @Override
    public void showHIghtSpeed(String[][] portArray) {
        boolean isSorted2 = false;
        String[][] tempA = new String[1][5];

        while(!isSorted2) {
            isSorted2 = true;
            for (int k = 0; k < portArray.length - 1 ; k++) {
                if(Integer.parseInt(portArray[k][2]) > Integer.parseInt(portArray[k+1][2])){
                    isSorted2 = false;
                    for (int ii = 0; ii < portArray[k].length ; ii++) {
                        tempA[0][ii] = portArray[k][ii];
                        portArray[k][ii] = portArray[k+1][ii];
                        portArray[k+1][ii] = tempA[0][ii];
                    }
                }

            }
        }
        printArrayMap(portArray);
        System.out.println();
    }

    @Override
    public void showLowSpeed(String[][] portArray) {
        boolean isSorted2 = false;
        String[][] tempA = new String[1][5];

        while(!isSorted2) {
            isSorted2 = true;
            for (int k = 0; k < portArray.length - 1 ; k++) {
                if(Integer.parseInt(portArray[k][2]) < Integer.parseInt(portArray[k+1][2])){
                    isSorted2 = false;
                    for (int ii = 0; ii < portArray[k].length ; ii++) {
                        tempA[0][ii] = portArray[k][ii];
                        portArray[k][ii] = portArray[k+1][ii];
                        portArray[k+1][ii] = tempA[0][ii];
                    }
                }
            }
        }
        printArrayMap(portArray);
    }

    @Override
    public void showMinMass(String[][] portArray) {
        boolean isSorted2 = false;
        String[][] tempA = new String[1][5];

        while(!isSorted2) {
            isSorted2 = true;
            for (int k = 0; k < portArray.length - 1 ; k++) {
                if(Integer.parseInt(portArray[k][3]) > Integer.parseInt(portArray[k+1][3])){
                    isSorted2 = false;
                    for (int ii = 0; ii < portArray[k].length ; ii++) {
                        tempA[0][ii] = portArray[k][ii];
                        portArray[k][ii] = portArray[k+1][ii];
                        portArray[k+1][ii] = tempA[0][ii];
                    }
                }
            }
        }
        printArrayMap(portArray);
    }

    @Override
    public void showMaxMass(String[][] portArray) {
        boolean isSorted2 = false;
        String[][] tempA = new String[1][5];

        while(!isSorted2) {
            isSorted2 = true;
            for (int k = 0; k < portArray.length - 1 ; k++) {
                if(Integer.parseInt(portArray[k][3]) < Integer.parseInt(portArray[k+1][3])){
                    isSorted2 = false;
                    for (int ii = 0; ii < portArray[k].length ; ii++) {
                        tempA[0][ii] = portArray[k][ii];
                        portArray[k][ii] = portArray[k+1][ii];
                        portArray[k+1][ii] = tempA[0][ii];
                    }
                }
            }
        }
        printArrayMap(portArray);
    }


    private void printArrayMap(String[][] portArray) {
        for (int i = 0; i < portArray.length; i++) {
            for (int j = 0; j < portArray[i].length; j++) {
                printByColums(i, j);
            }
            System.out.println();
        }
    }

    @Override
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

    @Override
    public void printAllVariants() {
        printArrayMap(portArray);
    }

    public void showHighestPric(){
        showHighestPrice(portArray);
    }
    public void showLowPric(){
        showLowestPrice(portArray);
    }

    public void showHightSpeed(){
        showHIghtSpeed(portArray);
    }

    public void showLowSpeed(){
        showLowSpeed(portArray);
    }


    public void showMaxMass(){
        showMaxMass(portArray);
    }

    public void showMinMass(){
        showMinMass(portArray);
    }


    private void printByColums(int i, int j){
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
