package net.feltmc.abstractium.util;

import net.feltmc.abstractium.api.abstraction.def.MinecraftEnvironment;
import net.feltmc.abstractium.api.event.core.StableEventArgs;
import net.feltmc.abstractium.util.obj_holders.MutableObjectHolder;

import java.util.ArrayList;
import java.util.List;

import static net.feltmc.abstractium.impl.events.common.PrimitiveAbstractionEvents.BOOLEAN_EVENT;

/**
 * {@link java.util.Timer Timer} doesn't work on minecraft as it runs on another thread. This timer
 * should effectively replace it for minecraft-dependent code.
 */
public final class TickTimer {
    private final List<Runnable> tasks;
    private int remainingTime = 0;

    @SuppressWarnings("unused")
    public TickTimer(final MinecraftEnvironment env) {
        tasks = new ArrayList<>();
        final StableEventArgs<MutableObjectHolder<Boolean>> args = (eventContext, eventStatus, event, eventArgs) -> {
            if (remainingTime > 0)
                remainingTime--;
            else if (!tasks.isEmpty()) {
                for (Runnable runnable : tasks)
                    runnable.run();
                tasks.clear();
            }
        };
        BOOLEAN_EVENT.registerListener(1, env.name().toLowerCase(), args);
    }

    /**
     * @return returns true if {@link TickTimer#remainingTime} is 0.
     */
    @SuppressWarnings("unused")
    public boolean isReady() {
        return remainingTime > 0;
    }

    /**
     * Runs the given task when {@link TickTimer#remainingTime} is 0.
     * @param runnable The task to run.
     */
    @SuppressWarnings("unused")
    public void setTask(Runnable runnable) {
        tasks.add(runnable);
    }

    /**
     * @param remainingTime The amount of time in ticks (20/sec) the timer has to wait.
     */
    public void setTime(int remainingTime) {
        if (remainingTime < 0) {
            throw new RuntimeException("FLTimer was called with a negative number!");
        }
        this.remainingTime = remainingTime;
    }

    /**
     * @param remainingTime The amount of time in ticks (20/sec) the timer has to wait.
     */
    @SuppressWarnings("unused")
    public void addTime(int remainingTime) {
        setTime(this.remainingTime + remainingTime);
    }

    /**
     * @return The amount of time left until ready.
     */
    @SuppressWarnings("unused")
    public int getTime() {
        return remainingTime;
    }
}