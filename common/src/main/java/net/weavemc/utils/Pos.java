package net.weavemc.utils;

import net.weavemc.World;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public class Pos implements Cloneable {
    private Reference<World> world;
    @Getter
    @Setter
    private double x;
    @Getter
    @Setter
    private double y;
    @Getter
    @Setter
    private double z;
    @Getter
    @Setter
    private double yaw;
    @Getter
    @Setter
    private double pitch;

    public Pos(World world, int x, int y, int z) {
        this(world, (double) x, y, z);
    }

    public Pos(World world, float x, float y, float z) {
        this(world, (double) x, y, z);
    }

    public Pos(World world, double x, double y, double z) {
        this(world, x, y, z, .0, .0);
    }

    public Pos(@NotNull World world, double x, double y, double z, double yaw, double pitch) {
        if(!world.isLoaded())
            throw new IllegalStateException("Tried to create a position in an unloaded world!");

        this.world = new WeakReference<>(world);
        this.x = x;
        this.y = y;
        this.z = z;
        this.yaw = yaw;
        this.pitch = pitch;
    }

    public World getWorld() {
        return world.get();
    }

    public void setWorld(@NotNull World world) {
        if(!world.isLoaded())
            throw new IllegalStateException("Tried to create a position in an unloaded world!");

        this.world = new WeakReference<>(world);
    }

    @Override
    public Pos clone() {
        try {
            return (Pos) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @NotNull
    public Vec getDirection() {
        Vec vec = new Vec();

        double rotX = this.getYaw();
        double rotY = this.getPitch();

        vec.setY(-Math.sin(Math.toRadians(rotY)));

        double xz = Math.cos(Math.toRadians(rotY));

        vec.setX(-xz * Math.sin(Math.toRadians(rotX)));
        vec.setZ(xz * Math.cos(Math.toRadians(rotX)));

        return vec;
    }

    public void setDirection(@NotNull Vec vec) {
        final double _2PI = 2 * Math.PI;
        final double x = vec.getX();
        final double z = vec.getZ();

        if (x == 0 && z == 0) {
            pitch = vec.getY() > 0 ? -90 : 90;
            return;
        }

        double theta = Math.atan2(-x, z);
        yaw = (float) Math.toDegrees((theta + _2PI) % _2PI);

        double x2 = MathUtil.square(x);
        double z2 = MathUtil.square(z);
        double xz = Math.sqrt(x2 + z2);
        pitch = (float) Math.toDegrees(Math.atan(-vec.getY() / xz));
    }


    @NotNull
    public Pos add(@NotNull Pos pos) {
        if (pos.getWorld() != getWorld()) {
            throw new IllegalArgumentException("Cannot subtract Positions of differing worlds");
        }

        x += pos.x;
        y += pos.y;
        z += pos.z;
        return this;
    }

    @NotNull
    public Pos subtract(@NotNull Pos pos) {
        if (pos.getWorld() != getWorld()) {
            throw new IllegalArgumentException("Cannot subtract Positions of differing worlds");
        }

        x -= pos.x;
        y -= pos.y;
        z -= pos.z;
        return this;
    }

    @NotNull
    public Pos add(@NotNull Vec vec) {
        x += vec.getX();
        y += vec.getY();
        z += vec.getZ();
        return this;
    }

    @NotNull
    public Pos subtract(@NotNull Vec vec) {
        x -= vec.getX();
        y -= vec.getY();
        z -= vec.getZ();
        return this;
    }

    @NotNull
    public Pos add(int v) {
        x += v;
        y += v;
        z += v;
        return this;
    }

    @NotNull
    public Pos subtract(int v) {
        x -= v;
        y -= v;
        z -= v;
        return this;
    }

    @NotNull
    public Pos add(double v) {
        x += v;
        y += v;
        z += v;
        return this;
    }

    @NotNull
    public Pos subtract(double v) {
        x -= v;
        y -= v;
        z -= v;
        return this;
    }

    @Contract("-> new")
    @NotNull
    public Vec toVec() {
        return new Vec(this.x, this.y, this.z);
    }
}
