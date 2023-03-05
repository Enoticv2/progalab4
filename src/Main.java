import story.BadEnding;
import story.Story;

public class Main {

    public static void main(String[] args) {
        Story story = new Story();
        try {
            story.go();
        } catch (BadEnding e){
            System.out.println("В сказке недопустима плохая концовка!");
        }
    }
}
