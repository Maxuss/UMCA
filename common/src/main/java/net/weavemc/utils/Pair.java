package net.weavemc.utils;

public record Pair<F, S>(F first, S second) implements Cloneable {

    @Override
    public String toString() {
        return "Pair{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }

    @SuppressWarnings("unchecked")
    @Override
    public Pair<F, S> clone() {
        try {
            return (Pair<F, S>) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
