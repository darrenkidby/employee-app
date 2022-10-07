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

fun getMonthlySalary() = (grossSalary/12)
fun getMonthlyPaye() = getMonthlySalary() * (paye / 100)
fun getMonthlyPrsi() = getMonthlySalary() * (prsi / 100)
fun getGrossMonthlyPay() = getMonthlySalary() + mBonus
fun getTotalMonthlyDeductions() = getMonthlyPaye() + getMonthlyPrsi() + cycle
fun getNetMonthlyPay() = getGrossMonthlyPay() - getTotalMonthlyDeductions()

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
        Salary: ${twoDecimalPlaces(getMonthlySalary())}                  
        Bonus: ${twoDecimalPlaces(mBonus)}                           
        
        Gross: ${twoDecimalPlaces(getGrossMonthlyPay())}     
    -----------------------------------------------------------------------
                                                                           
    DEDUCTION DETAILS              
                                                                           
    -----------------------------------------------------------------------
        PAYE: ${twoDecimalPlaces(getMonthlyPaye())}                  
        PRSI: ${twoDecimalPlaces(getMonthlyPrsi())}                   
        Cycle to Work: ${twoDecimalPlaces(cycle)}           
        
        Total Deductions: ${twoDecimalPlaces(getTotalMonthlyDeductions())}      
    -----------------------------------------------------------------------
    NET PAY: ${twoDecimalPlaces(getNetMonthlyPay())}                                        
    -----------------------------------------------------------------------""")
}