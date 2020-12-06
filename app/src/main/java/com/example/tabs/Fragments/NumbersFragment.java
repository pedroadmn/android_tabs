package com.example.tabs.Fragments;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.tabs.R;

public class NumbersFragment extends Fragment implements View.OnClickListener {

    private ImageButton ibOne;
    private ImageButton ibTwo;
    private ImageButton ibThree;
    private ImageButton ibFour;
    private ImageButton ibFive;
    private ImageButton ibSix;

    private MediaPlayer mediaPlayer;

    public NumbersFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_animals, container, false);

        ibOne = view.findViewById(R.id.ibOne);
        ibTwo = view.findViewById(R.id.ibTwo);
        ibThree = view.findViewById(R.id.ibThree);
        ibFour = view.findViewById(R.id.ibFour);
        ibFive = view.findViewById(R.id.ibFive);
        ibSix = view.findViewById(R.id.ibSix);

        ibOne.setOnClickListener(this);
        ibTwo.setOnClickListener(this);
        ibThree.setOnClickListener(this);
        ibFour.setOnClickListener(this);
        ibFive.setOnClickListener(this);
        ibSix.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ibTwo:
                mediaPlayer = createMediaPlayer(R.raw.two);
                break;
            case R.id.ibThree:
                mediaPlayer = createMediaPlayer(R.raw.three);
                break;
            case R.id.ibFour:
                mediaPlayer = createMediaPlayer(R.raw.four);
                break;
            case R.id.ibFive:
                mediaPlayer = createMediaPlayer(R.raw.five);
                break;
            case R.id.ibSix:
                mediaPlayer = createMediaPlayer(R.raw.six);
                break;
            default:
                mediaPlayer = createMediaPlayer(R.raw.dog);
                break;
        }
        playSound();
    }

    private MediaPlayer createMediaPlayer(int soundId) {
        return MediaPlayer.create(getActivity(), soundId);
    }

    private void playSound() {
        if (mediaPlayer != null) {
            mediaPlayer.start();

            mediaPlayer.setOnCompletionListener(MediaPlayer::release);
        }
    }

    @Override
    public void onDestroy() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
        super.onDestroy();
    }
}