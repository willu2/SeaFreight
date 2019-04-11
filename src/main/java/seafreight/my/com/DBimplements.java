package seafreight.my.com;

interface DBimplements {

        void showLowestPrice(String[][] portArray);
        void showHighestPrice(String[][] portArray);
        void showHightSpeed(String[][] portArray);
        void showLowSpeed(String[][] portArray);
        void showMinMass(String[][] portArray);
        void showMaxMass(String[][] portArray);

        void searchByPrice(int casch);

        void printAllVariants();
        void loadAllDataFreigts();
}
