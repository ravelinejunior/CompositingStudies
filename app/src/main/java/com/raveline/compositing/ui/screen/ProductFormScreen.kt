package com.raveline.compositing.ui.screen

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.PriceChange
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.raveline.compositing.R
import com.raveline.compositing.model.ProductItemModel
import com.raveline.compositing.model.sampleProducts
import com.raveline.compositing.ui.activity.ProductFormActivity
import java.math.BigDecimal
import java.text.DecimalFormat

val TAG: String? = ProductFormActivity()::class.java.name

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ProductFormScreen() {
    val keyboardController = LocalSoftwareKeyboardController.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        Spacer(modifier = Modifier)

        Text(text = "Creating Product", style = MaterialTheme.typography.titleMedium)

        var productUrl by remember {
            mutableStateOf(String())
        }

        // Image Preview
        if (productUrl.isNotBlank() &&
            productUrl.contains("https://", true) &&
            productUrl.length > 10
        ) {
            AsyncImage(
                model = productUrl,
                contentDescription = stringResource(id = R.string.image),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(RoundedCornerShape(6)),
                contentScale = ContentScale.Crop,
                placeholder = painterResource(id = R.drawable.placeholder),
                error = painterResource(id = R.drawable.placeholdertwo),
            )
        }

        StyledOutlineTextForm(
            inputText = productUrl,
            onTextChanged = {
                productUrl = it
            },
            singleLine = true,
            hintText = "Image",
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Image,
                    contentDescription = stringResource(id = R.string.app_name)
                )
            }
        )

        // Product Name

        var productName by remember {
            mutableStateOf(String())
        }

        StyledOutlineTextForm(
            inputText = productName,
            onTextChanged = {
                productName = it
            },
            hintText = stringResource(R.string.name),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = stringResource(id = R.string.app_name)
                )
            },
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Words,
                imeAction = ImeAction.Next,
            )

        )

        // Product Description

        var productDescription by remember {
            mutableStateOf(String())
        }

        StyledOutlineTextForm(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(100.dp),
            inputText = productDescription,
            onTextChanged = {
                productDescription = it
            },
            maxLines = 10,
            hintText = stringResource(R.string.description),
            label = {
                Text(
                    stringResource(id = R.string.description),
                )
            },
            placeholder = {
                Text(
                    stringResource(id = R.string.description),
                )
            },
            leadingIcon = {
                Icon(
                    modifier = Modifier.offset(y = (-15).dp),
                    imageVector = Icons.Default.Description,
                    contentDescription = stringResource(id = R.string.app_name)
                )
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Default,
                capitalization = KeyboardCapitalization.Sentences,
            )
        )

        // Product Price
        var productPrice by remember {
            mutableStateOf(String())
        }

        val formatter = remember {
            DecimalFormat("#.##")
        }

        StyledOutlineTextForm(
            inputText = productPrice,
            modifier = Modifier
                .fillMaxWidth(),
            onTextChanged = {
                /*try {
                    productPrice = formatter.format(BigDecimal(it))
                } catch (e: IllegalArgumentException) {
                    productPrice = if (it.isBlank()) {
                        it
                    } else {
                        BigDecimal.ZERO.toString()
                    }
                } catch (e: NumberFormatException) {
                    BigDecimal.ZERO.toString()
                }*/
                productPrice = it
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.PriceChange,
                    contentDescription = stringResource(id = R.string.app_name)
                )
            },

            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done,
                capitalization = KeyboardCapitalization.Characters,
            ),
            prefix = {
                Text(
                    text = "R$",
                    Modifier.statusBarsPadding(),
                    style = MaterialTheme.typography.titleSmall.copy(
                        color = Color.White
                    )
                )
            }
        )

        // Save Button Product

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(60.dp),
            shape = RoundedCornerShape(50),
            onClick = {

                val convertedPrice = try {
                    BigDecimal(productPrice)
                } catch (e: NumberFormatException) {
                    BigDecimal.ZERO
                }

                val convertedUrl = try {
                    productUrl
                } catch (e: NullPointerException) {
                    sampleProducts[4].image!!
                }

                if (validateFields(
                        productName,
                        productDescription,
                        convertedPrice,
                        convertedUrl
                    )
                ) {
                    val product = ProductItemModel(
                        name = productName.trim(),
                        description = productDescription.trim(),
                        price = convertedPrice,
                        image = productUrl.trim()
                    )

                    Log.i(TAG, "ProductFormScreen: $product")
                }

            }
        ) {
            Text(
                text = "Save",
                Modifier.statusBarsPadding(),
                style = MaterialTheme.typography.titleMedium.copy(
                    color = MaterialTheme.colorScheme.surface
                )
            )
        }

        Spacer(modifier = Modifier)
    }
}

private fun validateFields(
    name: String,
    description: String,
    price: BigDecimal,
    url: String,
): Boolean {
    return name.isNotBlank() &&
            description.isNotBlank() &&
            url.isNotBlank() &&
            price > BigDecimal.ZERO
}

@Composable
fun StyledOutlineTextForm(
    modifier: Modifier = Modifier,
    inputText: String = "",
    onTextChanged: (String) -> Unit,
    hintText: String = "",
    maxLines: Int = 1,
    minLines: Int = 1,
    prefix: @Composable() (() -> Unit)? = {},
    singleLine: Boolean = false,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
    keyboardActions: KeyboardActions = KeyboardActions(),
    shape: Shape = RoundedCornerShape(10),
    placeholder: @Composable (() -> Unit) = {
        Text(
            text = hintText, style = TextStyle(
                fontFamily = FontFamily.SansSerif,
                textAlign = TextAlign.Center,
            )
        )
    },
    label: @Composable (() -> Unit)? = {
        Text(
            text = hintText, style = TextStyle(
                fontFamily = FontFamily.SansSerif
            )
        )
    },
    leadingIcon: @Composable() (() -> Unit)? = {},
    trailingIcon: @Composable() (() -> Unit)? = {}
) {

    OutlinedTextField(
        modifier = modifier.fillMaxWidth(),
        value = inputText,
        onValueChange = onTextChanged,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        label = label,
        prefix = prefix,
        maxLines = maxLines,
        minLines = minLines,
        singleLine = singleLine,
        placeholder = placeholder,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        shape = shape,
    )
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun OutlinedStyledTextFormPreview() {
    StyledOutlineTextForm(
        hintText = "BigTits",
        onTextChanged = {},
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Image,
                contentDescription = stringResource(id = R.string.app_name)
            )
        }
    )
}

@Preview
@Composable
fun ProductFormScreenPreview() {
    ProductFormScreen()
}