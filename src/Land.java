public class Land {
public String grass = "\uD83C\uDF3F";

    public boolean isPromisedLand() {
        return promisedLand;
    }

    public void setPromisedLand(boolean promisedLand) {
        this.promisedLand = promisedLand;
    }

    public boolean promisedLand = false;

    public Land() {

    }

    public Land(boolean promisedLand) {
        this.promisedLand = promisedLand;
    }
    @Override
    public String toString() {
        return "\uD83C\uDF3F";
    }

}
