package com.towhid.cryptocurrency_jetpack.domain.repository

import com.towhid.cryptocurrency_jetpack.data.remote.dto.CoinDetailDto
import com.towhid.cryptocurrency_jetpack.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}