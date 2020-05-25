package com.luciofm.goosechase.listing;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.luciofm.goosechase.MainActivity;
import com.luciofm.goosechase.R;

public class MissionListFragment extends Fragment {

    private MissionListViewModel mViewModel;
    private MissionsAdapter adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.mission_list_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recycler = view.findViewById(R.id.recycler);
        adapter = new MissionsAdapter();
        recycler.setAdapter(adapter);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MissionListViewModel.class);
        mViewModel.listMissions().observe(getViewLifecycleOwner(),
                missions -> adapter.setMissions(missions));

        ((MainActivity) requireActivity()).setTitle(R.string.app_name);
    }
}