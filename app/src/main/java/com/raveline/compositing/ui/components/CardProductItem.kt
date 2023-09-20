package com.raveline.compositing.ui.components


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.raveline.compositing.R
import com.raveline.compositing.extensions.toDollar
import com.raveline.compositing.model.ProductItemModel
import com.raveline.compositing.model.sampleProducts
import com.raveline.compositing.ui.theme.CompositingTheme

@Composable
fun CardProductItem(
    product: ProductItemModel,
    modifier: Modifier = Modifier,
    elevation: CardElevation = CardDefaults.cardElevation(
        defaultElevation = 12.dp,
        disabledElevation = 8.dp,
        pressedElevation = 12.dp,
        focusedElevation = 12.dp,
        hoveredElevation = 12.dp
    )
) {
    var expanded by rememberSaveable {
        mutableStateOf(false)
    }

    val bigImage =
        if (expanded) 360.dp
        else 180.dp

    Card(
        modifier
            .fillMaxWidth()
            .heightIn(bigImage)
            .clickable {
                expanded = !expanded
            },
        shape = RoundedCornerShape(5),
        elevation = elevation
    ) {
        Column {

            val scaleType =
                if (expanded) ContentScale.Crop
                else ContentScale.FillBounds

            AsyncImage(
                model = product.image,
                contentDescription = stringResource(id = R.string.app_name),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(bigImage),
                placeholder = painterResource(id = R.drawable.placeholder),
                contentScale = scaleType
            )
            Column(
                Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.surface)
                    .padding(16.dp)

            ) {
                Text(
                    text = product.name
                )
                Text(
                    text = product.price.toDollar()
                )
            }

            val textOverflow =
                if (expanded) TextOverflow.Visible
                else TextOverflow.Ellipsis

            val maxLines =
                if (expanded) Int.MAX_VALUE
                else 2

            product.description?.let {
                Text(
                    text = it,
                    Modifier
                        .padding(16.dp),
                    overflow = textOverflow,
                    maxLines = maxLines
                )
            }
        }
    }
}

@Preview
@Composable
private fun CardProductItemPreview() {
    CompositingTheme {
        Surface {
            CardProductItem(
                product = sampleProducts.random(),
            )
        }
    }
}