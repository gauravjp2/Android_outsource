package payment.roostio.com.roostio.UI;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import payment.roostio.com.roostio.Network.ConnectionManager;
import payment.roostio.com.roostio.R;
import payment.roostio.com.roostio.Network.ResponseCallback;
import payment.roostio.com.roostio.models.Callback;
import payment.roostio.com.roostio.models.UserDetails;

/**
 * A placeholder fragment containing a simple view.
 */
public class FragmentSignup extends Fragment implements View.OnClickListener{
    private static final String TAG = "FragmentSignup";
    private EditText txtEmail;
    private EditText txtPassword;
    private EditText txtCnfmPassword;
    private EditText txtMobile;
    private Button btnSignup;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_signup, container, false);
        initLayout(fragmentView);
        return fragmentView;
    }

    private void initLayout(View mView){
        txtEmail = (EditText) mView.findViewById(R.id.txt_email);
        txtCnfmPassword = (EditText) mView.findViewById(R.id.txt_cfrm_password);
        txtPassword = (EditText) mView.findViewById(R.id.txt_password);
        txtMobile = (EditText) mView.findViewById(R.id.txt_mobile);
        btnSignup = (Button) mView.findViewById(R.id.btn_signup);
        btnSignup.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_signup:
                int checked = checkInputData();
                if(checked==2){
                    initSignupProcess();
                } else if(checked==1){
                    Toast.makeText(getActivity(), "Please check your password and confirm password", Toast.LENGTH_SHORT);
                } else if(checked==0){
                    Toast.makeText(getActivity(), "Please check your credentials and try again", Toast.LENGTH_SHORT);
                }
        }
    }

    private int checkInputData(){
        String username = txtEmail.getText().toString();
        String password = txtPassword.getText().toString();
        String cnfmPassword = txtCnfmPassword.getText().toString();
        String mobile = txtMobile.getText().toString();
        if(username.equals("") && password.equals("") && mobile.equals(""))
            return 0;
        else if(!password.equals(cnfmPassword))
            return 1;
        else
            return 2;
    }

    private void initSignupProcess(){
        UserDetails ud = new UserDetails();
        ud.setEmail(txtEmail.getText().toString());
        ud.setMobile(txtMobile.getText().toString());
        ud.setPassword(txtPassword.getText().toString());
        ConnectionManager.doSignup(this.getActivity().getApplicationContext(), ud, new Callback<UserDetails>() {
            @Override
            public void done() {
                if(this.getModalObject()!=null)
                    Log.i(TAG, "New User Created");
            }
        });
    }
}
