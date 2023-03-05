package people.abstractions;

import java.util.List;

public interface Sayable {
    default void sayTo(Listenable l, String text){
        l.listen(text);
    }
    default void sayTo(List<Listenable> listenables, String text){
        for(Listenable l:listenables){
            l.listen(text);
        }
    }
    default void say(String text){
        System.out.println(this.toString() + " говорит: \"" + text + "\"");
    }
}
