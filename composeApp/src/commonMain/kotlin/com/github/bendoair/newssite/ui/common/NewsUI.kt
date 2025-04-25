package com.github.bendoair.newssite.ui.common

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.bendoair.newssite.domain.News
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

@Composable
fun NewsUI(news: News) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = news.headline,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Source: ${news.source}",
                fontSize = 14.sp,
                color = MaterialTheme.colors.primary
            )
            Text(
                text = "Date: ${news.date.formattedFromIsoDate()}",
                fontSize = 14.sp,
                color = MaterialTheme.colors.secondary
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = news.newsBody,
                fontSize = 16.sp
            )
        }
    }
}

private fun String.formattedFromIsoDate(): String {
    val instant = Instant.parse(this)
    val currentTimeZone: TimeZone = TimeZone.currentSystemDefault()
    val dateTime = instant.toLocalDateTime(currentTimeZone)
    return "${dateTime.year}. ${dateTime.monthNumber}. ${dateTime.dayOfMonth}."
}
