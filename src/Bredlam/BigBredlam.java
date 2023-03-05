package Bredlam;

import Bredlam.Bredlam;
import people.Sprutus;
import people.abstractions.BredlamMember;
import people.abstractions.President;
import people.abstractions.VoteCollector;
import problems.Plant;

import java.util.ArrayList;
import java.util.List;

public class BigBredlam extends Bredlam {
    protected final ArrayList<Bredlam> bredlams = new ArrayList<>();
    private final President president;

    public BigBredlam(String name, President voteCollector) {
        super(name);
        this.president = voteCollector;
    }

    public BigBredlam(String name, President voteCollector, BredlamMember[] members) {
        super(name, members);
        this.president = voteCollector;
    }
    public BigBredlam(String name, President voteCollector, Bredlam[] bredlams){
        super(name);
        this.bredlams.addAll(List.of(bredlams));
        this.president = voteCollector;
    }
    public BigBredlam(String name, President voteCollector, BredlamMember[] members, Bredlam[] bredlams) {
        super(name, members);
        this.bredlams.addAll(List.of(bredlams));
        this.president = voteCollector;
    }

    public void printMembers(){
        System.out.println("За круглый стол садятся: ");
        for(BredlamMember b: this.getMembers()){
            System.out.println("\t" + b.getName());
        }
        System.out.println();
    }

    public boolean vote(Plant[] plants){
        class NoPeopleInBredlam extends RuntimeException{
        }
        if(this.getMembers().isEmpty()) throw new NoPeopleInBredlam();
        return this.president.collectVotes(plants, this.getMembers());
    }

    public ArrayList<Bredlam> getBredlams() {
        return bredlams;
    }
    public void addBredlam(Bredlam bredlam){
        this.bredlams.add(bredlam);
    }
    public void addBredlams(Bredlam[] bredlams){
        this.bredlams.addAll(List.of(bredlams));
    }

    @Override
    public ArrayList<BredlamMember> getMembers() {
        ArrayList<BredlamMember> out = new ArrayList<>();
        out.add(president);
        for(Bredlam bredlam:this.bredlams){
            out.addAll(bredlam.getMembers());
        }
        return out;
    }
}
