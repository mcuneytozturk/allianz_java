package service;

import model.*;

import java.util.ArrayList;

public class AgencyService {
    public Agency createAgency(String name){
        Agency agency = new Agency();
        agency.setName(name);
        return agency;
    }
    public void addBankAccountToAgency(Agency agency, BankAccount bankAccount){
        if (agency.getBankAccountList() != null){
            agency.getBankAccountList().add(bankAccount);
        } else {
            ArrayList<BankAccount> bankAccounts = new ArrayList<>();
            bankAccounts.add(bankAccount);
            agency.setBankAccountList(bankAccounts);
        }
    }

    public void addPaymentMovementToAgency(Agency agency, PaymentMovement paymentMovement){
        if(agency.getPaymentMovementList() != null){
            agency.getPaymentMovementList().add(paymentMovement);
        } else {
            ArrayList<PaymentMovement> paymentMovements = new ArrayList<>();
            paymentMovements.add(paymentMovement);
            agency.setPaymentMovementList(paymentMovements);
        }

    }

    public void addInsuranceCompanyToAgency(Agency agency, InsuranceCompany insuranceCompany){
        if( agency.getInsuranceCompanyList() != null) {
            agency.getInsuranceCompanyList().add(insuranceCompany);
        } else {
            ArrayList<InsuranceCompany> insuranceCompanyList = new ArrayList<>();
            insuranceCompanyList.add(insuranceCompany);
            agency.setInsuranceCompanyList(insuranceCompanyList);
        }

    }

    public void addCustomerToTheAgency(Agency agency, Customer customer){
        if(agency.getCustomerList()!=null){
            agency.getCustomerList().add(customer);
        } else {
            ArrayList<Customer> customers = new ArrayList<>();
            customers.add(customer);
            agency.setCustomerList(customers);
        }
    }

}
