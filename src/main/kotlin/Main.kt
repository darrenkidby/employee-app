import kotlin.math.round

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
    println("Payslip")
    payslip()
    println("")
    println("Payslip With Two Decimal Places")
    payslipTwoDecimalPlace()
}

fun twoDecimalPlaces(number: Double) = round(number * 100) / 100

fun payslip(){
    println("""
    -------------------------------------------------------------------------
    |                            Monthly Payslip                            |
    |-----------------------------------------------------------------------|
    |                                                                       |
    |  Employee Name: ${firstName.uppercase()} ${surname.uppercase()} (${gender.uppercase()})                       Employee ID: ${employeeId}  |
    |                                                                       |
    |-----------------------------------------------------------------------|
    |                                                                       |
    |  PAYMENT DETAILS                  DEDUCTION DETAILS                   |
    |                                                                       |
    |-----------------------------------------------------------------------|
    |  Salary: ${mSal}        PAYE: ${monthPAYE}            |
    |  Bonus: ${mBonus}                   PRSI: ${monthPRSI}             |
    |                                   Cycle to Work: ${cycle}                |
    |-----------------------------------------------------------------------|
    |  Gross: ${gross}         Total Deductions: ${deductions} |
    |-----------------------------------------------------------------------|
    |               NET PAY: ${net}                              |
    |-----------------------------------------------------------------------|""")
}

fun payslipTwoDecimalPlace(){
    println("""
    -------------------------------------------------------------------------
    |                            Monthly Payslip                            |
    |-----------------------------------------------------------------------|
    |                                                                       |
    |  Employee Name: ${firstName.uppercase()} ${surname.uppercase()} (${gender.uppercase()})                       Employee ID: ${employeeId}  |
    |                                                                       |
    |-----------------------------------------------------------------------|
    |                                                                       |
    |  PAYMENT DETAILS                       DEDUCTION DETAILS              |
    |                                                                       |
    |-----------------------------------------------------------------------|
    |  Salary: ${twoDecimalPlaces(mSal)}                        PAYE: ${twoDecimalPlaces(monthPAYE)}                  |
    |  Bonus: ${twoDecimalPlaces(mBonus)}                         PRSI: ${twoDecimalPlaces(monthPRSI)}                   |
    |                                        Cycle to Work: ${twoDecimalPlaces(cycle)}           |
    |-----------------------------------------------------------------------|
    |  Gross: ${twoDecimalPlaces(gross)}                        Total Deductions: ${twoDecimalPlaces(deductions)}      |
    |-----------------------------------------------------------------------|
    |               NET PAY: ${twoDecimalPlaces(net)}                                        |
    |-----------------------------------------------------------------------|""")
}