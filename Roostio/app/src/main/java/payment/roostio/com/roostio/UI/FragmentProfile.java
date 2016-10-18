package payment.roostio.com.roostio.UI;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import payment.roostio.com.roostio.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentProfile.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentProfile} factory method to
 * create an instance of this fragment.
 */
public class FragmentProfile extends Fragment {

    private OnFragmentInteractionListener mListener;
    private TextView mUserMobile;
    private TextView mUserEmail;
    private View mView;

//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment FragmentProfile.
//     */
//    public static FragmentProfile newInstance(String param1, String param2) {
//        FragmentProfile fragment = new FragmentProfile();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }

    public FragmentProfile() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void initLayout(View mView) {
        mUserEmail = (TextView) mView.findViewById(R.id.txt_email);
        mUserMobile = (TextView) mView.findViewById(R.id.txt_mobile);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_profile, container, false);
        initLayout(mView);
        if(getArguments() != null) {
            mUserMobile.setText(getArguments().getString("mobile"));
            mUserEmail.setText(getArguments().getString("email"));
        }
        return mView;
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context mContext) {
        super.onAttach(mContext);
        try {
            mListener = (OnFragmentInteractionListener) mContext;
        } catch (ClassCastException e) {
            throw new ClassCastException(mContext.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        public void onFragmentInteraction(Uri uri);
    }

}
