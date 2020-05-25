package com.luciofm.goosechase.listing;

import android.view.View;

import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.luciofm.goosechase.BR;
import com.luciofm.goosechase.data.Mission;
import com.luciofm.goosechase.databinding.ListItemMissionBinding;

public class MissionViewHolder extends RecyclerView.ViewHolder {
    private final ListItemMissionBinding binding;

    public MissionViewHolder(ListItemMissionBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
        binding.setClickListener(v -> {
            navigateToMission(v, binding.getMission());
        });
    }

    private void navigateToMission(View view, Mission mission) {
        NavDirections direction = MissionListFragmentDirections.Companion.actionMissionListFragmentToMissionDetailFragment(mission.getId());
        Navigation.findNavController(view).navigate(direction);
    }

    public void bindMission(Mission mission) {
        binding.setVariable(BR.mission, mission);
        binding.executePendingBindings();
    }
}
