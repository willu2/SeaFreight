interface DBimplements {

        void showLowestPrice(String[][] portArray);
        void showHighestPrice(String[][] portArray);
        void showHIghtSpeed(String[][] portArray);
        void showLowSpeed(String[][] portArray);
        void showMinMass(String[][] portArray);
        void showMaxMass(String[][] portArray);

        //print All data like table;
        //void printArrayMap(String[][] portArray);
        void searchByPrice(int casch);
        void printAllVariants();

        void loadAllDataFreigts();
}
