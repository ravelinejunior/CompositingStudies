package com.raveline.compositing.model

import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import java.math.BigDecimal


val sampleCandies = listOf(
    ProductItemModel(
        name = "Chocolate",
        price = BigDecimal("3.99"),
        image = "https://images.pexels.com/photos/65882/chocolate-dark-coffee-confiserie-65882.jpeg",
        description = LoremIpsum(30).values.last()
    ),
    ProductItemModel(
        name = "Ice Cream",
        price = BigDecimal("5.99"),
        image = "https://images.pexels.com/photos/1352278/pexels-photo-1352278.jpeg",
        description = LoremIpsum(30).values.last()
    ),
    ProductItemModel(
        name = "Cake",
        price = BigDecimal("11.99"),
        image = "https://images.pexels.com/photos/291528/pexels-photo-291528.jpeg",
    )
)

val sampleWomen = listOf(
    ProductItemModel(
        name = "Chocolate",
        price = BigDecimal("3.99"),
        image = "https://img.freepik.com/premium-photo/portrait-beautiful-sexy-girl_942478-5314.jpg?w=360",
        description = LoremIpsum(30).values.last()
    ),
    ProductItemModel(
        name = "Ice Cream",
        price = BigDecimal("5.99"),
        image = "https://www.pornocarioca.com/wp-content/uploads/2023/03/photo1677537321-1-1.jpeg",
        description = LoremIpsum(30).values.last()
    ),
    ProductItemModel(
        name = "Ice Cream",
        price = BigDecimal("5.99"),
        image = "https://www.pornocarioca.com/wp-content/uploads/2021/03/aline-caminhoneira-irritada-com-comentarios-com-sua-pata-de-camelo-13.jpg",
        description = LoremIpsum(30).values.last()
    ),
    ProductItemModel(
        name = "Ice Cream",
        price = BigDecimal("5.99"),
        image = "https://www.pornocarioca.com/wp-content/uploads/2019/07/cosplay-brasileira-pelada-1.jpeg",
        description = LoremIpsum(30).values.last()
    ),
    ProductItemModel(
        name = "Cake",
        price = BigDecimal("11.99"),
        image = "https://www.pornocarioca.com/wp-content/uploads/2015/02/fotos-amadoras-das-mais-gostosas-brasileiras-nuas-no-carnaval-brasileiro-de-2015-34.jpg",
    ),

    ProductItemModel(
        name = "Salam",
        price = BigDecimal("7.99"),
        image = "https://thechive.com/wp-content/uploads/2023/09/23f53299-473b-4ac3-9b31-96ba27c32c89.jpg?attachment_cache_bust=4495882&quality=85&strip=info&w=600",
        description = LoremIpsum(30).values.last()
    ),
    ProductItemModel(
        name = "Salam",
        price = BigDecimal("7.99"),
        image = "https://thechive.com/wp-content/uploads/2023/09/68dfe2c2-b0f8-4022-b6e9-fb0e88131fe7.jpg?attachment_cache_bust=4495885&quality=85&strip=info&w=600",
        description = LoremIpsum(30).values.last()
    ),
    ProductItemModel(
        name = "Salam",
        price = BigDecimal("7.99"),
        image = "https://thechive.com/wp-content/uploads/2023/08/48926840181b08247c468a7ac485fd6e.jpg?attachment_cache_bust=4472442&quality=85",
        description = LoremIpsum(30).values.last()
    ),
    ProductItemModel(
        name = "Salam",
        price = BigDecimal("7.99"),
        image = "https://thechive.com/wp-content/uploads/2023/06/36485d4ab85cd964cd39e45eef48a94c.jpeg?attachment_cache_bust=4430824&quality=85",
        description = LoremIpsum(30).values.last()
    ),
    ProductItemModel(
        name = "Salam",
        price = BigDecimal("7.99"),
        image = "https://thechive.com/wp-content/uploads/2023/09/leilaluuu_370196301_1343804136243765_2729896719972194106_n.jpg?attachment_cache_bust=4492422&quality=85&strip=info&w=600",
        description = LoremIpsum(30).values.last()
    ),
)

val sampleDrinks = listOf(
    ProductItemModel(
        name = "Beer",
        price = BigDecimal("5.99"),
        image = "https://images.pexels.com/photos/1552630/pexels-photo-1552630.jpeg",
        description = LoremIpsum(100).values.first()
    ),
    ProductItemModel(
        name = "Soda",
        price = BigDecimal("4.99"),
        image = "https://images.pexels.com/photos/2775860/pexels-photo-2775860.jpeg",
    ),
    ProductItemModel(
        name = "Juice",
        price = BigDecimal("7.99"),
        image = "https://images.pexels.com/photos/96974/pexels-photo-96974.jpeg",
        description = LoremIpsum(30).values.last()
    ),
    ProductItemModel(
        name = "Water",
        price = BigDecimal("2.99"),
        image = "https://images.pexels.com/photos/327090/pexels-photo-327090.jpeg"
    )
)

val sampleProducts: List<ProductItemModel> = listOf(
    ProductItemModel(
        name = "Hamburguer",
        price = BigDecimal("12.99"),
        image = "https://images.pexels.com/photos/1639557/pexels-photo-1639557.jpeg",
        description = LoremIpsum(30).values.last()
    ),
    ProductItemModel(
        name = "Pizza",
        price = BigDecimal("19.99"),
        image = "https://images.pexels.com/photos/825661/pexels-photo-825661.jpeg"
    ),
    ProductItemModel(
        name = "French Fries",
        price = BigDecimal("7.99"),
        image = "https://images.pexels.com/photos/1583884/pexels-photo-1583884.jpeg",
        description = LoremIpsum(30).values.last()
    ),
    ProductItemModel(
        name = "French Fries",
        price = BigDecimal("7.99"),
        image = "https://thechive.com/wp-content/uploads/2023/08/7f70299ede44ff3cc2775080ae1a615a.jpg?attachment_cache_bust=4480518&quality=85&strip=info&w=600",
        description = LoremIpsum(30).values.last()
    ),
    ProductItemModel(
        name = "Fries",
        price = BigDecimal("7.99"),
        image = "https://thechive.com/wp-content/uploads/2023/09/6b0974ab-49f0-434e-aaed-ff219e6a0b71.jpg?attachment_cache_bust=4492400&quality=85&strip=info&w=600",
        description = LoremIpsum(30).values.last()
    ),
    ProductItemModel(
        name = "French Fries",
        price = BigDecimal("7.99"),
        image = "https://thechive.com/wp-content/uploads/2023/08/74rtn2lxhbib1.jpg?attachment_cache_bust=4480502&quality=85&strip=info&w=600",
        description = LoremIpsum(30).values.last()
    ),
    ProductItemModel(
        name = "French Fries",
        price = BigDecimal("7.99"),
        image = "https://images.unsplash.com/photo-1574539602047-548bf9557352?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1965&q=80",
        description = LoremIpsum(30).values.last()
    ),
    ProductItemModel(
        name = "French Fries",
        price = BigDecimal("7.99"),
        image = "https://images.unsplash.com/photo-1515161318750-781d6122e367?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1952&q=80",
        description = LoremIpsum(30).values.last()
    ),
    ProductItemModel(
        name = "French Fries",
        price = BigDecimal("7.99"),
        image = "https://images.unsplash.com/photo-1557244056-ac3033d17d9a?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1974&q=80",
        description = LoremIpsum(30).values.last()
    ),
    ProductItemModel(
        name = "French Fries",
        price = BigDecimal("7.99"),
        image = "https://images.unsplash.com/photo-1583900985737-6d0495555783?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1964&q=80",
        description = LoremIpsum(30).values.last()
    ),
    ProductItemModel(
        name = "French Alada",
        price = BigDecimal("7.99"),
        image = "https://thechive.com/wp-content/uploads/2023/09/6b0974ab-49f0-434e-aaed-ff219e6a0b71.jpg?attachment_cache_bust=4492400&quality=85&strip=info&w=600",
        description = LoremIpsum(30).values.last()
    ),
    *sampleDrinks.toTypedArray(), *sampleCandies.toTypedArray(), *sampleWomen.toTypedArray()
)

val sampleSections = mapOf(
    "Sales" to sampleProducts,
    "Candies" to sampleCandies,
    "Drinks" to sampleDrinks,
    "Women" to sampleWomen,
)
