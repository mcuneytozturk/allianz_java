package service;

import model.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CustomerService {

    ProposalService proposalService = new ProposalService();
    PaymentMovementService paymentMovementService = new PaymentMovementService();
    PolicyService policyService = new PolicyService();

    public Customer createCustomer(String name, CustomerTypeEnum customerType) {
        Customer customer = new Customer();

        customer.setName(name);
        customer.setCustomerTypeEnum(customerType);

        return customer;
    }

    public void addBankAccountToCustomer(Customer customer, BankAccount bankAccount) {
        if (customer.getBankAccountList() != null) {
            customer.getBankAccountList().add(bankAccount);
        } else {
            ArrayList<BankAccount> bankAccounts = new ArrayList<>();
            bankAccounts.add(bankAccount);
            customer.setBankAccountList(bankAccounts);
        }
    }

    public void addInsuranceRequestToCustomer(Customer customer, InsuranceRequest insuranceRequest) {
        if (customer.getInsuranceRequestList() != null) {
            customer.getInsuranceRequestList().add(insuranceRequest);
        } else {
            ArrayList<InsuranceRequest> insuranceRequests = new ArrayList<>();
            insuranceRequests.add(insuranceRequest);
            customer.setInsuranceRequestList(insuranceRequests);
        }
    }

    public void addPolicyToCustomer(Customer customer, Policy policy) {
        if (customer.getPolicyList() != null) {
            customer.getPolicyList().add(policy);
        } else {
            ArrayList<Policy> policies = new ArrayList<>();
            policies.add(policy);
            customer.setPolicyList(policies);
        }
    }

    public void addPaymentMovementToCustomer(Customer customer, PaymentMovement paymentMovement) {
        if (customer.getPaymentMovementList() != null) {
            customer.getPaymentMovementList().add(paymentMovement);
        } else {
            ArrayList<PaymentMovement> paymentMovements = new ArrayList<>();
            paymentMovements.add(paymentMovement);
            customer.setPaymentMovementList(paymentMovements);
        }

    }

    public void addVehicleToCustomer(Customer customer, Vehicle vehicle) {
        if (customer.getVehicleList() != null) {
            customer.getVehicleList().add(vehicle);
        } else {
            ArrayList<Vehicle> vehicles = new ArrayList<>();
            vehicles.add(vehicle);
            customer.setVehicleList(vehicles);
        }
    }

    public void acceptProposal(Customer customer, Proposal proposal, InsuranceRequest insuranceRequest, Agency agency) {
        List<InsuranceRequest> insuranceRequestList = customer.getInsuranceRequestList();

        for (InsuranceRequest request : insuranceRequestList) {
            if (request.equals(insuranceRequest)) {
                for (Proposal proposal1 : request.getProposalList()) {
                    if (proposal1.equals(proposal)) {
                        BigDecimal finalPrice = proposalService.calculateDiscountedPrice(proposal);
                        BankAccount customerBankAccount = checkBankAccount(customer, finalPrice);
                        if (customerBankAccount != null) {
                            BigDecimal commisionRate = proposal1.getCompany().getCommission();

                            PaymentMovement customerOutPaymentMovement = paymentMovementService.createPaymentMovement(customerBankAccount, "Sigorta ücreti", MovementTypeEnum.OUTCOME, finalPrice);

                            customerBankAccount.setAmount(customerBankAccount.getAmount().subtract(finalPrice));

                            this.addPaymentMovementToCustomer(customer, customerOutPaymentMovement);

                            BankAccount agencyBankAccount = agency.getBankAccountList().get(0);
                            PaymentMovement agencyInPaymentMovement = paymentMovementService.createPaymentMovement(agencyBankAccount, "Sigorta yapım komisyonu", MovementTypeEnum.INCOME, finalPrice.multiply(commisionRate));
                            agency.getPaymentMovementList().add(agencyInPaymentMovement);
                            agencyBankAccount.setAmount(agencyBankAccount.getAmount().add(finalPrice.multiply(commisionRate)));

                            InsuranceCompany insuranceCompany = proposal1.getCompany();
                            BankAccount insuranceCompanyBankAccount = proposal1.getCompany().getBankAccountList().get(0);
                            PaymentMovement companyInPaymentMovement = paymentMovementService.createPaymentMovement(insuranceCompanyBankAccount, "Sigorta yapım ücreti", MovementTypeEnum.INCOME, finalPrice.multiply(new BigDecimal(1.00).subtract(commisionRate)));
                            insuranceCompany.getPaymentMovementList().add(companyInPaymentMovement);
                            insuranceCompanyBankAccount.setAmount(insuranceCompanyBankAccount.getAmount().add(finalPrice.multiply(new BigDecimal(1.00).subtract(commisionRate))));

                            Policy policy = policyService.createPolicy(proposal.getCompany(), proposal.getVehicle(), finalPrice, proposal.getStartDate(), proposal.getEndDate());

                            if (customer.getPolicyList() != null) {
                                customer.getPolicyList().add(policy);
                            } else {
                                ArrayList<Policy> policyArrayList = new ArrayList<>();
                                policyArrayList.add(policy);
                                customer.setPolicyList(policyArrayList);
                            }
                        }
                        proposal1.setApproved(true);
                    }
                }
            }
        }
    }

    public BankAccount checkBankAccount(Customer customer, BigDecimal amount) {
        List<BankAccount> bankAccountList = customer.getBankAccountList();
        for (BankAccount bankAccount : bankAccountList) {
            if (bankAccount.getAmount().compareTo(amount) >= 0) {
                return bankAccount;
            }
        }
        return null;
    }
}
