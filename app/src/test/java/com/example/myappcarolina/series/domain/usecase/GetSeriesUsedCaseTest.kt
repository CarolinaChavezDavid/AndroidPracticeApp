package com.example.myappcarolina.series.domain.usecase

import com.example.myappcarolina.series.data.repository.SeriesRepository
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner.StrictStubs::class)
class GetSeriesUsedCaseTest{
    @InjectMocks
    lateinit var useCase: GetSeriesUsedCase
    @Mock
    lateinit var seriesRepository: SeriesRepository

    @Test
    fun `Test if gets series list from repository`(){
        //val listResult =useCase.invoke()
       // Mockito.verify(seriesRepository).getSeriesFromServer()
    }

}