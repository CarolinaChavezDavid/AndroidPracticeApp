package com.example.myappcarolina.series.presentation.view

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.example.myappcarolina.NetworkMonitor
import com.example.myappcarolina.databinding.FragmentSeriesBinding
import com.example.myappcarolina.series.domain.model.SeriesDto
import com.example.myappcarolina.series.presentation.presenter.SeriesPresenter

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
class SeriesFragment : Fragment() {

    private val seriesPresenter = SeriesPresenter(this)
    private var _binding: FragmentSeriesBinding? = null
    private lateinit var gridView : GridView
    lateinit var seriesAdapter: SeriesAdapter
    private  var  seriesList = listOf<SeriesDto>()
    private val binding get() = _binding!!
    var networkMonitor = NetworkMonitor()


        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                                  savedInstanceState: Bundle?): View? {
            _binding = FragmentSeriesBinding.inflate(inflater, container, false)
            if(networkMonitor.isNetworkAvailable(requireContext())){
                seriesPresenter.getAllSeries(requireContext())
            }else{
                Toast.makeText(context,"No internet found. Showing cached list in the view", Toast.LENGTH_LONG).show()
            }
            seriesPresenter.initSeriesGridView(requireContext())
            return binding.root
        }

         fun initGridView( mutableList: LiveData<List<SeriesDto>>){

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