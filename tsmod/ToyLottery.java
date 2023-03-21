package tsmod;

import java.util.Random;

public class ToyLottery {
    public Storage lotst;
    Random r;

    public ToyLottery() { // Storage st
        this.lotst = new Storage();
        r = new Random();
    }

    public Toy lotteryPlay() {
        // List<String> ptoys = new ArrayList<>(times);
        int totRate = this.lotst.storage.stream().mapToInt(Toy::getRate).sum();
        int rndValue = r.nextInt(totRate);
        int rateSum = 0;
        boolean playing = true;
        

        while (playing) {
            for (int i = 0; i < this.lotst.storage.size(); i++) {
                rateSum += this.lotst.storage.get(i).rate;
                if (rndValue < rateSum) {
                    Toy prize = new Toy(this.lotst.storage.get(i));
                    int quantity = this.lotst.storage.get(i).getQuantity();
                    if (quantity == 1) {
                        this.lotst.storage.remove(i);
                    } else {
                        this.lotst.storage.get(i).setQuantity(quantity - 1);
                    }
                    playing = false;
                    return prize;
                }
            }
        }
        return null;
    }
    public int getStorageOverall() {
        int toysTally = 0;
        for (Toy toy : lotst) {
            toysTally += toy.getQuantity();
        }
        return toysTally;
    }
}