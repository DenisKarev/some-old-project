package tscontr;

import java.io.File;
import java.util.Scanner;

import tsmod.Storage;
import tsmod.Toy;

public class Tscontr {
    Scanner s = new Scanner(System.in);
    File in;
    File out;
    long tBegin;
    long tEnd;
    String timeR;

    public boolean checkInput() {
        return false;
    }

    public boolean addToy(Storage st, String toy) {
        String[] s = toy.split(" ");
        if (s.length == 3) {
            Toy t = new Toy(s[0], Integer.parseInt(s[1]), Double.parseDouble(s[2]));
            st.addToStorage(t);
        }
        return false;
    }

    public void start_end_times(int i) {
        switch (i) {
            case 0:
                this.tBegin = System.currentTimeMillis();
                break;
            case 1:
                this.tEnd = System.currentTimeMillis();
                this.timeR = String.format("time=" + (tEnd - tBegin) + "ms");
                break;
            default:
                break;
        }
    }

    public String getTimeR() {
        return this.timeR;
    }

    public int inputMenu(String check) {
        String inp = s.nextLine();
        if (inp.isEmpty() || !check.contains(inp)) {
            return -1;
        } else {
            return Integer.parseInt(inp);
        }
    }
}
