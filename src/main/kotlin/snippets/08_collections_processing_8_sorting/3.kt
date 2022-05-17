package f_08_collections_processing_8_sorting.s_3

fun main() {
    println(listOf(4, 1, 3, 2).sortedDescending())
    // [4, 3, 2, 1]
    println(listOf(4, 1, 3, 2).sorted().reversed())
    // [4, 3, 2, 1]

    println(
        listOf('b', 'A', 'a', ' ', 'B')
            .sortedDescending()
    )
    // [b, a, B, A,  ]

    println(
        listOf("Bab", "AAZ", "Bza", "A")
            .sortedDescending()
    )
    // [Bza, Bab, AAZ, A]

    println(listOf(true, false, true).sortedDescending())
    // [true, true, false]
}
