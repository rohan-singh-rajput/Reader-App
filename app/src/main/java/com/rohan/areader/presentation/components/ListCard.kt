package com.rohan.areader.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.rohan.areader.data.remote.book_data.MBook
import com.rohan.areader.presentation.navigation.screens.home.RoundedButton


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun ListCard(
    book: MBook = MBook(
        id = "a", title = "Kotlin", authors = "Rohan", notes = "hello world"
    ), onPressDetails: (String) -> Unit = {}
) {
    val context = LocalContext.current
    val resources = context.resources
    val displayMetrics = resources.displayMetrics
    val screenWidth = displayMetrics.widthPixels / displayMetrics.density
    val spacing = 10.dp

    ElevatedCard(shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.elevatedCardColors(),
        modifier = Modifier
            .height(242.dp)
            .width(202.dp)
            .padding(4.dp)
            .clickable {
                onPressDetails.invoke(book.title.toString())
            }) {
        Column(
            modifier = Modifier.width(screenWidth.dp - (spacing * 2)),
            horizontalAlignment = Alignment.Start
        ) {
            Row(horizontalArrangement = Arrangement.Center) {
                Image(
                    painter = rememberImagePainter(data = "https://images.manning.com/720/960/resize/book/3/9458a37-9793-4e67-a23f-585da31dff55/Jemerov-Kotlin-HI.png"),
                    contentDescription = "null",
                    modifier = Modifier
                        .height(140.dp)
                        .width(100.dp)
                )
                Spacer(modifier = Modifier.width(50.dp))

                Column(
                    modifier = Modifier.padding(top = 25.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        imageVector = Icons.Default.FavoriteBorder,
                        contentDescription = " Favourite",
                        modifier = Modifier.padding(bottom = 1.dp)
                    )

                    BookRating(score = 3.5)
                }

            }
            Text(
                text = "Book Title",
                modifier = Modifier.padding(4.dp),
                fontWeight = FontWeight.Bold,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = "Authors",
                modifier = Modifier.padding(4.dp),
                style = MaterialTheme.typography.bodySmall
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {
                RoundedButton(label = "Reading", radius = 0)
            }

        }

    }
}



@Composable
fun BookRating(score: Double = 4.5) {
    Surface(
        modifier = Modifier
            .height(70.dp)
            .padding(4.dp),
        shape = RoundedCornerShape(50.dp),
        shadowElevation = 6.dp,
        color = MaterialTheme.colorScheme.secondary
    ) {
        Column(
            modifier = Modifier.padding(4.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = "star",
                modifier = Modifier.padding(3.dp)
            )
            Text(text = score.toString(), style = MaterialTheme.typography.labelSmall)


        }


    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookCard(title: String, author: String, rating: Float, isReading: Boolean, isFavorite: Boolean) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .height(250.dp)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = rememberImagePainter(data = "https://images.manning.com/720/960/resize/book/3/9458a37-9793-4e67-a23f-585da31dff55/Jemerov-Kotlin-HI.png"),
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )
            Box(
                modifier = Modifier
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(Color.Transparent, Color.Black),
                            startY = 0f,
                            endY = 300f
                        )
                    )
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomStart)
                ) {
                    Text(
                        text = title,
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Text(
                        text = "by $author",
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Normal
                        )
                    )
                    Text(
                        text = "Rating: $rating/5",
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Normal
                        )
                    )
                    if (isReading) {
                        Text(
                            text = "Currently reading",
                            style = TextStyle(
                                color = Color.White,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Normal
                            )
                        )
                    }
                    Icon(
                        imageVector = if (isFavorite) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                        contentDescription = null,
                        tint = if (isFavorite) Color.Red else Color.White,
                        modifier = Modifier.align(Alignment.End)
                    )
                }
            }
        }
    }
}

