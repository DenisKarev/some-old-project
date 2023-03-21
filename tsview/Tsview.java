package tsview;

import tsmod.Storage;
import tsmod.Toy;

public class Tsview {

    protected String title0;
    protected String title1;
    protected String title2;
    protected String menu0;
    protected String menu1;
    protected String menu2;
    
    public Tsview() {
        this.initMenus();
    }

    private void initMenus() {
        this.title0 = "ToyStore top menu\n";
        this.title1 = "Store menu !\n";
        this.title2 = "Lottery menu !\n";
        this.menu0 = "1.\tShop menu.\n"+
                    "2.\tLottery menu.\n"+
                    "3.\tRead toys from file\n"+
                    "4.\tWrite toys to file\n"+
                    "0.\tExit\nEnter your choice";

        this.menu1 = "1.\tShow shop storage.\n"+
                    "2.\tAdd toy\n"+
                    "3.\tEdit toy drop rate\n"+
                    "4.\tTransfer toy(s) to Lottery.\n"+
                    "5.\tTransfer all toys to Lottery!!!\n"+
                    "0.\tPrevious menu\n"+
                    "Enter your choice:";

        this.menu2 = "1.\tShow lottery storage.\n"+
                    "2.\tLaunch the LOTTERY!!\n"+
                    "3.\tEdit toy drop rate\n"+
                    "4.\tTransfer toy(s) back to Store.\n"+
                    "5.\tTransfer all toys back to Store!!!\n"+
                    "0.\tPrevious menu\n"+
                    "Enter your choice:";
    }

    public void viewStorage(Storage st) {
        if (st.getSize() != 0) {
            System.out.println("id\tName\t\tQuantity\tDropRate");
            for (Toy t : st) {
                System.out.println(t);
            }
            System.out.println();
        } else {
            System.out.println("Storage is EMPTY!");
        }
    }

    public void menu(int menu) {
        // StringBuilder sb = new StringBuilder();
        switch (menu) {
            case 0:
                System.out.println(this.title0 + this.menu0);
                break;
            case 1:
                System.out.println(this.title1 + this.menu1);
                break;
            case 2:
                System.out.println(this.title2 + this.menu2);
                break;
            default:
                break;
        }
        // return 0;
    }

    public void errInput(int menu) {
        System.out.println("Invalid input try again");
    }

    public void strOut(String string) {
        System.out.println(string);
    }
}
