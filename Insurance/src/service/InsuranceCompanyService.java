package service;

import model.BankAccount;
import model.Insurance;
import model.InsuranceCompany;
import model.PaymentMovement;

import java.math.BigDecimal;
import java.util.ArrayList;

public class InsuranceCompanyService {
    public InsuranceCompany createInsuranceCompany(String taxOffice, String taxNumber, String address, BigDecimal commision){
        InsuranceCompany insuranceCompany = new InsuranceCompany();
        insuranceCompany.setTaxOffice(taxOffice);
        insuranceCompany.setTaxNumber(taxNumber);;
        insuranceCompany.setAddress(address);
        insuranceCompany.setCommission(commision);
        return insuranceCompany;
    }

    public void addInsurancesToInsuranceCompany(InsuranceCompany insuranceCompany, Insurance insurance){
        if(insuranceCompany.getInsuranceList() != null){
            insuranceCompany.getInsuranceList().add(insurance);
        } else {
            ArrayList<Insurance> insurances = new ArrayList<>();
            insurances.add(insurance);
            insuranceCompany.setInsuranceList(insurances);
        }
    }

    public void addBankAccountToInsuranceCompany(InsuranceCompany insuranceCompany, BankAccount bankAccount){
        if(insuranceCompany.getBankAccountList() != null){
            insuranceCompany.getBankAccountList().add(bankAccount);
        } else {
            ArrayList<BankAccount> bankAccounts = new ArrayList<>();
            bankAccounts.add(bankAccount);
            insuranceCompany.setBankAccountList(bankAccounts);
        }
    }
    public void addPaymentMovementToInsuranceCompany(InsuranceCompany insuranceCompany, PaymentMovement paymentMovement){
        if(insuranceCompany.getPaymentMovementList() != null){
            insuranceCompany.getPaymentMovementList().add(paymentMovement);
        } else {
            ArrayList<PaymentMovement> paymentMovements = new ArrayList<>();
            paymentMovements.add(paymentMovement);
            insuranceCompany.setPaymentMovementList(paymentMovements);
        }
    }
}
