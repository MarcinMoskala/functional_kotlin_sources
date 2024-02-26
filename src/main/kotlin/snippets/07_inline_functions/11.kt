package f_07_inline_functions.s_11

class Worker
class Manager

val employees: List<Any> = listOf(Worker(), Manager(), Worker())

val workers: List<Worker> = employees.filterIsInstance<Worker>()
