package HashString;

import java.util.*;

public class HashTableImpl<T> {
    private final int tableSize;
    private final ArrayList<Optional<T>> tArrayList;

    public HashTableImpl(int tableSize) {
        this.tableSize = tableSize;
        this.tArrayList = new ArrayList<>(Collections.nCopies(this.tableSize, Optional.empty()));
    }

    private int getHash(String s) {
        return Math.abs(s.hashCode()) % this.tableSize;
    }

    public boolean insert(String key, T value) {
        int hash = getHash(key);
        int starter = hash;

        while (this.tArrayList.get(hash).isPresent()) {
            hash = (hash + 1) % this.tableSize;
            if (hash == starter) {
                return false;
            }
        }

        this.tArrayList.set(hash, Optional.of(value));
        return true;
    }

    public Optional<T> get(String key) {
        int hash = getHash(key);
        int next = (hash + 1) % this.tableSize;
        int starter = next;

        if (this.tArrayList.get(hash).isEmpty()) {
            return Optional.empty();
        }

        while (this.tArrayList.get(next).isPresent()) {
            next = (next + 1) % this.tableSize;

            if (next == starter) {
                return Optional.empty();
            }
        }

        return Optional.of(this.tArrayList.get(next == 0 ? this.tableSize - 1 : next - 1).get());
    }

    public boolean remove(String key) {
        var v = this.get(key);

        if (v.isEmpty()) {
            return false;
        }

        for (int i = 0; i < this.tableSize; i++) {
            if (this.tArrayList.get(i).isPresent() && this.tArrayList.get(i).get().equals(v.get())) {
                this.tArrayList.set(i, Optional.empty());
                return true;
            }
        }

        return false;
    }
}
