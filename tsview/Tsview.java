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
        this.init();
    }

    private void init() {
        this.title0 = "ToyStore  $name!\n";
        this.title1 = "Store menu !\n";
        this.title2 = "Lottery menu !\n";
        this.menu0 = "1.\tShop menu.\n"+
                    "2.\tLottery menu.\n"+
                    "3.\tRead toys from file\n"+
                    "0.\tExit\nEnter your choice";
        this.menu1 = "1.\tShow shop storage.\n"+
                    "2.\tAdd toy\n"+
                    "3.\tEdit toy drop rate\n"+
                    "4.\tTransfer toy(s) to Lottery.\n"+
                    "0.\tPrevious menu\n";
        this.menu2 = "1.\tShow lottery storage.\n"+
                    "2.\tLaunch the LOTTERY!!\n"+
                    "3.\tEdit toy drop rate\n"+
                    "4.\tTransfer toy(s) back to Store.\n"+
                    "0.\tPrevious menu\n";
    }

    public void viewStorage(Storage st) {
        if (st.getSize() != 0) {
            for (Toy t : st) {
                System.out.println(t);
            }
        } else {
            System.out.println("Empty Storage!");
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
        System.out.println("Error input try again");
    }
}
