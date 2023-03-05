package people;

import people.abstractions.Removable;
import people.abstractions.Shorty;

public class Hooligan extends Shorty implements Removable {
    public Hooligan(String name) {
        super(name);
    }

    @Override
    public void remove() {
        System.out.println(this + " убрали");
    }
}