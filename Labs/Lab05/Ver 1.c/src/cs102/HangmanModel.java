package cs102;
import java.util.ArrayList;
/**
 *
 * @author egedarcho
 */
public class HangmanModel extends Hangman {


    private ArrayList<IHangmanView> views = new ArrayList<IHangmanView>();

    public HangmanModel(IHangmanSetup setup) {
        super(setup);
    }

    public void addView(IHangmanView view) {
        views.add(view);
        view.updateView(this);
      
    }

    public void update() {
        for (int i = 0; i<views.size(); i++ ){
            views.get(i).updateView(this);
        }
    }

    @Override
    public int tryThis(char letter) {
        int tryThis = super.tryThis(letter);
        update();
        return tryThis;
    }

}
