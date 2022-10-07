var firstName = "Joe"
var surname = "Soap"
var gender = "m"
var employeeId = 6143
var grossSalary = 67543.21
var paye = 38.5
var prsi = 5.2
var annualBonus = 1450.50
var cycle = 54.33

fun main(args: Array<String>) {
    println("-------------------------------------------------------------------------")
    println("|                            Monthly Payslip                            |")
    println("|-----------------------------------------------------------------------|")
    println("|                                                                       |")
    println("|  Employee Name: " + firstName + " " + surname + " (" + gender + ")                       Employee ID: " + employeeId + "  |")
    println("|                                                                       |")
    println("|-----------------------------------------------------------------------|")
    println("|                                                                       |")
    println("|  PAYMENT DETAILS                       DEDUCTION DETAILS              |")
    println("|                                                                       |")
    println("|-----------------------------------------------------------------------|")
    println("|  Salary: " + grossSalary + "                      PAYE: " + paye + "                     |")
    println("|  Bonus: " + annualBonus + "                         PRSI: " +  prsi + "                      |")
    println("|                                        Cycle to Work: " + cycle + "           |")
    println("|-----------------------------------------------------------------------|")
    println("|  Gross: " + grossSalary + "                       Total Deductions: " + (paye + prsi + cycle) +"        |")
    println("|-----------------------------------------------------------------------|")
    println("|               NET PAY: " + (paye + prsi + cycle) + "                                          |")
    println("|-----------------------------------------------------------------------|")
}