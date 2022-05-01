package net.weavemc.utils;

import com.google.common.base.Objects;

public record Triple<A, B, C>(A first, B second, C third) implements Cloneable {
    @Override
    public String toString() {
        return "Triple{" +
                "first=" + first +
                ", second=" + second +
                ", third=" + third +
                '}';
    }

    @SuppressWarnings("unchecked")
    @Override
    public Triple<A, B, C> clone() {
        try {
            return (Triple<A, B, C>) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triple<?, ?, ?> triple = (Triple<?, ?, ?>) o;
        return Objects.equal(first, triple.first) && Objects.equal(second, triple.second) && Objects.equal(third, triple.third);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(first, second, third);
    }
}
