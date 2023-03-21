package tscontr;

// import java.util.Scanner;
import java.io.Console;
import java.io.File;

import tsmod.Storage;
import tsmod.Toy;

public class Tscontr {
    private Console con = System.console();
    // private Scanner s = new Scanner(System.in);

    public FilesIO fio;

    public File fileIn;// = new File(filesettings.storage);
    public File fileOut;// = new File(filesettings.output);

    private long tBegin;
    private long tEnd;
    private String timeR;

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
        String inp = con.readLine();
        if (inp.isEmpty() || !check.contains(inp)) {
            return -1;
        } else {
            return Integer.parseInt(inp);
        }
    }

    public String toyInput() {
        String inp = con.readLine();
        if (inp == null || inp == "") {
            return null;
        } else {
            String par[] = inp.split(" ");
            if (par.length < 3) {
                return null;
            } else {
                try {
                    int r = Integer.parseInt(par[par.length - 1]);
                    int q = Integer.parseInt(par[par.length - 2]);
                    if (q > 0 && (r > 0 && r <= 100)) {
                        return inp;
                    }
                } catch (Exception e) {
                    // TODO: handle exception
                    System.out.println(e);
                }
                return null;
            }
        }
    }
}
// name of toy 100 20