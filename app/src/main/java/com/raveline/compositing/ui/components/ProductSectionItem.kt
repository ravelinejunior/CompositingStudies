package com.raveline.compositing.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.raveline.compositing.model.ProductItemModel
import com.raveline.compositing.model.sampleProducts


@Composable
fun ProductsSection(
    title: String,
    products: List<ProductItemModel>,
    modifier: Modifier = Modifier
) {
    Column(modifier) {
        Text(
            text = title,
            modifier.padding(start = 16.dp, end = 16.dp),
            fontWeight = FontWeight.W500,
            fontSize = 20.sp,
        )
        LazyRow(
            modifier = modifier
                .padding(
                    top = 8.dp,
                )
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {

            items(products) { product ->
                ProductItem(product = product)
            }


        }
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun ProductsSectionPreview() {
    ProductsSection(title = "Sales", sampleProducts)
}
