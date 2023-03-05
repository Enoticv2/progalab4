package Bredlam;

import people.abstractions.BredlamMember;
import people.abstractions.VoteCollector;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Bredlam {
    protected String name;
    protected final ArrayList<BredlamMember> members = new ArrayList<>();

    public Bredlam(String name) {
        this.name = name;
    }

    public Bredlam(String name, BredlamMember[] members){
        this.name = name;
        this.members.addAll(List.of(members));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<BredlamMember> getMembers() {
        return members;
    }

    public void addMember(BredlamMember bredlamMember){
        this.members.add(bredlamMember);
    }

    public void addMembers(BredlamMember[] bredlamMembers){
        this.members.addAll(List.of(bredlamMembers));
    }

    @Override
    public String toString() {
        return "Бредлам " + this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bredlam bredlam = (Bredlam) o;
        return name.equals(bredlam.name) &&
                members.equals(bredlam.members);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, members);
    }
}
