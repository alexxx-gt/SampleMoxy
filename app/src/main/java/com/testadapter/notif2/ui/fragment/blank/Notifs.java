package com.testadapter.notif2.ui.fragment.blank;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.testadapter.NotifObject;
import com.testadapter.R;
import com.testadapter.notif2.NotificationSettingsAdapter;
import com.testadapter.notif2.SetNotifCallback;
import com.testadapter.notif2.presentation.view.blank.NotifsView;
import com.testadapter.notif2.presentation.presenter.blank.NotifsPresenter;

import com.arellomobile.mvp.MvpFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Notifs extends MvpFragment implements NotifsView {
    public static final String TAG = "Notifs";
    @InjectPresenter
    NotifsPresenter mNotifsPresenter;

    private NotificationSettingsAdapter adapter;
    private List<NotifObject> objects = new ArrayList<>();
    private Context context;
    private SetNotifCallback callback = new SetNotifCallback() {
        @Override
        public void onSwitcherStateChanged(int position) {
            Log.d(TAG, "swithced");
            mNotifsPresenter.setNotification(objects.get(position));
        }
    };

    @BindView(R.id.notif_recycler) RecyclerView recyclerView;

    public static Notifs newInstance() {
        Notifs fragment = new Notifs();

        Bundle args = new Bundle();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_notification_settings, container, false);
    }

    @Override
    public void onViewCreated(final View view, final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        context = getActivity();
        ButterKnife.bind(this, view);
        initAdapter();
    }

    @Override
    public void initAdapter() {
        Log.d("Adapter", "initAdapter");
        NotifObject obj = new NotifObject("cal_after", "push", "'Add Action Items' reminder", 0);
        //startHud();
        //objects = mNotifsPresenter.getNotifications();
        objects.add(obj);
        adapter = new NotificationSettingsAdapter(objects, context, callback);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(
                context,
                LinearLayoutManager.VERTICAL,
                false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }
}
