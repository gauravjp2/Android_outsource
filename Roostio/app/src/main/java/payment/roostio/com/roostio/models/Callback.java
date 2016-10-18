package payment.roostio.com.roostio.models;

/**
 * Created by Balodistechnologies on 29/06/16.
 */
public abstract class Callback<T> {
    public T modalObject;

    public T getModalObject() {
        return modalObject;
    }

    public void setModalObject(T modalObject) {
        this.modalObject = modalObject;
    }

    public abstract void done();
}
