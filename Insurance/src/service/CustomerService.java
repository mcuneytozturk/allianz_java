package service;

import model.*;

import java.util.ArrayList;

public class CustomerService {
    public Customer createCustomer(String name, CustomerTypeEnum customerType){
        Customer customer = new Customer();

        customer.setName(name);
        customer.setCustomerTypeEnum(customerType);

        return customer;
    }

    public void addBankAccountToCustomer(Customer customer, BankAccount bankAccount){
        if(customer.getBankAccountList() != null){
            customer.getBankAccountList().add(bankAccount);
        } else {
            ArrayList<BankAccount> bankAccounts = new ArrayList<>();
            bankAccounts.add(bankAccount);
            customer.setBankAccountList(bankAccounts);
        }
    }

    public void addInsuranceRequestToCustomer(Customer customer, InsuranceRequest insuranceRequest){
        if(customer.getInsuranceRequestList() != null){
            customer.getInsuranceRequestList().add(insuranceRequest);
        } else {
            ArrayList<InsuranceRequest> insuranceRequests = new ArrayList<>();
            insuranceRequests.add(insuranceRequest);
            customer.setInsuranceRequestList(insuranceRequests);
        }
    }

    public void addPolicyToCustomer(Customer customer, Policy policy){
        if(customer.getPolicyList() != null){
            customer.getPolicyList().add(policy);
        } else {
            ArrayList<Policy> policies = new ArrayList<>();
            policies.add(policy);
            customer.setPolicyList(policies);
        }
    }

    public void addPaymentMovementToCustomer(Customer customer, PaymentMovement paymentMovement){
        if(customer.getPaymentMovementList() != null){
            customer.getPaymentMovementList().add(paymentMovement);
        }

    }
}
