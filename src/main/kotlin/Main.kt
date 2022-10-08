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
    var input : Int

    do {
        input = menu()
        when (input) {
            1 -> println("Monthly Salary: ${getMonthlySalary()}")
            2 -> println ("Monthly PAYE: ${getMonthlyPaye()}")
            3 -> println ("Monthly PRSI: ${getMonthlyPrsi()}")
            4 -> println ("Monthly Gross Pay: ${getGrossMonthlyPay()}")
            5 -> println ("Monthly Total Deductions: ${getTotalMonthlyDeductions()}")
            6 -> println ("Monthly Net Pay: ${getNetMonthlyPay()}")
            7 -> println (getPayslip())
            -1 -> println("Exiting App")
            else -> println("Invalid Option")
        }
        println()
    } while (input != -1)
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

fun getPayslip(){
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

fun menu() : Int {
    print("""
        Employee Menu for ${fullName()}
            1. Monthly Salary
            2. Monthly PAYE
            3. Monthly PRSI
            4. Monthly Gross Pay
            5. Monthly Total Deductions
            6. Monthly Net Pay
            7. Full Payslip
           -1. Exit
        Enter Option: """)
        return readLine()!!.toInt()
}