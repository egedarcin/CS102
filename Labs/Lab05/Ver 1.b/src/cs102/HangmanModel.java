package cs102;

/**
 *
 * @author egedarcho
 */
public class HangmanModel extends Hangman {

    private IHangmanView view;

    public HangmanModel(IHangmanSetup setup) {
        super(setup);
    }

    public void addView(IHangmanView view) {
        this.view = view;
        update();
    }

    public void update() {
        view.updateView(this);
    }

    @Override
    public int tryThis(char letter) {
        int tryThis = super.tryThis(letter);
        update();
        return tryThis;
    }

}
