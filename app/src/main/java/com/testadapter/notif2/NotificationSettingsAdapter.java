package com.testadapter.notif2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.testadapter.NotifObject;
import com.testadapter.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NotificationSettingsAdapter extends RecyclerView.Adapter<NotificationSettingsAdapter.MyAdapter> {
    private List<NotifObject> objects;
    private Context context;
    private int switchPosition;
    private SetNotifCallback callback;


    public NotificationSettingsAdapter(List<NotifObject> objects, Context context, SetNotifCallback callback) {
        this.objects = objects;
        this.context = context;
        this.callback = callback;
    }

    @Override
    public NotificationSettingsAdapter.MyAdapter onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_notification_settings, parent, false);
        return new MyAdapter(view);
    }

    @Override
    public void onBindViewHolder(NotificationSettingsAdapter.MyAdapter holder, int position) {
        switchPosition = position;
        holder.switcher.setText(objects.get(switchPosition).getSettingValue());
        boolean checked = objects.get(switchPosition).getEnabled() != 0;
        holder.switcher.setChecked(checked);

        holder.switcher.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Log.d("Adapter", "switch");
                callback.onSwitcherStateChanged(switchPosition);
            }
        });
    }

    @Override
    public int getItemCount() {
        return objects.size();
    }

    public class MyAdapter extends RecyclerView.ViewHolder {
        @BindView(R.id.notif_switcher)
        Switch switcher;
        public MyAdapter(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public void adapterListener(SetNotifCallback callback){}
}
