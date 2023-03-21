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
            choice = this.sc.inputMenu("12340"); // "120" file menu disabled
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
                    // menu = 3;
                    // choice = this.fromFile(menu);
                    this.sc.fio.readFile(this.sc.fileIn, this.shopst);
                    break;
                case 4:
                    // menu = 4;
                    // choice = this.fromFile(menu);
                    this.sc.fio.writeToysToFile(shopst, this.sc.fileIn);
                    ;
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
            int id = 0;
            int value = 0;
            boolean action = false;
            this.sv.menu(menu);
            choice = this.sc.inputMenu("123450");
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
                        this.sv.strOut("How many times play the lottery? :");
                        value = this.sc.inputInt();
                        if (value < 0 || value > this.toyl.getStorageOverall()) {
                            this.sv.strOut("Can't do that! Some values are wrong!");
                        } else {
                            this.sc.fio.writeFromLottery(this.sc.fileOut, "Lottery " + value + " prizes");
                            for (int i = 0; i < value; i++) {
                                Toy t = this.toyl.lotteryPlay();
                                this.sc.fio.writeFromLottery(this.sc.fileOut, t.getTitle());
                            }
                        }
                    }
                    break;
                case 3:
                    this.sv.strOut("Enter yot ID to change:");
                    id = this.sc.inputInt();
                    this.sv.strOut("Enter new Drop Rate:");
                    value = this.sc.inputInt();
                    if (menu == 1) { // Edit toy drop rate
                        action = this.sc.changeDrop(this.shopst, this.shopst.getFromStorage(id), value);
                        if (action) {
                            this.sv.viewStorage(shopst);
                        }
                    } else { // Edit toy drop rate
                        action = this.sc.changeDrop(this.toyl.lotst, this.toyl.lotst.getFromStorage(id), value);
                        if (action) {
                            this.sv.viewStorage(shopst);
                        }
                    }
                    break;
                case 4:
                    this.sv.strOut("Enter yot ID to transfer:");
                    id = this.sc.inputInt();
                    this.sv.strOut("Enter AMONT to transfer:");
                    value = this.sc.inputInt();
                    if (menu == 1) { // Transfer toy(s) to Lottery
                        action = this.shopst.transfer(this.toyl.lotst, this.shopst.getFromStorage(id), value);
                        if (action) {
                            this.sv.strOut("Done");
                        }
                    } else { // Transfer toy(s) back to Store.
                        action = this.toyl.lotst.transfer(this.shopst, this.toyl.lotst.getFromStorage(id), value);
                        if (action) {
                            this.sv.strOut("Done");
                        }
                    }
                    break;
                case 5:
                    if (menu == 1) { // Transfer ALL toy to Lottery
                        int stsize = this.shopst.getSize();
                        for (int i = 0; i < stsize; i++) {
                            action = this.shopst.transfer(this.toyl.lotst, this.shopst.getFromStorage(i),
                                                            this.shopst.getFromStorage(i).getQuantity());
                        }
                        if (action) {
                            this.sv.strOut("Done");
                        }
                    } else { // Transfer ALL toy back to Store.
                        int stsize = this.toyl.lotst.getSize();
                        for (int i = 0; i < stsize; i++) {
                            action = this.toyl.lotst.transfer(this.shopst, this.toyl.lotst.getFromStorage(i),
                                                                this.toyl.lotst.getFromStorage(i).getQuantity());
                        }
                        if (action) {
                            this.sv.strOut("Done");
                        }
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

}
