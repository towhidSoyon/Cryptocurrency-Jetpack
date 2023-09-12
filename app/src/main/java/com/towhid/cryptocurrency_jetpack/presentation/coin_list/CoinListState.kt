package com.towhid.cryptocurrency_jetpack.presentation.coin_list

import com.towhid.cryptocurrency_jetpack.domain.model.Coin

data class CoinListState(
    val isLoading : Boolean = false,
    val coins : List<Coin> = emptyList(),
    val error: String = ""
)
