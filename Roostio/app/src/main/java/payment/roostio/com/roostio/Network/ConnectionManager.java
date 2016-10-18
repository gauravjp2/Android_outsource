package payment.roostio.com.roostio.Network;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.util.HashMap;


import payment.roostio.com.roostio.Utils.Constants;
import payment.roostio.com.roostio.models.Callback;
import payment.roostio.com.roostio.models.UserDetails;
import payment.roostio.com.roostio.models.UserSignup;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Balodistechnologies on 20/06/16.
 */
public class ConnectionManager {

    private static final String TAG = "ConnectionManager";

    private static void doHttpPost(Context mContext, String url, HashMap<String, String> data, final ResponseCallback<Object> callback, int api){
        Retrofit rfit = new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
        ConnectionManagerHelper.APIcalls apis = rfit.create(ConnectionManagerHelper.APIcalls.class);
        APIs cons_api = APIs.getAPIFromInt(api);
        switch(cons_api) {
            case CREATE_USER:
                createNewUser(mContext, apis, data, callback);
                break;
            case LOGIN_USER:
                loginUser(mContext, apis, data, callback);
        }
    }

    public static void doSignup(Context mContext, UserDetails userDetails, final Callback<UserDetails> callback) {
        HashMap<String, String> userdetails = new HashMap<>();
        userdetails.put("email", userDetails.getEmail());
        userdetails.put("mobile_no", userDetails.getMobile());
        userdetails.put("password", userDetails.getPassword());
        userdetails.put("name", userDetails.getName());
        userdetails.put("referred_by", userDetails.getReferrad_code());
        userdetails.put("api_token", Constants.API_TOKEN);
        doHttpPost(mContext, Constants.SignupURL, userdetails, new ResponseCallback<Object>() {

            @Override
            public void done() {
                Object userObject = this.getModelObject();
                String response = this.getStatus();
                Log.i(TAG, "Response status : " + response);
                if (userObject != null && userObject instanceof UserDetails) {
                    Log.i(TAG, ((UserDetails) userObject).getEmail());
                    callback.setModalObject((UserDetails) userObject);
                }
                callback.done();
            }
        }, APIs.CREATE_USER.getValue());
    }

    public static void doLogin(Context mContext, UserDetails userDetails, final Callback<UserDetails> callback) {
        HashMap<String, String> userdetails = new HashMap<>();
        userdetails.put("login", userDetails.getUsername());
        userdetails.put("password", userDetails.getPassword());
        userdetails.put("api_token", Constants.API_TOKEN);
        doHttpPost(mContext, Constants.LoginURL, userdetails, new ResponseCallback<Object>() {

            @Override
            public void done() {
                UserDetails userObject = (UserDetails) this.getModelObject();
                String response = this.getStatus();
                Log.i(TAG, "Response status : " + response);
                if (userObject != null && userObject instanceof UserDetails) {
                    Log.i(TAG, ((UserDetails) userObject).getEmail());
                    callback.setModalObject((UserDetails) userObject);
                }
                callback.done();
            }
        }, APIs.LOGIN_USER.getValue());
    }

    private static void createNewUser(final Context mContext, ConnectionManagerHelper.APIcalls apis, HashMap<String, String> data, final ResponseCallback<Object> callback){
        Call<ResponseCallback<UserSignup>> call = apis.createUser(data);
        call.enqueue(new retrofit2.Callback<ResponseCallback<UserSignup>>() {
            @Override
            public void onResponse(Call<ResponseCallback<UserSignup>> call, Response<ResponseCallback<UserSignup>> response) {
                UserDetails newUser = new UserDetails();
                Log.i(TAG,response.body().toString());
                newUser = response.body().getModelObject().getUserDetails();
                newUser.email = newUser.getEmail();
                newUser.mobile = newUser.getMobile();
                callback.setIsSucess(response.isSuccessful());
                callback.setModelObject(new UserDetails[]{newUser});
                callback.setStatusCode(response.code());
                callback.setStatus(response.body().getStatus());
                callback.setMessage(response.body().getMessage());
                callback.done();
            }

            @Override
            public void onFailure(Call<ResponseCallback<UserSignup>> call, Throwable t) {
                callback.setIsSucess(false);
                callback.setMessage(new String[]{t.getMessage()});
                Toast.makeText(mContext, "Some Error Occurred..Please check", Toast.LENGTH_LONG);
                callback.done();
            }
        });
    }

    private static void loginUser(final Context mContext, ConnectionManagerHelper.APIcalls apis, HashMap<String, String> data, final ResponseCallback<Object> callback){
        Call<ResponseCallback<UserDetails>> call = apis.loginUser(data);
        call.enqueue(new retrofit2.Callback<ResponseCallback<UserDetails>>() {
            @Override
            public void onResponse(Call<ResponseCallback<UserDetails>> call, Response<ResponseCallback<UserDetails>> response) {
                UserDetails newUser = new UserDetails();
                newUser.email = response.body().getModelObject().getEmail();
                newUser.mobile = response.body().getModelObject().getMobile();
                callback.setIsSucess(response.isSuccessful());
                callback.setModelObject(newUser);
                callback.setStatusCode(response.code());
                callback.setStatus(response.body().getStatus());
                callback.setMessage(response.body().getMessage());
                callback.done();
            }

            @Override
            public void onFailure(Call<ResponseCallback<UserDetails>> call, Throwable t) {
                callback.setIsSucess(false);
                callback.setMessage(new String[]{t.getMessage()});
                Toast.makeText(mContext, "Some Error Occurred..Please check", Toast.LENGTH_LONG);
                callback.done();
            }
        });
    }


}
