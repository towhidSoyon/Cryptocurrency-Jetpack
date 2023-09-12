package com.towhid.cryptocurrency_jetpack.presentation.coin_detail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import com.towhid.cryptocurrency_jetpack.data.remote.dto.CoinDetailDto.TeamMember

@Composable
fun TeamListItem(
    teamMember: TeamMember,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = teamMember.name,
            style = MaterialTheme.typography.bodyMedium,
            fontStyle = FontStyle.Italic
        )
    }
}