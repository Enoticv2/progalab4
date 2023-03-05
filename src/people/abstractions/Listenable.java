package people.abstractions;

public interface Listenable {

    default void listen(String text){
        System.out.println(this + " услышал: \"" + text + "\"");
    }
}
