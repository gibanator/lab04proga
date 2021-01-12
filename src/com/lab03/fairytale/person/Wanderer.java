package com.lab03.fairytale.person;

import com.lab03.fairytale.Distortion;

import java.util.Objects;

public class Wanderer extends Person{
    private final Distortion dist;

    public Wanderer(){
        super();
        this.dist = Distortion.getRandomDistortion();
    }

    public String getDist() {
        return dist.label;
    }
    @Override
    public String toString() {
        return String.format(getInfo()[0] + " смотрится в зеркало и его физиономия теперь " +  dist.label);
    }

    public int hashCode() {
        return Objects.hash(dist);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wanderer w = (Wanderer) o;
        return (dist == w.dist);
    }
}
