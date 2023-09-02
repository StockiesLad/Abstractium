package net.feltmc.abstractium.api.internal.event.core;

import net.feltmc.abstractium.api.internal.event.core.args.EventArgs;

import java.util.Queue;

public record EventAccessParameters<Context>(
        String location,
        long priority,
        Queue<EventArgs<Context>> args
) { }
