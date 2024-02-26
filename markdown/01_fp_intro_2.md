```
//1
fun sum(a: Int, b: Int): Int {
    var sum = 0
    for (i in a..b) {
        sum += i
    }
    return sum
}

fun product(a: Int, b: Int): Int {
    var product = 1
    for (i in a..b) {
        product *= i
    }
    return product
}

fun main() {
    sum(5, 10) // 45
    product(5, 10) // 151200
}
```


```
// Java 7
public class RangeOperations {

    public static int sum(int a, int b) {
        return fold(a, b, 0, new Operation() {
            @Override
            public int invoke(int left, int right) {
                return a + b;
            }
        });
    }

    public static int product(int a, int b) {
        return fold(a, b, 1, new Operation() {
            @Override
            public int invoke(int left, int right) {
                return a * b;
            }
        });
    }

    private interface Operation {
        int invoke(int left, int right);
    }

    private static int fold(
            int a,
            int b,
            int initial,
            Operation operation
    ) {
        int acc = initial;
        for (int i = a; i <= b; i++) {
            acc = operation.invoke(acc, i);
        }
        return acc;
    }
}
```


```
//2
fun sum(a: Int, b: Int) = fold(a, b, 0, { acc, i -> acc + i })

fun product(a: Int, b: Int) = fold(a, b, 1, { acc, i -> acc * i })

fun fold(
    a: Int,
    b: Int,
    initial: Int,
    operation: (Int, Int) -> Int
): Int {
    var acc = initial
    for (i in a..b) {
        acc = operation(acc, i)
    }
    return acc
}
```


```
//3
fun sum(a: Int, b: Int) = (a..b).fold(0) { acc, i -> acc + i }

fun product(a: Int, b: Int) = (a..b).fold(1) { acc, i -> acc * i }
```


```
//4
fun sum(a: Int, b: Int) = (a..b).fold(0, Int::plus)

fun product(a: Int, b: Int) = (a..b).fold(1, Int::times)
```


```
//5
fun sum(a: Int, b: Int) = (a..b).sum()

fun product(a: Int, b: Int) = (a..b).fold(1, Int::times)
```


```
fun produceDepartmentSummaries(
    employees: List<Employee>
): List<DepartmentSummary> = employees
    .filter { it.age > 30 }
    .groupBy { it.department }
    .map { (department, employees) ->
        DepartmentSummary(
            department = department,
            topEmployees = employees.asSequence()
                .sortedByDescending { it.salary }
                .take(3)
                .map { EmployeeInfo(it.name, it.salary) }
                .toList()
        )
    }
```


```
val html = html {
    head {
        title { +"HTML encoding with Kotlin" }
    }
    body {
        div {
            a("https://kotlinlang.org") {
                target = ATarget.blank
                +"Main site"
            }
        }
        +"Some content"
    }
}
```


```
class UserCreationService(
    private val userRepository: UserRepository,
    private val userDtoFactory: UserDtoFactory,
) {
    fun addUser(request: UserCreationRequest): User? =
        request.let(userDtoFactory::fromRequest)
            .also(userRepository::addUser)
            ?.let(userDtoFactory::toUser)
}
```