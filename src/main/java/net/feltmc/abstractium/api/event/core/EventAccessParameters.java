package net.feltmc.abstractium.api.event.core;

import java.util.Queue;

public record EventAccessParameters<Context>(
        String location,
        long priority,
        Queue<EventArgs<Context>> args
) { }
