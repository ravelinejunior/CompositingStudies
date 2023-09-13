package com.raveline.compositing.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.raveline.compositing.R
import com.raveline.compositing.extensions.toDollar
import com.raveline.compositing.model.ProductItemModel
import com.raveline.compositing.ui.theme.Purple500
import com.raveline.compositing.ui.theme.Purple700
import com.raveline.compositing.ui.theme.Purple80
import com.raveline.compositing.ui.theme.Teal200

@Composable
fun ProductItem(
    product: ProductItemModel,
    modifier: Modifier = Modifier,
) {
    Surface(
        shape = RoundedCornerShape(16.dp),
        shadowElevation = 8.dp,
        tonalElevation = 8.dp
    ) {
        Column(
            modifier = modifier
                .heightIn(250.dp, 300.dp)
                .width(200.dp)
        ) {
            val imageSize = 100.dp
            Box(
                modifier = Modifier
                    .height(imageSize)
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                Purple500, Teal200
                            )
                        )
                    )
                    .fillMaxWidth()
            ) {
                AsyncImage(
                    model = product.image,
                    contentDescription = stringResource(
                        R.string.image
                    ),
                    modifier = Modifier
                        .size(imageSize)
                        .offset(y = imageSize / 2)
                        .clip(shape = CircleShape)
                        .align(Alignment.BottomCenter),
                    contentScale = ContentScale.Crop,
                    placeholder = painterResource(id = R.drawable.placeholder)
                )
            }
            Spacer(modifier = Modifier.height(imageSize / 2))

            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = product.name,
                    fontSize = 18.sp,
                    fontWeight = FontWeight(700),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )

                Text(
                    text = product.price.toDollar(),
                    modifier = Modifier.padding(vertical = 8.dp),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W500
                )
            }
        }
    }
}

@Composable
@Preview(showSystemUi = true, showBackground = true)
fun ProductItemPreview() {
    ProductItem(
        ProductItemModel(
            LoremIpsum(10).values.first(),
            image = "https://images.pexels.com/photos/1583884/pexels-photo-1583884.jpeg",
            price = 19.00.toBigDecimal()
        )
    )
}

@Composable
fun HorizontalProductItem() {
    Surface(
        modifier = Modifier.padding(8.dp),
        shape = RoundedCornerShape(16.dp),
        shadowElevation = 8.dp,
        tonalElevation = 8.dp
    ) {

        Row(
            modifier = Modifier
                .fillMaxSize(0.5f)
        ) {
            val imageSize = 100.dp

            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(0.30f)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(Purple500, Purple80)
                        )
                    )
            ) {

                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = stringResource(id = R.string.app_name),
                    modifier = Modifier
                        .size(imageSize)
                        .align(Alignment.Center)
                        .offset(x = imageSize / 2)
                        .clip(shape = CircleShape)
                        .border(
                            BorderStroke(
                                2.dp, brush = Brush.verticalGradient(
                                    listOf(
                                        Purple700, Purple80
                                    )
                                )
                            ), CircleShape
                        )
                )
            }

            Spacer(modifier = Modifier.width(imageSize / 2))

            Box {
                Column {
                    Text(
                        text = LoremIpsum(50).values.first(),
                        fontWeight = FontWeight.W700,
                        fontFamily = FontFamily.Monospace,
                        maxLines = 3,
                        overflow = TextOverflow.Ellipsis,
                        fontSize = 20.sp
                    )
                    Text(
                        text = LoremIpsum(10).values.last(),
                        modifier = Modifier.padding(vertical = 8.dp),
                        fontWeight = FontWeight.W500,
                        fontFamily = FontFamily.Serif,
                        overflow = TextOverflow.Ellipsis,
                        fontSize = 16.sp
                    )
                }
            }
        }

    }
}
