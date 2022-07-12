package com.arodream.tripuratourism;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;

public class NotificationReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        NotificationManager notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                .setSmallIcon(R.drawable.logo)
                .setContentTitle("Tripura Tourism")
                .setContentText("Tourism Notification Text")
                //.setSound(Notification.DEFAULT_SOUND)
                .setAutoCancel(true);
        notificationManager.notify(100,builder.build());
        //throw new UnsupportedOperationException("Not yet implemented");
    }
}
