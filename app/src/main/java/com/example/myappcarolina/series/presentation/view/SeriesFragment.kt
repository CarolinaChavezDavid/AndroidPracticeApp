package com.example.myappcarolina.series.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.myappcarolina.databinding.FragmentSeriesBinding
import com.example.myappcarolina.series.domain.model.SeriesDto
import com.example.myappcarolina.series.presentation.presenter.SeriesPresenter


class   SeriesFragment : Fragment() {

        private var _binding: FragmentSeriesBinding? = null
        private lateinit var gridView : GridView
        lateinit var seriesAdapter: SeriesAdapter
        private  var  seriesList = listOf<SeriesDto>()
        private val binding get() = _binding!!
        private val seriesPresenter = SeriesPresenter(this)

        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                                  savedInstanceState: Bundle?): View? {
            _binding = FragmentSeriesBinding.inflate(inflater, container, false)
            seriesPresenter.initSeriesGridView()
            return binding.root
        }

         fun initGridView( mutableList: MutableLiveData<List<SeriesDto>>){

            mutableList.observe(viewLifecycleOwner, Observer { list ->
                seriesAdapter.setData(list)
            })
            gridView = binding.gridSerie
            seriesAdapter = SeriesAdapter(requireContext(), seriesList)
            gridView.adapter = seriesAdapter
        }

        override fun onDestroyView() {
            super.onDestroyView()
            _binding = null
        }

}