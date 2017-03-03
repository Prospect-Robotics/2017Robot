package org.usfirst.frc.team2813.robot.commands;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;

public class BiFunctionAndThenConsumer<T, U, R> implements BiConsumer<T, U> {
	private final BiFunction<T, U, R> function;
	private final Consumer<R> consumer;

	public BiFunctionAndThenConsumer(BiFunction<T, U, R> func, Consumer<R> consumer) {
		function = func;
		this.consumer = consumer;
	}

	public void accept(T t, U u) {
		consumer.accept(function.apply(t, u));
	}
}