package com.luciofm.goosechase.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.luciofm.goosechase.MainActivity
import com.luciofm.goosechase.R
import com.luciofm.goosechase.databinding.MissionDetailFragmentBinding

class MissionDetailFragment : Fragment() {

    private val args: MissionDetailFragmentArgs by navArgs()

    private val viewModel: MissionDetailViewModel by viewModels {
        MissionDetailViewModelFactory(requireActivity().application, args.missionId)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<MissionDetailFragmentBinding>(inflater,
            R.layout.mission_detail_fragment, container, false).apply {
            model = viewModel
            lifecycleOwner = viewLifecycleOwner
        }

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.mission.observe(viewLifecycleOwner, Observer { mission ->
            (requireActivity() as MainActivity).title = mission.name
        })
    }

}