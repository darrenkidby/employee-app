var firstName = "Joe"
var surname = "Soap"
var gender = "m"
var employeeId = 6143
var grossSalary = 67543.21
var paye = 38.5
var prsi = 5.2
var annualBonus = 1450.50
var cycle = 54.33

var mSal = (grossSalary/12)
var mBonus = (annualBonus/12)
var monthPAYE = mSal * (paye / 100)
var monthPRSI = mSal * (prsi / 100)
var gross = mSal + mBonus
var deductions = monthPAYE + monthPRSI + cycle
var net = gross - deductions

fun main(args: Array<String>) {
    println("-------------------------------------------------------------------------")
    println("|                            Monthly Payslip                            |")
    println("|-----------------------------------------------------------------------|")
    println("|                                                                       |")
    println("|  Employee Name: " + firstName.uppercase() + " " + surname.uppercase() + " (" + gender.uppercase() + ")                       Employee ID: " + employeeId + "  |")
    println("|                                                                       |")
    println("|-----------------------------------------------------------------------|")
    println("|                                                                       |")
    println("|  PAYMENT DETAILS                  DEDUCTION DETAILS                   |")
    println("|                                                                       |")
    println("|-----------------------------------------------------------------------|")
    println("|  Salary: " + mSal + "        PAYE: " + monthPAYE + "            |")
    println("|  Bonus: " + mBonus + "                   PRSI: " +  monthPRSI + "             |")
    println("|                                   Cycle to Work: " + cycle + "                |")
    println("|-----------------------------------------------------------------------|")
    println("|  Gross: " + gross + "         Total Deductions: " + deductions + " |")
    println("|-----------------------------------------------------------------------|")
    println("|               NET PAY: " + net + "                              |")
    println("|-----------------------------------------------------------------------|")
}