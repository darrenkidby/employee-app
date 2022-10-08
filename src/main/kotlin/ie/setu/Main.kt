import ie.setu.models.Employee
import ie.setu.controllers.EmployeeAPI
import mu.KotlinLogging

val logger = KotlinLogging.logger {}
var employees = EmployeeAPI ()
var colour = "\u001b[36m"
var bold = "\u001B[1m"
var normal = "\u001b[0m"


fun main(args: Array<String>){
    logger.info { "Launching Employee App" }
    logger.info { "You will Have to Know the Employee ID" }
    logger.info { "For Dummy Data, Type -99" }
    start()
}

fun menu() : Int {
    print(""" ${colour}
         |${bold}Employee Menu
         |   1. Add Employee
         |   2. Delete Employee
         |   3. Update Employee
         |   4. List All Employees
         |   5. Search Employees 
         |   6. Print Payslip for Employee
         |  -1. Exit
         |       
         |Enter Option : ${normal}""".trimMargin())
    return readLine()!!.toInt()
}

fun add(){
    print("Enter first name: ")
    val firstName = readLine().toString()
    print("Enter surname: ")
    val surname = readLine().toString()
    print("Enter gender (m/f): ")
    val gender = readLine()!!.toCharArray()[0]
    print("Enter gross salary: ")
    val grossSalary = readLine()!!.toDouble()
    print("Enter PAYE %: ")
    val paye = readLine()!!.toDouble()
    print("Enter PRSI %: ")
    val prsi = readLine()!!.toDouble()
    print("Enter Annual Bonus: ")
    val annualBonus= readLine()!!.toDouble()
    print("Enter Cycle to Work Deduction: ")
    val cycle= readLine()!!.toDouble()

    employees.create(Employee(firstName, surname, gender, 0, grossSalary, paye, prsi, annualBonus, cycle))
}

fun start() {
    var input: Int

    do {
        input = menu()
        when (input) {
            1 -> add()
            2 -> delete()
            3 -> update()
            4 -> list()
            5 -> search()
            6 -> paySlip()
            -99 -> dummyData()
            -1 -> println("Exiting App")
            else -> println("Invalid Option")
        }
        println()
    } while (input != -1)
}

fun list(){
    employees.findAll()
        .forEach{ println(it) }
}

fun search() {
    val employee = getEmployeeById()
    if (employee == null)
        println("No employee found")
    else
        println(employee)
}

internal fun getEmployeeById(): Employee? {
    print("Enter the employee id to search by: ")
    val employeeID = readLine()!!.toInt()
    return employees.findOne(employeeID)
}

fun paySlip(){
    val employee = getEmployeeById()
    if (employee != null)
        println(employee.getPayslip())
}


fun delete() {
    val employee = getEmployeeById()
    return employees.destroy(employee)
}

fun update() {
    val employee = getEmployeeById()
    print("Enter first name: ")
    val firstName = readLine().toString()
    print("Enter surname: ")
    val surname = readLine().toString()
    print("Enter gender (m/f): ")
    val gender = readLine()!!.toCharArray()[0]
    print("Enter gross salary: ")
    val grossSalary = readLine()!!.toDouble()
    print("Enter PAYE %: ")
    val paye = readLine()!!.toDouble()
    print("Enter PRSI %: ")
    val prsi = readLine()!!.toDouble()
    print("Enter Annual Bonus: ")
    val annualBonus= readLine()!!.toDouble()
    print("Enter Cycle to Work Deduction: ")
    val cycle= readLine()!!.toDouble()

    employees.changed(Employee(firstName, surname, gender, 0, grossSalary, paye, prsi, annualBonus, cycle))
    return employees.edit(employee)
}

fun dummyData() {
    employees.create(Employee("Joe", "Soap", 'm', 0, 35655.43, 31.0, 7.5, 2000.0, 25.6))
    employees.create(Employee("Joan", "Murphy", 'f', 0, 54255.13, 32.5, 7.0, 1500.0, 55.3))
    employees.create(Employee("Mary", "Quinn", 'f', 0, 75685.41, 40.0, 8.5, 4500.0, 0.0))
}