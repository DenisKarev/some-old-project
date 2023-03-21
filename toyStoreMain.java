// import tsmod.Toy;
import tsmod.ToyShop;

public class toyStoreMain {
    public static void main(String[] args) {
        ToyShop toyS = new ToyShop();

        // ToyLottery toyL = new ToyLottery();

        // toyS.sc.start_end_times(0);

        // toyS.sc.addToy(toyS.shopst, "Wolf 100 25");
        // toyS.shopst.addToStorage(new Toy("Fox", 100, 10));
        // toyS.shopst.addToStorage(new Toy("Bear", 100, 10));
        // toyS.shopst.addToStorage(new Toy("Falcon", 100, 10));
        // toyS.shopst.addToStorage(new Toy("Horse", 100, 10));
        // toyS.shopst.addToStorage(new Toy("Tiger", 100, 10));
        // toyS.shopst.addToStorage(new Toy("Donkey", 100, 10));


        // toyS.shopst.transfer(toyS.toyl.lotst, toyS.shopst.getFromStorage(0), 50);
        // toyS.shopst.transfer(toyS.toyl.lotst, toyS.shopst.getFromStorage(1), 50);
        // toyS.shopst.transfer(toyS.toyl.lotst, toyS.shopst.getFromStorage(2), 50);
        // toyS.shopst.transfer(toyS.toyl.lotst, toyS.shopst.getFromStorage(3), 50);
        // toyS.shopst.transfer(toyS.toyl.lotst, toyS.shopst.getFromStorage(4), 50);

        // toyS.sv.viewStorage(toyS.toyl.lotst);
        // System.out.println();
        // toyS.sv.viewStorage(toyS.shopst);
        // // System.out.println();
        // toyS.toyl.lotst.transfer(toyS.shopst, toyS.toyl.lotst.getFromStorage(0), 50);
        // toyS.toyl.lotst.transfer(toyS.shopst, toyS.toyl.lotst.getFromStorage(1), 50);
        // toyS.toyl.lotst.transfer(toyS.shopst, toyS.toyl.lotst.getFromStorage(2), 50);

        // toyS.sv.viewStorage(toyS.shopst);
        // System.out.println();
        // toyS.sv.viewStorage(toyS.toyl.lotst);
        // System.out.println();
        
        // toyS.sc.addToy(toyS.shopst, "Wolf 100 25");
        // toyS.shopst.transfer(toyS.toyl.lotst, toyS.shopst.getFromStorage(6), 100);
        // toyS.sv.viewStorage(toyS.shopst);
        // System.out.println();

        // toyS.sv.viewStorage(toyS.toyl.lotst);
        // toyS.sc.fio.writeToysToFile(toyS.shopst, toyS.sc.fileIn);

        // toyS.sc.start_end_times(1);
        // System.out.println(toyS.sc.getTimeR());

        // for (String string : "name of toy 100 20".split(" ")) {
        //     // System.out.println(string);
        //     try {
        //         System.out.println(Integer.parseInt(string));
        //     } catch (Exception e) {
        //         System.out.println(e);
        //     }
        // }
        // System.out.println("name of toy 100 20".split(" "));
        // System.out.println("Имя игрушки 100 20".split(" "));
        //  'Имя игрушки' 100 20

        System.out.println("ts.execute returns: " + toyS.execute());
    }
}