package com.practicum.composeproject

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun MainDataContact(contact: Contact){
    val fullName = remember(contact.name, contact.surname) {
        listOfNotNull(contact.name, contact.surname).joinToString(separator = " ")
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            contentAlignment = Alignment.Center,
        ){
            when(contact.imageRes){
                null ->{
                    Image(
                        modifier = Modifier.size(64.dp),
                        painter = painterResource(R.drawable.circle),
                        contentDescription = null
                    )
                    Text(
                        text = contact.name.take(1) + contact.familyName.take(1),
                        style = MaterialTheme.typography.headlineSmall,
                    )
                }
                else ->{
                    Image(
                        modifier = Modifier.size(128.dp),
                        painter = painterResource(contact.imageRes),
                        contentDescription = null
                    )
                }
            }
        }
        Text(
            text = fullName,
            fontWeight = FontWeight.Medium,
            fontSize = 18.sp,
        )
        Row{
            Text(
                text = contact.familyName,
                fontSize = 24.sp,
            )
            if (contact.isFavorite){
                Image(
                    modifier = Modifier.padding(start = 8.dp),
                    painter = painterResource(android.R.drawable.star_big_on),
                    contentDescription = null
                )
            }
        }
    }
}


@Composable
fun InfoRow(title: String, data: String){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(
            modifier = Modifier
                .weight(1f)
                .padding(end = 8.dp),
            textAlign = TextAlign.End,
            text = "$title:",
            fontSize = 16.sp,
        )
        Text(
            modifier = Modifier
                .weight(1f)
                .padding(start = 8.dp),
            fontSize = 12.sp,
            text = data,
        )
    }
}
@Composable
fun SecondaryDataContact(contact: Contact){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        InfoRow(
            stringResource(R.string.phone),
            contact.phone
        )
        InfoRow(
            stringResource(R.string.address),
            contact.address
        )
        contact.email?.let {
            InfoRow(
                stringResource(R.string.email),
                contact.email
            )
        }
    }
}

@Composable
fun ContactDetailScreen(contact: Contact){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier.systemBarsPadding(),
        ) {
            MainDataContact(contact)
            SecondaryDataContact(contact)
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun ContactPreview1(){
    ContactDetailScreen(pushkinContact)
}



@Preview(showSystemUi = true)
@Composable
fun ContactPreview2(){
    ContactDetailScreen(frogContact)
}

