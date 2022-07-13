package com.unknown.util;

public enum Direction
{
    NORTH("North", 1),
    EAST("East", 2),
    SOUTH("South", 3),
    WEST("West", 4);

    private final String name;
    private final int id;

    Direction(String name, int id)
    {
        this.name = name;
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public int getId()
    {
        return id;
    }
}
