package com.game.client.math;

public interface Point<T extends Point<T>>
{
    T set(int x, int y);
    T set(T t);

    T add(int x, int y);
    T add(T t);

    T sub(int x, int y);
    T sub(T t);

    T mul(int x, int y);
    T mul(T t);

    T div(int x, int y);
    T div(T t);
}
