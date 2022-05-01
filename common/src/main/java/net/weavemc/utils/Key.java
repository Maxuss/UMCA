package net.weavemc.utils;

import lombok.Getter;

public class Key {
    @Getter
    private final String namespace;
    @Getter
    private final String path;

    public Key(String namespace, String path) {
        this.namespace = namespace;
        this.path = path;
    }

    public static Key minecraft(String path) {
        return new Key("minecraft", path);
    }

    @Override
    public String toString() {
        return namespace + ":" + path;
    }
}
