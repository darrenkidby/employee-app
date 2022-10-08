package ie.setu.employeeApp

import kotlin.math.round

class Employee (var firstName: String, var surname: String, var gender: Char, var employeeId: Int,
                var grossSalary: Double, var paye: Double, var prsi: Double, var annualBonus: Double,
                var cycle: Double) {

    fun fullName() = when (gender) {
        'm', 'M' -> "Mr. ${firstName} ${surname}"
        'f', 'F' -> "Ms. ${firstName} ${surname}"
        else -> "${firstName} ${surname}"
    }

    fun getMonthlySalary() = twoDecimalPlaces(grossSalary / 12)
    fun getMonthlyBonus() = twoDecimalPlaces(annualBonus / 12)
    fun getMonthlyPaye() = twoDecimalPlaces(getMonthlySalary() * (paye / 100))
    fun getMonthlyPrsi() = twoDecimalPlaces(getMonthlySalary() * (prsi / 100))
    fun getGrossMonthlyPay() = twoDecimalPlaces(getMonthlySalary() + getMonthlyBonus())
    fun getTotalMonthlyDeductions() = twoDecimalPlaces(getMonthlyPaye() + getMonthlyPrsi() + cycle)
    fun getNetMonthlyPay() = twoDecimalPlaces(getGrossMonthlyPay() - getTotalMonthlyDeductions())

    fun getPayslip() {
        println(
            """
    -----------------------------------------------------------------------
                                Monthly Payslip                            
    -----------------------------------------------------------------------
                                                                           
        Employee Name: ${fullName().uppercase()} (${gender.uppercase()})           
        Employee ID: ${employeeId}  
                                                                           
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
        Cycle to Work: ${twoDecimalPlaces(cycle)}           
        
        Total Deductions: ${getTotalMonthlyDeductions()}      
    -----------------------------------------------------------------------
    NET PAY: ${getNetMonthlyPay()}                                        
    -----------------------------------------------------------------------"""
        )
    }
    fun twoDecimalPlaces(number: Double) = round(number * 100) / 100

    override fun toString(): String {
        return "Employee(firstName='$firstName', surname='$surname', gender=$gender, employeeID=$employeeId, grossSalary=$grossSalary, payePercentage=$paye, prsiPercentage=$prsi, annualBonus=$annualBonus, cycleToWorkMonthlyDeduction=$cycle)"
    }
}