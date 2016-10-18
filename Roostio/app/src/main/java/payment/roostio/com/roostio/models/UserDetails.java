package payment.roostio.com.roostio.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Balodistechnologies on 20/06/16.
 */
public class UserDetails implements Serializable{
    @SerializedName("email")
    public String email;
    @SerializedName("password")
    public String password;
    @SerializedName("mobile")
    public String mobile;
    @SerializedName("name")
    public String name;
    @SerializedName("id")
    public String id;
    @SerializedName("referrad_code")
    public String referrad_code;
    @SerializedName("Referrad_code")
    public String Referrad_code;
    public String username;

    public UserDetails(){

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReferrad_code() {
        return referrad_code;
    }

    public void setReferrad_code(String referrad_code) {
        this.referrad_code = referrad_code;
    }
}
