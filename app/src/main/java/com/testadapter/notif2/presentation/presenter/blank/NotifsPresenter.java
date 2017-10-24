package com.testadapter.notif2.presentation.presenter.blank;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.testadapter.NotifObject;
import com.testadapter.notif2.presentation.view.blank.NotifsView;

import java.util.List;

@InjectViewState
public class NotifsPresenter extends MvpPresenter<NotifsView> {

    public void setNotification(NotifObject notifObject){
        Log.d("Presetner", "set Notif");
    }

    public List<NotifObject> getNotifications(){
        Log.d("getNotif", "getNotifications");
        return null;
    }

}
