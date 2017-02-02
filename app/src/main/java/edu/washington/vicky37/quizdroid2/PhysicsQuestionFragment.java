package edu.washington.vicky37.quizdroid2;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;

public class PhysicsQuestionFragment extends Fragment implements View.OnClickListener{

    private OnFragmentInteractionListener mListener;

    private View mView;
    public PhysicsQuestionFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.physics_question_fragment, container, false);
        RadioButton physicsRadioButton1 = (RadioButton)mView.findViewById(R.id.physicsRadioButton1);
        physicsRadioButton1.setOnClickListener(this);
//        mathRadioButton1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                View summitButton = v.findViewById(R.id.mathSummitButton);
//                summitButton.setVisibility(v.VISIBLE);
//            };
//        });

        RadioButton physicsRadioButton2 = (RadioButton)mView.findViewById(R.id.physicsRadioButton2);
        physicsRadioButton2.setOnClickListener(this);
//        mathRadioButton2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                View summitButton = v.findViewById(R.id.mathSummitButton);
//                summitButton.setVisibility(v.VISIBLE);
//            };
//        });

        RadioButton physicsRadioButton3 = (RadioButton)mView.findViewById(R.id.physicsRadioButton3);
        physicsRadioButton3.setOnClickListener(this);
//        mathRadioButton3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                View summitButton = v.findViewById(R.id.mathSummitButton);
//                summitButton.setVisibility(v.VISIBLE);
//            };
//        });

        RadioButton physicsRadioButton4 = (RadioButton)mView.findViewById(R.id.physicsRadioButton4);
        physicsRadioButton4.setOnClickListener(this);
//        mathRadioButton4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                View summitButton = v.findViewById(R.id.mathSummitButton);
//                summitButton.setVisibility(v.VISIBLE);
//            };
//        });

        Button submitButton = (Button)mView.findViewById(R.id.physicsSummitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onFragmentInteraction(R.id.physicsSummitButton);
            }
        });

        return mView;
    }

    public void showRadioButton (View v) {
        Button button = (Button)mView.findViewById(R.id.physicsSummitButton);
        button.setVisibility(View.VISIBLE);
    }
    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(int button) {
        if (mListener != null) {
            mListener.onFragmentInteraction(button);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {
        if (mListener != null) {
            Button button = (Button)mView.findViewById(R.id.physicsSummitButton);
            button.setVisibility(View.VISIBLE);



        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(int button);
    }
}