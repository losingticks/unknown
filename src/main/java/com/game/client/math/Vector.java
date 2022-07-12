package com.game.client.math;

public interface Vector<T extends Vector<T>>
{
    T add(T t);
    T sub(T t);
    T mul(T t);
    T div(T t);
}
