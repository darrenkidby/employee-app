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
var mBonus = (annualBonus/12)

fun main(args: Array<String>) {
    println(fullName())
    println("")
    println("Monthly Salary: ${getMonthlySalary()}")
    println("Monthly PAYE: ${getMonthlyPaye()}")
    println("Monthly PRSI: ${getMonthlyPrsi()}")
    println("Gross: ${getGrossMonthlyPay()}")
    println("Total Deductions: ${getTotalMonthlyDeductions()}")
    println("Net Pay: ${getNetMonthlyPay()}")
    println("")
    println("Payslip")
    payslip()
}

fun twoDecimalPlaces(number: Double) = round(number * 100) / 100

fun fullName() = when (gender){
    "m", "M", "Male", "male" -> "Mr. $firstName $surname"
    "f", "F", "Female", "female" -> "Ms. $firstName $surname"
    else -> "$firstName $surname"
}

fun getMonthlySalary() = twoDecimalPlaces(grossSalary/12)

fun getMonthlyPaye() = twoDecimalPlaces(getMonthlySalary() * (paye / 100))

fun getMonthlyPrsi() = twoDecimalPlaces(getMonthlySalary() * (prsi / 100))

fun getGrossMonthlyPay() = twoDecimalPlaces(getMonthlySalary() + mBonus)

fun getTotalMonthlyDeductions() = twoDecimalPlaces(getMonthlyPaye() + getMonthlyPrsi() + cycle)

fun getNetMonthlyPay() = twoDecimalPlaces(getGrossMonthlyPay() - getTotalMonthlyDeductions())

fun payslip(){
    println("""
    -----------------------------------------------------------------------
                                Monthly Payslip                            
    -----------------------------------------------------------------------
                                                                           
        Employee Name: ${fullName().uppercase()} (${gender.uppercase()})           
        Employee ID: ${employeeId}  
                                                                           
    -----------------------------------------------------------------------
                                                                           
    PAYMENT DETAILS             
                                                                           
    -----------------------------------------------------------------------
        Salary: ${getMonthlySalary()}                  
        Bonus: ${twoDecimalPlaces(mBonus)}                           
        
        Gross: ${twoDecimalPlaces(getGrossMonthlyPay())}     
    -----------------------------------------------------------------------
                                                                           
    DEDUCTION DETAILS              
                                                                           
    -----------------------------------------------------------------------
        PAYE: ${getMonthlyPaye()}                  
        PRSI: ${getMonthlyPrsi()}                   
        Cycle to Work: ${twoDecimalPlaces(cycle)}           
        
        Total Deductions: ${getTotalMonthlyDeductions()}      
    -----------------------------------------------------------------------
    NET PAY: ${getNetMonthlyPay()}                                        
    -----------------------------------------------------------------------""")
}