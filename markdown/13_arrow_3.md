```
//1
data class Address(
    val zipcode: String,
    val country: String
)
data class Person(
    val name: String,
    val age: Int,
    val address: Address
)
```


```
fun Person.happyBirthday(): Person =
    copy(age = age + 1)
```


```
fun Person.normalizeCountry(): Person =
    copy(
        address = address
            .copy(country = address.country.capitalize())
    )
```


```
@optics
data class Address(
    val zipcode: String,
    val country: String
) {
    companion object
}

@optics
data class Person(
    val name: String,
    val age: Int,
    val address: Address
) {
    companion object
}
```


```
fun Person.happyBirthday(): Person {
    val currentAge = Person.age.get(this)
    return Person.age.set(this, currentAge + 1)
}
```


```
fun Person.happyBirthday(): Person =
    Person.age.modify(this) { it + 1 }
```


```
fun Person.normalizeCountry(): Person =
    (Person.address compose Address.country).modify(this) {
        it.capitalize()
    }
```


```
fun Person.normalizeCountry(): Person =
    (Person.address.country).modify(this) { it.capitalize() }
```


```
@optics
data class BirthdayResult(
    val day: LocalDate,
    val people: List<Person>
) {
    companion object
}
```


```
fun BirthdayResult.happyBirthday(): BirthdayResult =
    copy(people = people.map { it.copy(age = it.age + 1) })
```


```
fun BirthdayResult.happyBirthday2(): BirthdayResult =
    (BirthdayResult.people
    compose Every.list()
    compose Person.age)
        .modify(this) { it + 1 }
```