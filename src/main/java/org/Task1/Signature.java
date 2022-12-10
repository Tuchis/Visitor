package org.Task1;


import java.util.function.Consumer;

public class Signature<T> extends Task<T> {
    public Consumer<T> consumer;
    public Signature(Consumer<T> consumer) {
        this.consumer = consumer;
    }

    public void apply(T arg) {
        this.freeze();
        consumer.accept(arg);
    }

    public void stamp(Visitor<T> visitor){
        this.setHeader("groups", visitor.onSignature(this).get("groups"));
    }
}
