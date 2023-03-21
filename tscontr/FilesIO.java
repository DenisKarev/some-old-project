package tscontr;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;

import tsmod.Storage;
import tsmod.Toy;

public class FilesIO {

    public boolean readFile(File fr, Storage stor) {
        // TODO Auto-generated method stub
        String str = "";
        boolean result = false;
        if (fr.exists() && !fr.isDirectory()) {
            try {
                FileReader f = new FileReader(fr, Charset.forName("UTF-8"));
                BufferedReader bufR = new BufferedReader(f);
                if (bufR.ready()) {
                    String l = bufR.readLine();
                    if (l != null && l.equals("ToysStore;")) {
                        while ((str = bufR.readLine()) != null) {
                            String s[] = str.split(";");
                            stor.addToStorage(new Toy(s[0], Integer.parseInt(s[1]), Integer.parseInt(s[2])));
                        }
                        result = true;
                    }
                }
                bufR.close();
            } catch (FileNotFoundException e) {
                System.out.println(e);
            } catch (IOException e) {
                System.out.println(e);
            }
        }
        return result;
    }

    public void writeToysToFile(Storage st, File f) {
        // TODO Auto-generated method stub
        // boolean result = false;

        try (FileWriter bufW = new FileWriter(f, false)) {
            bufW.append("ToysStore;" + System.lineSeparator());
            for (Toy toy : st) {
                this.writeToy(toy, bufW);
            }
            bufW.flush();
            bufW.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private void writeToy(Toy toy, FileWriter bw) throws IOException {
        String strToy = String.format("%s;%s;%s;",
                // toy.getId(),
                toy.getTitle(),
                toy.getQuantity(),
                toy.getRate());
        // System.out.println(strToy);
        bw.append(strToy);
        bw.append(System.lineSeparator());
    }

    public void writeFromLottery(File fout, String name) {
        try (FileWriter bufW = new FileWriter(fout, true)) {
            // bufW.append("Prizes list:" + System.lineSeparator());
            bufW.append(name);
            bufW.append(System.lineSeparator());
            bufW.flush();
            bufW.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}