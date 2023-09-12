package com.towhid.cryptocurrency_jetpack.presentation.coin_detail

import com.towhid.cryptocurrency_jetpack.domain.model.Coin
import com.towhid.cryptocurrency_jetpack.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading : Boolean = false,
    val coin : CoinDetail? = null,
    val error: String = ""
)
