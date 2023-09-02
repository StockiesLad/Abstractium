package net.feltmc.abstractium.api.external.event;

import net.feltmc.abstractium.api.internal.event.core.AbstractEvent;
import net.feltmc.abstractium.api.internal.event.core.args.StableEventArgs;
import net.feltmc.abstractium.api.external.event.events.context.EmptyContext;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link java.util.Timer Timer} doesn't work on minecraft as it runs on another thread. This timer
 * should effectively replace it for minecraft-dependent code.
 */
public final class TickTimer {
    private final List<Runnable> tasks;
    private int remainingTime = 0;

    public TickTimer(final String uniqueEventLocation, AbstractEvent<EmptyContext> event) {
        tasks = new ArrayList<>();
        final StableEventArgs<EmptyContext> args = (eventContext, eventStatus, event1, eventArgs) -> {
            if (remainingTime > 0)
                remainingTime--;
            else if (!tasks.isEmpty()) {
                for (Runnable runnable : tasks)
                    runnable.run();
                tasks.clear();
            }
        };
        event.registerListener(1, uniqueEventLocation, args);
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