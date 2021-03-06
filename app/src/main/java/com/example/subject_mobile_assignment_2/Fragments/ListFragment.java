package com.example.subject_mobile_assignement_2.Fragments;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.subject_mobile_assignement_2.Activities.Callback_List;
import com.example.subject_mobile_assignement_2.Model.Leaderboard;
import com.example.subject_mobile_assignement_2.R;
import com.example.subject_mobile_assignement_2.Model.Record;

import java.util.ArrayList;

public class ListFragment extends Fragment {

    private ListView listViewLeaderboardCoins;
    private AppCompatActivity activity;
    private Callback_List callbackList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        listViewLeaderboardCoins = view.findViewById(R.id.listViewLeaderboardCoins);

        StringBuffer listViewLeaderboardCoinsString = new StringBuffer();

        for (Record record : Leaderboard.getInstance().getRecordsArray()) {
            listViewLeaderboardCoinsString.append(record.getCoins() + "\n");
        }

        ArrayList<String> stringArrayList = new ArrayList<String>();

        for (Record record : Leaderboard.getInstance().getRecordsArray()) {
            stringArrayList.add("Name: " + record.getName() + ", Coins: " + record.getCoins());
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_list_item_1, stringArrayList);
        listViewLeaderboardCoins.setAdapter(arrayAdapter);


        listViewLeaderboardCoins.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (callbackList != null) {
                    ArrayList<Record> records = Leaderboard.getInstance().getRecordsArray();
                    double latitude = records.get(position).getLatitude();
                    double longitude = records.get(position).getLongitude();
                    callbackList.setMapLocation(latitude, longitude);
                }
            }
        });
        return view;
    }

    public void setCallbackList(Callback_List callbackList) {
        this.callbackList = callbackList;
    }

    public void setActivity(AppCompatActivity activity) {
        this.activity = activity;
    }
}