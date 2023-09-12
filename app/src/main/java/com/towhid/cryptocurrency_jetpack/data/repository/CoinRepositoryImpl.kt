package com.towhid.cryptocurrency_jetpack.data.repository

import com.towhid.cryptocurrency_jetpack.data.remote.CoinPaprikaApi
import com.towhid.cryptocurrency_jetpack.data.remote.dto.CoinDetailDto
import com.towhid.cryptocurrency_jetpack.data.remote.dto.CoinDto
import com.towhid.cryptocurrency_jetpack.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
): CoinRepository{

    override suspend fun getCoins(): List<CoinDto>{
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}