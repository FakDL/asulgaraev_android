// ISongAidlInterface.aidl
package com.example.mobile_course;

// Declare any non-default types here with import statements

interface ISongAidlInterface {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void play();
    void pause();
    boolean isPlaying();
    boolean isMPReleased();
    int getDuration();
    int getCurrentPosition();
    void changeTime(int time);
    void playNext();
    void playPrev();

    Song getSong();
    void setCurrentSong(int position);
    void setCurrentSongFromBundle(in Bundle bundle);
}

parcelable Song;
