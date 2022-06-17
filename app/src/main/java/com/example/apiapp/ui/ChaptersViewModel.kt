package com.example.apiapp.ui

import androidx.lifecycle.*
import com.example.apiapp.model.Chapter
import com.example.apiapp.model.ChaptersItem
import com.example.apiapp.repository.MainRepo
import com.example.apiapp.util.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChaptersViewModel @Inject constructor(
   private val mainRepo: MainRepo
): ViewModel() {
    private val _dataState: MutableLiveData<DataState<List<Chapter>>> = MutableLiveData()
    val dataState: LiveData<DataState<List<Chapter>>>
        get() = _dataState
    fun setStateEvent(mainStateEvent: MainStateEvent){
        viewModelScope.launch {
            when(mainStateEvent){
                is MainStateEvent.GetChapters ->{
                    mainRepo.getChapters()
                        .onEach { dataState ->
                            _dataState.value = dataState
                        }
                        .launchIn(viewModelScope)
                }
                else -> {}
            }
        }
    }
}

sealed class MainStateEvent{
    object GetChapters: MainStateEvent()
    object None: MainStateEvent()
}