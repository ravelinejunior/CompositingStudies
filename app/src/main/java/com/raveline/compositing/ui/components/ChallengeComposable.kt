package com.raveline.compositing.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
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
import com.raveline.compositing.ui.theme.Purple80
import com.raveline.compositing.ui.theme.Teal200

@Composable
fun ChallengeComposable(
    product: ProductItemModel,
    modifier: Modifier = Modifier,
) {

    val imageSize = 100.dp

    Surface(
        shape = RoundedCornerShape(16.dp),
        tonalElevation = 12.dp,
        shadowElevation = 8.dp
    ) {

        Column(
            modifier = modifier
                .heightIn(260.dp, 280.dp)
                .width(200.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Box(
                modifier = Modifier
                    .height(imageSize)
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                Purple500, Purple80, Teal200
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
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = product.name,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.W700,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = product.price.toDollar(),
                    modifier = Modifier.padding(top = 8.dp),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W400
                )
            }

            if (product.description?.isNotBlank()?.and(product.description.isNotEmpty()) == true) {
                Text(
                    text = product.description.toString(),
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.primary)
                        .padding(
                            start = 16.dp,
                            end = 16.dp,
                            top = 8.dp,
                            bottom = 16.dp,
                        ),
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
        }

    }

}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ChallengeComposeDescriptionPreview() {
    ChallengeComposable(
        product = ProductItemModel(
            name = "Cocktail",
            price = 06.90.toBigDecimal(),
            image = "",
            description = LoremIpsum(50).values.first()
        )
    )
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ChallengeComposePreview() {
    ChallengeComposable(
        product = ProductItemModel(
            name = "Food",
            price = 12.90.toBigDecimal(),
            image = ""
        )
    )
}