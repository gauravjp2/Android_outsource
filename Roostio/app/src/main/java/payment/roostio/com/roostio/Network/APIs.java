package payment.roostio.com.roostio.Network;

/**
 * Created by Balodistechnologies on 30/06/16.
 */
public enum APIs {
    CREATE_USER(0),
    LOGIN_USER(1),
    GETOTP(2);

    private final int value;

    public final int getValue() {
        return value;
    }

    private APIs(final int newValue) {
        value = newValue;
    }

    public static APIs getAPIFromInt(int no){
        return APIs.values()[no];
    }
}