package payment.roostio.com.roostio.Network;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Balodistechnologies on 20/06/16.
 */
public class ResponseCallback<T> implements Serializable{
    @SerializedName("data")
    public T modelObject;
    @SerializedName("status")
    public String status;
    @SerializedName("message")
    public String[] message;
    public boolean isSuccess = false;
    public int statusCode;

    public T getModelObject() {
        return modelObject;
    }

    public void setModelObject(T modelObject) {
        this.modelObject = modelObject;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isSucess() {
        return isSuccess;
    }

    public void setIsSucess(boolean isSucess) {
        this.isSuccess = isSucess;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String[] getMessage() {
        return message;
    }

    public void setMessage(String[] message) {
        this.message = message;
    }

    public void done(){
        return;
    }
}
