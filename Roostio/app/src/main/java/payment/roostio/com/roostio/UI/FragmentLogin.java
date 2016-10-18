package payment.roostio.com.roostio.UI;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import payment.roostio.com.roostio.Network.ConnectionManager;
import payment.roostio.com.roostio.R;
import payment.roostio.com.roostio.models.Callback;
import payment.roostio.com.roostio.models.UserDetails;
import payment.roostio.com.roostio.models.UserSignup;

/**
 * A placeholder fragment containing a simple view.
 */
public class FragmentLogin extends Fragment implements View.OnClickListener{
    private TextView txtUsername;
    private TextView txtPassword;
    private Button btnLogin;
    private Button btnSignup;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_login, container, false);
        initLayout(fragmentView);
        return fragmentView;
    }

    private void initLayout(View mView){
        txtUsername = (TextView) mView.findViewById(R.id.txt_username);
        txtPassword = (TextView) mView.findViewById(R.id.txt_password);
        btnLogin = (Button) mView.findViewById(R.id.btn_login);
        btnSignup = (Button) mView.findViewById(R.id.btn_signup);
        btnLogin.setOnClickListener(this);
        btnSignup.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_login:
                if(checkInputData(0)){
                    initLoginProcess();
                }
                break;
            case R.id.btn_signup:
                initSignupProcess();
        }
    }

    private boolean checkInputData(int value){
        if(value == 0){
            String username = txtUsername.getText().toString();
            String password = txtPassword.getText().toString();
            if(username.equals("") && password.equals(""))
                return false;
            else
                return true;
        }
        return false;
    }

    private void initLoginProcess(){
        if(checkInputData(0)){
            UserDetails userForLogin = new UserDetails();
            userForLogin.setUsername(txtUsername.getText().toString());
            userForLogin.setPassword(txtPassword.getText().toString());
            ConnectionManager.doLogin(getActivity(), userForLogin, new Callback<UserDetails>() {
                @Override
                public void done() {
                    Intent i = new Intent((LoginActivity) getActivity(), NavMainActivity.class);
                    i.putExtra("email", this.getModalObject().getEmail());
                    i.putExtra("mobile", this.getModalObject().getMobile());
                    getActivity().startActivity(i);
                }
            });
        } else {
            Toast.makeText(getActivity(), "Please check the credentials", Toast.LENGTH_SHORT);
            return;
        }
    }

    private void initSignupProcess(){
        ((LoginActivity)getActivity()).changeFragment(1);
    }
}
