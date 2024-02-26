```
val squaredPlusOne: (Int) -> Int =
    { x: Int -> x * 2 } compose { it + 1 }
```


```
people.filter(
    Boolean::not compose ::goodString compose Person::name
)

// instead of
people.filter { !goodString(it.name) }
```


```
fun String.isPrefixOf(s: String) = s.startsWith(this)
```


```
(String::isPrefixOf).partially1("FP")
```


```
val fibonacci = DeepRecursiveFunction<Int, Int> { x ->
    when {
        x < 0 -> 0
        x == 1 -> 1
        else -> callRecursive(x - 1) + callRecursive(x - 2)
    }
}
```


```
fun fib(x: Int) = fibonacci(x)
```


```
fun fibM(x: Int) = ::fib.memoize()(x)
```


```
val gen = Arb.functionAToB<Int, Int>(Arb.int())
```