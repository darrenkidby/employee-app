import ie.setu.employeeApp.Employee
import kotlin.math.round

var employee = Employee ("Joe", "Soap", 'm', 6143, 67543.21, 38.5, 5.2, 1450.50, 54.33)

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

fun fullName() = when (employee.gender){
    'm', 'M' -> "Mr. ${employee.firstName} ${employee.surname}"
    'f', 'F' -> "Ms. ${employee.firstName} ${employee.surname}"
    else -> "${employee.firstName} ${employee.surname}"
}

fun getMonthlySalary() = twoDecimalPlaces(employee.grossSalary/12)

fun getMonthlyBonus() = twoDecimalPlaces(employee.annualBonus/12)

fun getMonthlyPaye() = twoDecimalPlaces(getMonthlySalary() * (employee.paye / 100))

fun getMonthlyPrsi() = twoDecimalPlaces(getMonthlySalary() * (employee.prsi / 100))

fun getGrossMonthlyPay() = twoDecimalPlaces(getMonthlySalary() + getMonthlyBonus())

fun getTotalMonthlyDeductions() = twoDecimalPlaces(getMonthlyPaye() + getMonthlyPrsi() + employee.cycle)

fun getNetMonthlyPay() = twoDecimalPlaces(getGrossMonthlyPay() - getTotalMonthlyDeductions())

fun getPayslip(){
    println("""
    -----------------------------------------------------------------------
                                Monthly Payslip                            
    -----------------------------------------------------------------------
                                                                           
        Employee Name: ${fullName().uppercase()} (${employee.gender.uppercase()})           
        Employee ID: ${employee.employeeId}  
                                                                           
    -----------------------------------------------------------------------
                                                                           
    PAYMENT DETAILS             
                                                                           
    -----------------------------------------------------------------------
        Salary: ${getMonthlySalary()}                  
        Bonus: ${twoDecimalPlaces(getMonthlyBonus())}                           
        
        Gross: ${twoDecimalPlaces(getGrossMonthlyPay())}     
    -----------------------------------------------------------------------
                                                                           
    DEDUCTION DETAILS              
                                                                           
    -----------------------------------------------------------------------
        PAYE: ${getMonthlyPaye()}                  
        PRSI: ${getMonthlyPrsi()}                   
        Cycle to Work: ${twoDecimalPlaces(employee.cycle)}           
        
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