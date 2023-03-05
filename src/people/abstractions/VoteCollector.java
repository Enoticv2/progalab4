package people.abstractions;

import problems.Plant;

import java.util.List;

public interface VoteCollector {
    boolean collectVotes(Plant[] plants, List<BredlamMember> bredlamMembers);
}
