package people;

import people.abstractions.Removable;
import people.abstractions.Shorty;

public class UsefulMan extends Shorty {
    public UsefulMan(String name) {
        super(name);
    }
    public void removePerson(Removable removable){
        removable.remove();
    }
}
