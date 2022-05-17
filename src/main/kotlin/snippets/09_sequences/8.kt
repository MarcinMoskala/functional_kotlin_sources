package f_09_sequences.s_8

class Product(val bought: Boolean)
val productsList = listOf<Product>()

fun singleStepListProcessing(): List<Product> {
    return productsList.filter { it.bought }
}

fun singleStepSequenceProcessing(): List<Product> {
    return productsList.asSequence()
        .filter { it.bought }
        .toList()
}
