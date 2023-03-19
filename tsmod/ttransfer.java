package tsmod;

public interface ttransfer {
    /**
     * @param dst   destination Storage
     * @param item  toy to transfer
     * @param amount    amount to transfer
     * @return false if not possible
     * @return true on succees
     */
    boolean transfer(Storage dst, Toy item, int amount);
    boolean isPresent(Toy item);

}