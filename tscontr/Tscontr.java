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

    public Tscontr() {
        this.fileIn = new File(filesettings.storage);
        this.fileOut = new File(filesettings.output);
        this.fio = new FilesIO();
    }

    public int inputInt() {
        String inp = con.readLine();
        try {
            int id = Integer.parseInt(inp);
            return id;
        } catch (Exception e) {
            // TODO: handle exception
            System.err.println(e);
            return -1;
        }
    }

    public boolean addToy(Storage st, String toy) {
        String[] s = toy.split(" ");
        String name = "";
        if (s.length >= 3) {
            if (s.length > 3) {
                for (int i = 0; i < s.length-3; i++) {
                    name += s[i] + " ";
                }
                name += s[s.length-2];
            } else {
                name = s[0];
            }
            Toy t = new Toy(name, Integer.parseInt(s[s.length - 1]), Integer.parseInt(s[s.length - 2]));
            st.addToStorage(t);
            return true;
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

    public boolean changeDrop(Storage st, Toy t, int rate) {
        if (!st.isPresent(t)) {
            return false;
        } else {
            if (rate > 100) {
                rate = 100;
            }
            if (rate < 0) {
                return false;
            }
            st.setToyRate(t.getId(), rate);
            return true;
        }
    }
}
// name of toy 100 20