package com.amitsalunke.simple_paging_3

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.amitsalunke.simple_paging_3.data.CharacterData
import com.amitsalunke.simple_paging_3.network.RetroInstance
import com.amitsalunke.simple_paging_3.network.RetroService
import com.amitsalunke.simple_paging_3.paging_source.CharacterPagingSource
import kotlinx.coroutines.flow.Flow

class MainActivityViewModel : ViewModel() {
    lateinit var retroService: RetroService

    init {
        retroService = RetroInstance.getRetroInstance().create(RetroService::class.java)
    }

    fun getListData(): Flow<PagingData<CharacterData>>{
        return Pager(config = PagingConfig(pageSize = 34,maxSize=200),
        pagingSourceFactory = {CharacterPagingSource(retroService)}).flow.cachedIn(viewModelScope)
    }
}