var firstName = "Joe"
var surname = "Soap"
var gender = "m"
var employeeId = 6143
var grossSalary = 67543.21
var paye = 38.5
var prsi = 5.2
var annualBonus = 1450.50
var cycle = 54.33

var a = 12
var b: Double= grossSalary
var c: Double= annualBonus
var d: Double= paye
var e: Double= prsi

fun divide(a: Int, b: Double): Double {
    return b/a
}

fun divide2(a: Int, c: Double): Double {
    return c/a
}

fun main(args: Array<String>) {
    println("-------------------------------------------------------------------------")
    println("|                            Monthly Payslip                            |")
    println("|-----------------------------------------------------------------------|")
    println("|                                                                       |")
    println("|  Employee Name: " + firstName.uppercase() + " " + surname.uppercase() + " (" + gender.uppercase() + ")                       Employee ID: " + employeeId + "  |")
    println("|                                                                       |")
    println("|-----------------------------------------------------------------------|")
    println("|                                                                       |")
    println("|  PAYMENT DETAILS                       DEDUCTION DETAILS              |")
    println("|                                                                       |")
    println("|-----------------------------------------------------------------------|")
    println("|  Salary: " + (divide(a, b)) + "             PAYE: " + ((divide(a, b)) * (paye / 100)) + "       |")
    println("|  Bonus: " + (divide2(a, c)) + "                        PRSI: " +  ((divide(a, b)) * (prsi / 100)) + "        |")
    println("|                                        Cycle to Work: " + cycle + "           |")
    println("|-----------------------------------------------------------------------|")
    println("|  Gross: " + ((divide(a, b)) + (divide2(a, c))) + "              Total Deductions: " + (paye + prsi + cycle) +"        |")
    println("|-----------------------------------------------------------------------|")
    println("|               NET PAY: " + ((divide(a, b)) + (divide2(a, c) - (paye + prsi + cycle))) + "                              |")
    println("|-----------------------------------------------------------------------|")
}