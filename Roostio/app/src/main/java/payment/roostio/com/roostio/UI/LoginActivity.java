package payment.roostio.com.roostio.UI;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import payment.roostio.com.roostio.R;

public class LoginActivity extends AppCompatActivity {

    private Fragment fragmentSignup, fragmentLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        fragmentLogin = new FragmentLogin();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if(!fragmentLogin.isAdded())
            transaction.add(fragmentLogin, "loginF");
        else
            transaction.show(fragmentLogin);
        transaction.replace(R.id.container, fragmentLogin);
        transaction.commit();
    }



    public void changeFragment(int v){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if(v==0) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragmentLogin);
        } else {
            if(fragmentSignup == null)
                fragmentSignup = new FragmentSignup();
            ft.replace(R.id.container, fragmentSignup);
        }
        ft.commit();
    }
}
