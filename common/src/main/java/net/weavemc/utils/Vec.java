package net.weavemc.utils;

import com.google.common.primitives.Doubles;
import net.weavemc.World;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class Vec implements Cloneable {
    @Getter
    @Setter
    private double x;
    @Getter
    @Setter
    private double y;
    @Getter
    @Setter
    private double z;

    public Vec() {
        this(.0, .0, .0);
    }

    public Vec(float x, float y, float z) {
        this((double) x, y, z);
    }

    public Vec(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double length() {
        return Math.sqrt(MathUtil.square(x) + MathUtil.square(y) + MathUtil.square(z));
    }

    public double lengthSquared() {
        return MathUtil.square(x) + MathUtil.square(y) + MathUtil.square(z);
    }

    @NotNull
    public Vec add(@NotNull Vec vec) {
        x += vec.x;
        y += vec.y;
        z += vec.z;
        return this;
    }

    @NotNull
    public Vec subtract(@NotNull Vec vec) {
        x -= vec.x;
        y -= vec.y;
        z -= vec.z;
        return this;
    }

    @NotNull
    public Vec multiply(@NotNull Vec vec) {
        x *= vec.x;
        y *= vec.y;
        z *= vec.z;
        return this;
    }

    @NotNull
    public Vec divide(@NotNull Vec vec) {
        x /= vec.x;
        y /= vec.y;
        z /= vec.z;
        return this;
    }

    @NotNull
    public Vec copy(@NotNull Vec vec) {
        x = vec.x;
        y = vec.y;
        z = vec.z;
        return this;
    }

    public double distance(@NotNull Vec other) {
        return Math.sqrt(MathUtil.square(x - other.x) + MathUtil.square(y - other.y) + MathUtil.square(y - other.y));
    }

    public double distanceSquared(@NotNull Vec other) {
        return MathUtil.square(x - other.x) + MathUtil.square(y - other.y) + MathUtil.square(y - other.y);
    }

    @Contract("_ -> _")
    @NotNull
    public Vec midpoint(@NotNull Vec other) {
        x = (x + other.x) / 2;
        y = (y + other.y) / 2;
        z = (z + other.z) / 2;
        return this;
    }

    @Contract("_ -> new")
    @NotNull
    public Vec newMidpoint(@NotNull Vec other) {
        double x = (this.x + other.x) / 2;
        double y = (this.y + other.y) / 2;
        double z = (this.z + other.z) / 2;
        return new Vec(x, y, z);
    }

    @NotNull
    public Vec multiply(int m) {
        x *= m;
        y *= m;
        z *= m;
        return this;
    }

    @NotNull
    public Vec multiply(double m) {
        x *= m;
        y *= m;
        z *= m;
        return this;
    }

    @NotNull
    public Vec multiply(float m) {
        x *= m;
        y *= m;
        z *= m;
        return this;
    }

    public double dot(@NotNull Vec other) {
        return x * other.x + y * other.y + z * other.z;
    }

    @SuppressWarnings("UnstableApiUsage")
    public double angle(@NotNull Vec other) {
        double dot = Doubles.constrainToRange(dot(other) / (length() * other.length()), -1.0, 1.0);

        return Math.acos(dot);
    }

    @Contract("_ -> _")
    @NotNull
    public Vec crossProduct(@NotNull Vec o) {
        x = y * o.z - o.y * z;
        y = z * o.x - o.z * x;
        z = x * o.y - o.x * y;
        return this;
    }

    @Contract("_ -> new")
    @NotNull
    public Vec getCrossProduct(@NotNull Vec o) {
        double x = this.y * o.z - o.y * this.z;
        double y = this.z * o.x - o.z * this.x;
        double z = this.x * o.y - o.x * this.y;
        return new Vec(x, y, z);
    }

    @NotNull
    public Vec normalize() {
        double length = length();

        x /= length;
        y /= length;
        z /= length;

        return this;
    }

    @Contract("_ -> new")
    @NotNull
    public Pos toPos(@NotNull World world) {
        return new Pos(world, x, y, z);
    }

    @Contract("_ -> new")
    @NotNull
    public Pos getRelative(@NotNull Pos relative) {
        return new Pos(relative.getWorld(), relative.getX() + x, relative.getY() + y, relative.getZ() + z);
    }

    @Override
    public Vec clone() {
        try {
            return (Vec) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
