package people;

import people.abstractions.Listenable;
import people.abstractions.Shorty;

import java.util.Collection;
import java.util.List;
import java.util.Locale;

public class Secretary extends Shorty {

    public Secretary(String name) {
        super(name);
    }

    @Override
    public void sayTo(Listenable l, String text) {
        System.out.println(this.getName() + " говорит: \"" + text + "\"");
        l.listen(text.toUpperCase(Locale.ROOT));
    }

    @Override
    public void sayTo(List<Listenable> listenables, String text) {
        for(Listenable l:listenables){
            l.listen(text.toUpperCase(Locale.ROOT));
        }
    }
}
