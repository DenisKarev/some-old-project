package tsmod;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Storage implements Iterable<Toy>, ttransfer {
    protected List<Toy> storage;
    protected int lastId;

    public Storage() {
        this.storage = new ArrayList<Toy>();
        this.lastId = 0;
    }

    public Toy getFromStorage(int i) {
        if (i >= 0) {
            for (Toy toy : storage) {
                if (toy.id == i) {
                    return new Toy(toy);
                }
            }
        }
        return null;
    }

    public void addToStorage(Toy item) {
        if (this.isPresent(item)) {
            int idx = this.findToy(item);
            this.storage.get(idx).quantity += item.quantity;
        } else {
            item.setId(lastId++);
            this.storage.add(new Toy(item));
        }
        // System.out.println(this.storage + " " + this.lastId);
    }

    /**
     * @param item Toy
     * @return int : index of a toy found
     * or -1 if not found
     */
    private int findToy(Toy item) {
        if (this.isPresent(item)) {
            int ssize = this.storage.size();
            for (int i = 0; i < ssize; i++) {
                if (this.storage.get(i).name.equals(item.name)) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public Iterator<Toy> iterator() {
        return this.storage.iterator();
    }

    @Override
    public boolean transfer(Storage dst, Toy t, int amount) {
        if (t == null || amount <= 0 || dst == null || !this.isPresent(t)) {
            return false;
        } else {
            int idx = this.findToy(t);
            int thisamount = this.storage.get(idx).quantity;
            if (amount < thisamount) {
                this.storage.get(idx).quantity -= amount;
                if (dst.isPresent(t)) {
                    idx = dst.findToy(t);
                    dst.storage.get(idx).quantity += amount;
                } else {
                    t.quantity = amount;
                    dst.addToStorage(t);
                }
                return true;
            } else if (amount == thisamount) {
                this.storage.remove(idx);
                if (dst.isPresent(t)) {
                    idx = dst.findToy(t);
                    dst.storage.get(idx).quantity += amount;
                } else {
                    t.quantity = amount;
                    dst.addToStorage(t);
                }
                return true;
            }
        }
        return false;
    }

    @Override
    /**
     * Check presence of Toy in Storage
     * @param item
     * @return
     */
    public boolean isPresent(Toy item) {
        for (Toy toy : this.storage) {
            if (toy.name.equals(item.name)) {
                return true;
            }
        }
        return false;
    }

    public int getSize() {
        return this.storage.size();
    }

}
