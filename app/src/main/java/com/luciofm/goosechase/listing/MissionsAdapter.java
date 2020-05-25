package com.luciofm.goosechase.listing;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.luciofm.goosechase.data.Mission;
import com.luciofm.goosechase.databinding.ListItemMissionBinding;

import java.util.List;

public class MissionsAdapter extends RecyclerView.Adapter<MissionViewHolder> {
    private List<Mission> missions;

    @NonNull
    @Override
    public MissionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ListItemMissionBinding binding = ListItemMissionBinding.inflate(layoutInflater, parent, false);
        return new MissionViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MissionViewHolder holder, int position) {
        holder.bindMission(missions.get(position));
    }

    @Override
    public int getItemCount() {
        return missions != null ? missions.size() : 0;
    }

    // TODO - update the list and properly call notify methods
    public void setMissions(List<Mission> missions) {
        this.missions = missions;
        notifyDataSetChanged();
    }
}
