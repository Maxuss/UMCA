package net.weavemc.utils;

import java.util.concurrent.Callable;

@FunctionalInterface
public interface Producer<T> {
    T produce();
}
