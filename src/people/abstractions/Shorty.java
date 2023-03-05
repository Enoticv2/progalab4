package people.abstractions;


import java.util.Objects;

public abstract class Shorty implements Sayable, Listenable {
    protected final String name;
    protected Direction headDirection = Direction.FORWARD;

    public Shorty(String name) {
        this.name = name;
    }

    public Direction getHeadDirection() {
        return headDirection;
    }

    public void setHeadDirection(Direction headDirection) {
        this.headDirection = headDirection;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Shorty shorty)) return false;
        return getName().equals(shorty.getName()) &&
                getHeadDirection() == shorty.getHeadDirection();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getHeadDirection());
    }
}
