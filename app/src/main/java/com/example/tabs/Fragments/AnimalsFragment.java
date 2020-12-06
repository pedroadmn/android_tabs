package com.example.tabs.Fragments;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.tabs.R;

public class AnimalsFragment extends Fragment implements View.OnClickListener{

    private ImageButton ibDog;
    private ImageButton ibCat;
    private ImageButton ibLion;
    private ImageButton ibDonkey;
    private ImageButton ibSheep;
    private ImageButton ibCow;

    private MediaPlayer mediaPlayer;

    public AnimalsFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_animals, container, false);

        ibDog = view.findViewById(R.id.ibDog);
        ibCat = view.findViewById(R.id.ibCat);
        ibLion = view.findViewById(R.id.ibLion);
        ibDonkey = view.findViewById(R.id.ibDonkey);
        ibSheep = view.findViewById(R.id.ibSheep);
        ibCow = view.findViewById(R.id.ibCow);

        ibDog.setOnClickListener(this);
        ibCat.setOnClickListener(this);
        ibLion.setOnClickListener(this);
        ibDonkey.setOnClickListener(this);
        ibSheep.setOnClickListener(this);
        ibCow.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ibCat:
                mediaPlayer = createMediaPlayer(R.raw.cat);
                break;
            case R.id.ibLion:
                mediaPlayer = createMediaPlayer(R.raw.monkey);
                break;
            case R.id.ibDonkey:
                mediaPlayer = createMediaPlayer(R.raw.lion);
                break;
            case R.id.ibSheep:
                mediaPlayer = createMediaPlayer(R.raw.sheep);
                break;
            case R.id.ibCow:
                mediaPlayer = createMediaPlayer(R.raw.cow);
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