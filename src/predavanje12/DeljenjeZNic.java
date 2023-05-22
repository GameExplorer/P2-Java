package predavanje12;

/**
 * Napišemo svojo nepreverljivo izjemo
 */
public class DeljenjeZNic extends RuntimeException {
    @Override
    public String getMessage() {
        return "Deljenje z 0";
    }
}