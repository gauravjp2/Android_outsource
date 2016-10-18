package payment.roostio.com.roostio.Network;

import java.util.Map;

import okhttp3.ResponseBody;
import payment.roostio.com.roostio.models.UserDetails;
import payment.roostio.com.roostio.models.UserSignup;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Balodistechnologies on 20/06/16.
 */
public class ConnectionManagerHelper {

    public interface APIcalls {
        @FormUrlEncoded
        @POST("signup")
        Call<ResponseCallback<UserSignup>> createUser(@FieldMap Map<String, String> fields);
        @FormUrlEncoded
        @POST("login")
        Call<ResponseCallback<UserDetails>> loginUser(@FieldMap Map<String, String> fields);
    }
}
