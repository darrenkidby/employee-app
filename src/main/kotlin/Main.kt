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
    println(fullName())
    println("")
    println("")
    println("Payslip")
    payslip()
    println("")
    println("")
    println("Payslip With Two Decimal Places")
    payslipTwoDecimalPlace()
}

fun twoDecimalPlaces(number: Double) = round(number * 100) / 100

fun fullName() = when (gender){
    "m", "M", "Male", "male" -> "Mr. $firstName $surname"
    "f", "F", "Female", "female" -> "Ms. $firstName $surname"
    else -> "$firstName $surname"
}

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
        Salary: ${mSal}         
        Bonus: ${mBonus}                                
        
        Gross: ${gross} 
    -----------------------------------------------------------------------
    
    DEDUCTION DETAILS
    
    -----------------------------------------------------------------------
        PAYE: ${monthPAYE}
        PRSI: ${monthPRSI}
        Cycle to Work: ${cycle}
        
        Total Deductions: ${deductions}
    -----------------------------------------------------------------------
    NET PAY: ${net}                              
    -----------------------------------------------------------------------""")
}

fun payslipTwoDecimalPlace(){
    println("""
    -----------------------------------------------------------------------
                                Monthly Payslip                            
    -----------------------------------------------------------------------
                                                                           
        Employee Name: ${fullName().uppercase()} (${gender.uppercase()})           
        Employee ID: ${employeeId}  
                                                                           
    -----------------------------------------------------------------------
                                                                           
    PAYMENT DETAILS             
                                                                           
    -----------------------------------------------------------------------
        Salary: ${twoDecimalPlaces(mSal)}                  
        Bonus: ${twoDecimalPlaces(mBonus)}                           
        
        Gross: ${twoDecimalPlaces(gross)}     
    -----------------------------------------------------------------------
                                                                           
    DEDUCTION DETAILS              
                                                                           
    -----------------------------------------------------------------------
        PAYE: ${twoDecimalPlaces(monthPAYE)}                  
        PRSI: ${twoDecimalPlaces(monthPRSI)}                   
        Cycle to Work: ${twoDecimalPlaces(cycle)}           
        
        Total Deductions: ${twoDecimalPlaces(deductions)}      
    -----------------------------------------------------------------------
    NET PAY: ${twoDecimalPlaces(net)}                                        
    -----------------------------------------------------------------------""")
}