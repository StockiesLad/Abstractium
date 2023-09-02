package net.feltmc.abstractium.api.external.event.events.context;

public record EmptyContext() {
    public static EmptyContext INSTANCE = new EmptyContext();
}
