package story;

import Bredlam.*;
import people.*;
import people.abstractions.*;
import problems.*;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/*
unchecked - NoPeopleInBredlam
checked - BadEnding
вложенный static - Time
вложенный non-static - Dube.UsefulMan
локальный - bigbredlam.NoPeopleInBredlam
анонимный - члены совета
 */

public class Story {
    private static class Time{
        private int daysGone = 0;

        public int getDaysGone() {
            return daysGone;
        }

        public void setDaysGone(int daysGone) {
            this.daysGone = daysGone;
        }
        public void incDaysGone(){
            System.out.println("Прошел один день");
            this.daysGone++;
        }
    }

    private final Sprutus sprutus;
    private final Secretary secretary;
    private final Plant[] cityPlants;
    private final Dube dube;
    private final Dube.UsefulMan usefulMan1;
    private final Dube.UsefulMan usefulMan2;
    private final Hooligan[] hooligans;
    private final BredlamMember nobleman1;
    private final BredlamMember nobleman2;
    private final BigBredlam bigBredlam;
    private final SmallBredlam smallBredlam1;
    private final SmallBredlam smallBredlam2;
    private final Time time;

    private boolean good_ending = true;

    public Story() {
        this.sprutus = new Sprutus("Спрутс");
        this.secretary = new Secretary("Секретарь");
        this.dube = new Dube("Дубе");
        this.nobleman1 = new BredlamMember("Член совета 1"){
            @Override
            public boolean voteAtDestroyingPlants(Plant[] plants) {
                if (Math.random() >= 0.7){
                    System.out.println(this.name + " голосует положительно");
                    return true;
                }
                System.out.println(this.name + " голосует отрицательно");
                return false;
            }
        };
        this.nobleman2 = new BredlamMember("Член совета 2"){
            @Override
            public boolean voteAtDestroyingPlants(Plant[] plants) {
                if (Math.random() >= 0.5){
                    System.out.println(this.name + " голосует положительно");
                    return true;
                }
                System.out.println(this.name + " голосует отрицательно");
                return false;
            }
        };;
        this.usefulMan1 = dube.new UsefulMan("Полезная личность 1");
        this.usefulMan2 = dube.new UsefulMan("Полезная личность 2");
        this.smallBredlam1 = new SmallBredlam("малый Бредлам 1", new BredlamMember[] {dube});
        this.smallBredlam2 = new SmallBredlam("малый Бредлам 1", new BredlamMember[] {nobleman1, nobleman2});
        this.bigBredlam = new BigBredlam("Большой Бредлам", sprutus, new Bredlam[]{smallBredlam2, smallBredlam1});
        this.time = new Time();

        this.hooligans = new Hooligan[]{
                new Hooligan("Миго"),
                new Hooligan("Жулио"),
                new Hooligan("Незнайка"),
                new Hooligan("Козлик")
        };

        this.cityPlants = new Plant[10];
        for(int i = 0; i <= 9; i++){
            cityPlants[i] = new Plant("Растение " + i, PlantSize.FETUS);
        }
    }

    public void go() throws BadEnding {
        for(BredlamMember bredlamMember: bigBredlam.getMembers()){
            secretary.sayTo(bredlamMember, "Завтра нужно явиться на совещание");
        }
        this.time.incDaysGone();
        this.bigBredlam.printMembers();
        boolean result = bigBredlam.vote(cityPlants);
        System.out.println((result)
                ? "В итоге, Бредлам проголосовал положительно"
                : "В итоге, Бредлам проголосовал отрицательно");
        if(!result) throw new BadEnding();
        do{
            dube.setHeadDirection(Direction.DOWN);
        } while(dube.getHeadDirection() != Direction.DOWN);
        dube.say("У меня есть две полезные личности: " + usefulMan1 + ", " +usefulMan2);
        if (!this.good_ending){
            List.of(hooligans).forEach(usefulMan1::removePerson);
            throw new BadEnding();
        } else {
            sprutus.say(dube.getName() +  ", не надо убивать детей!!");
        }
    }

    @Override
    public String toString() {
        return "История про незнайку";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Story story)) return false;
        return sprutus.equals(story.sprutus) &&
                secretary.equals(story.secretary) &&
                Arrays.equals(cityPlants, story.cityPlants) &&
                dube.equals(story.dube) &&
                usefulMan1.equals(story.usefulMan1) &&
                usefulMan2.equals(story.usefulMan2) &&
                Arrays.equals(hooligans, story.hooligans) &&
                nobleman1.equals(story.nobleman1) &&
                nobleman2.equals(story.nobleman2);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(sprutus, secretary, dube, usefulMan1, usefulMan2, nobleman1, nobleman2);
        result = 31 * result + Arrays.hashCode(cityPlants);
        result = 31 * result + Arrays.hashCode(hooligans);
        return result;
    }
}
