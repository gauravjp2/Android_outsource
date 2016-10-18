package payment.roostio.com.roostio.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Balodistechnologies on 18/10/16.
 */
public class UserSignup {
    @SerializedName("wallet_id")
    private long wallet_id;
    @SerializedName("coins_id")
    private long coins_id;
    @SerializedName("referral_code")
    private String referralCode;
    @SerializedName("user_data")
    private UserDetails userDetails;

    public long getWallet_id() {
        return wallet_id;
    }

    public void setWallet_id(long wallet_id) {
        this.wallet_id = wallet_id;
    }

    public long getCoins_id() {
        return coins_id;
    }

    public void setCoins_id(long coins_id) {
        this.coins_id = coins_id;
    }

    public String getReferralCode() {
        return referralCode;
    }

    public void setReferralCode(String referralCode) {
        this.referralCode = referralCode;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }
}
