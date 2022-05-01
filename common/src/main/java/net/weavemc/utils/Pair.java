package net.weavemc.utils;

import com.google.common.base.Objects;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public record Pair<F, S>(F first, S second) implements Cloneable {
    @Override
    public @NotNull String toString() {
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

    @Override
    public boolean equals(@Nullable Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equal(first, pair.first) && Objects.equal(second, pair.second);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(first, second);
    }
}
