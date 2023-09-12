package com.towhid.cryptocurrency_jetpack.presentation.coin_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.towhid.cryptocurrency_jetpack.common.Constants
import com.towhid.cryptocurrency_jetpack.common.Resource
import com.towhid.cryptocurrency_jetpack.domain.use_case.get_coin.GetCoinUseCase
import com.towhid.cryptocurrency_jetpack.domain.use_case.get_coins.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val getCoinUseCase: GetCoinUseCase,
    savedStateHandle: SavedStateHandle
): ViewModel(){

    private val _state = mutableStateOf(CoinDetailState())
    val state : State<CoinDetailState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_COIN_ID)?.let {
            getCoin(it)
        }
    }

    private fun getCoin(coinId: String){
        getCoinUseCase(coinId).onEach {
            when(it){
                is Resource.Success -> {
                    _state.value = CoinDetailState(coin = it.data )
                }
                is Resource.Error -> {
                    _state.value = CoinDetailState(
                        error = it.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _state.value = CoinDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}
