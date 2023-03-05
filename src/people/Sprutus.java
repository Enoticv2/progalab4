package people;

import Bredlam.Bredlam;
import people.abstractions.BredlamMember;
import people.abstractions.President;
import people.abstractions.VoteCollector;
import people.abstractions.VoteObliged;
import problems.Plant;
import problems.PlantSize;

import java.util.ArrayList;
import java.util.List;

public class Sprutus extends President{

    public Sprutus(String name) {
        super(name);
    }

    public boolean collectVotes(Plant[] plants, List<BredlamMember> bredlamMembers){
        this.say("Растения сейчас: ");
        List.of(plants).forEach(System.out::println);
        this.say("Растения нужно убить в зародыше, до того как оно разовьется в полную силу!");

        int count = 0;
        for (BredlamMember v: bredlamMembers) {
            if (v.voteAtDestroyingPlants(plants)){
                count++;
            }
        }

        return ((float) count / (float) bredlamMembers.size()) > 0.5F;
    }

    @Override
    public boolean voteAtDestroyingPlants(Plant[] plants) {

        for(Plant plant:plants){
            if(plant.getSize() == PlantSize.GIANT){
                System.out.println(getName() + " голосует отрицательно");
                return false;
            }
        }
        System.out.println(getName() + " голосует положительно");
        return true;
    }
}
