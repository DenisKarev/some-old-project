package tsmod;

import tscontr.Tscontr;
// import tsmod.Toy;
import tsview.Tsview;

public class ToyShop {
    public Tsview sv;
    public Tscontr sc;
    public Storage shopst;
    public ToyLottery toyl;

    public ToyShop() {
        this.sv = new Tsview();
        this.sc = new Tscontr();
        this.shopst = new Storage();
        this.toyl = new ToyLottery();
    }

    public int execute() {
        boolean running = true;
        int choice = 0;
        int menu = 0; // to know where am i in menus
        // this.sv.menu(menu); // prints top menu first time

        while (running) {
            this.sv.menu(menu);
            choice = this.sc.inputMenu("1230"); // "120" file menu disabled
            switch (choice) {
                case 0:
                    if (menu == 0) {
                        running = false;
                    } else {
                        menu = 0;
                    }
                    break;
                case 1:
                    menu = 1;
                    // choice = this.shop(menu);
                    menu = this.secondMenu(menu);
                    break;
                case 2:
                    menu = 2;
                    // choice = this.lottery(menu);
                    menu = this.secondMenu(menu);
                    break;
                case 3:
                    menu = 3;
                    // choice = this.fromFile(menu);
                    this.sc.fio.readFile(this.sc.fileIn, this.shopst);
                    break;
                case -1:
                    this.sv.errInput(menu);
                    break;
                default:
                    break;
            }
        }
        return 0;
    }

    private int secondMenu(int menu) {
        boolean smRun = true;
        int choice;
        while (smRun) {
            this.sv.menu(menu);
            choice = this.sc.inputMenu("12340");
            switch (choice) {
                case 1:
                    if (menu == 1) { // Show shop storage
                        this.sv.viewStorage(this.shopst);
                    } else { // Show lottery storage.
                        this.sv.viewStorage(this.toyl.lotst);
                    }
                    break;
                case 2:
                    if (menu == 1) { // Add toy
                        this.sv.strOut("Add toy space separated -> Name Quantity DropRate\n");
                        String toy = this.sc.toyInput();
                        if (toy != null) {
                            this.sc.addToy(shopst, toy);
                        } else {
                            this.sv.errInput(menu);
                        }
                    } else { // Launch the LOTTERY

                    }
                    break;
                case 3:
                    if (menu == 1) { // Edit toy drop rate

                    } else { // Edit toy drop rate

                    }
                    break;
                case 4:
                    if (menu == 1) { // Transfer toy(s) to Lottery

                    } else { // Transfer toy(s) back to Store.

                    }
                    break;
                case 0:
                    smRun = false;
                    menu = 0;
                    break;
                default:
                    break;
            }
        }
        return menu;
    }

    // private int shop(int menu) {
    // boolean shopR = true;
    // int choice;
    // while (shopR) {
    // choice = this.sc.inputMenu("1230");
    // }
    // return menu;
    // }

    // private int lottery(int menu) {
    // int choice;
    // boolean lotteryR = true;
    // return menu;
    // }

    // private int fromFile(int menu) {
    // int ch = this.sc.inputMenu("1230");
    // return 0;
    // }

    public boolean init() {
        if (sc.checkInput()) {
            return true;
        }
        return false;
    }

}
