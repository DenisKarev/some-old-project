import tsmod.ToyLottery;
import tsmod.Toy;
import tsmod.ToyShop;

public class toyStoreMain {
    public static void main(String[] args) {
        ToyShop toyS = new ToyShop();
        ToyLottery toyL = new ToyLottery();

        // toyS.sc.start_end_times(0);

        toyS.sc.addToy(toyS.shopst, "Wolf 100 25");
        toyS.shopst.addToStorage(new Toy("Fox", 100, 10));
        toyS.shopst.addToStorage(new Toy("Bear", 100, 10));
        toyS.shopst.addToStorage(new Toy("Falcon", 100, 10));
        toyS.shopst.addToStorage(new Toy("Horse", 100, 10));
        toyS.shopst.addToStorage(new Toy("Tiger", 100, 10));
        toyS.shopst.addToStorage(new Toy("Donkey", 100, 10));

        System.out.println("ts.execute returns: " + toyS.execute());

        toyS.shopst.transfer(toyL.lotst, toyS.shopst.getFromStorage(0), 50);
        toyS.shopst.transfer(toyL.lotst, toyS.shopst.getFromStorage(1), 50);
        toyS.shopst.transfer(toyL.lotst, toyS.shopst.getFromStorage(2), 50);
        toyS.shopst.transfer(toyL.lotst, toyS.shopst.getFromStorage(3), 50);
        toyS.shopst.transfer(toyL.lotst, toyS.shopst.getFromStorage(4), 50);

        // toyS.sv.viewStorage(toyL.lotst);
        // System.out.println();
        // toyS.sv.viewStorage(toyS.shopst);
        // System.out.println();
        toyL.lotst.transfer(toyS.shopst, toyL.lotst.getFromStorage(0), 50);
        toyL.lotst.transfer(toyS.shopst, toyL.lotst.getFromStorage(1), 50);
        toyL.lotst.transfer(toyS.shopst, toyL.lotst.getFromStorage(2), 50);

        // toyS.sv.viewStorage(toyS.shopst);
        // System.out.println();
        // toyS.sv.viewStorage(toyL.lotst);
        // System.out.println();

        toyS.sc.addToy(toyS.shopst, "Wolf 100 25");
        // toyS.shopst.transfer(toyL.lotst, toyS.shopst.getFromStorage(6), 100);
        toyS.sv.viewStorage(toyS.shopst);
        // toyS.sv.viewStorage(toyL.lotst);

        // toyS.sc.start_end_times(1);
        // System.out.println(toyS.sc.getTimeR());
    }
}