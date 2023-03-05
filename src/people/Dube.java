package people;

import people.abstractions.BredlamMember;
import people.abstractions.Direction;
import people.abstractions.Removable;
import people.abstractions.Shorty;
import problems.Plant;

public class Dube extends BredlamMember {
    public class UsefulMan extends Shorty {
        public UsefulMan(String name) {
            super(name);
        }
        public void removePerson(Removable removable){
            removable.remove();
        }
    }

    public Dube(String name) {
        super(name);
    }

    @Override
    public void setHeadDirection(Direction headDirection) {
        if(headDirection != Direction.DOWN){
            System.out.println(this.name + " повернул голову");
            this.headDirection = headDirection;
        }else if (Math.random() >= 0.8) {
            System.out.println(this.name + " наклонил голову");
            super.setHeadDirection(headDirection);
        } else {
            System.out.println(this.name + " голову наклонить не получилось");
        }
    }

    @Override
    public void listen(String text) {
        if(!(this.getHeadDirection() == Direction.DOWN)){
            System.out.println(this + " услышал: \"" + text + "\"");
        }
    }

    @Override
    public boolean voteAtDestroyingPlants(Plant[] plants) {
        System.out.println(this.name + " голосует положительно");
        return true;
    }
}
