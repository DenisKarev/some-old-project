package tsmod;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ToyLottery {
    public Storage lotst;
    Random r;

    public ToyLottery() {  // Storage st
        this.lotst = new Storage();
        r = new Random();
    }

    public List<String> lotteryPlay(int times) {
        List<String> ptoys = new ArrayList<>(times);
        for (int i = 0; i < times; i++) {
            System.out.println(r.nextInt(100));
            // ptoys.add(100);
        }
        return ptoys;
    }
}
