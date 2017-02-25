package edu.sundot.adt;

import java.security.InvalidParameterException;

/**
 * Created by rahul on 2/24/17.
 */
public class Pair {

    private int item1;
    private int item2;

    public Pair(int item1, int item2) {
        this.item1 = item1;
        this.item2 = item2;
    }

    public int getItem1() {
        return item1;
    }

    public void setItem1(int item1) {
        this.item1 = item1;
    }

    public int getItem2() {
        return item2;
    }

    public void setItem2(int item2) {
        this.item2 = item2;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null)
            return false;

        if (!(o instanceof Pair))
            throw new InvalidParameterException("Pair type is accepted.");

        Pair pair = (Pair) o;
        return this.item1 == pair.item1 && this.item2 == pair.item2;
    }
}
