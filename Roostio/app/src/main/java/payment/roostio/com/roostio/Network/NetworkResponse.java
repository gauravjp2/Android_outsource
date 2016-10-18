package payment.roostio.com.roostio.Network;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Balodistechnologies on 29/06/16.
 */
public class NetworkResponse<T> {

    @SerializedName("data")
    private T modal;
    @SerializedName("status")
    private boolean success;
    @SerializedName("message")
    private String[] message;

    public T getModal() {
        return modal;
    }

    public void setModal(T modal) {
        this.modal = modal;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String[] getMessage() {
        return message;
    }

    public void setMessage(String[] message) {
        this.message = message;
    }
}
