import model.*;
import service.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        AgencyService agencyService = new AgencyService();
        BankAccountService bankAccountService = new BankAccountService();
        InsuranceCompanyService insuranceCompanyService = new InsuranceCompanyService();
        InsuranceService insuranceService = new InsuranceService();
        CustomerService customerService = new CustomerService();
        VehicleService vehicleService = new VehicleService();
        InsuranceRequestService insuranceRequestService = new InsuranceRequestService();
        ProposalService proposalService = new ProposalService();



        Agency agencyMom = agencyService.createAgency("mom");
        BankAccount bankAccountAgencyMom = bankAccountService.createBankAccount("Yapı Kredi", "TR330006100519786457841326", new BigDecimal(42093));

        agencyService.addBankAccountToAgency(agencyMom, bankAccountAgencyMom);
        System.out.println(agencyMom);


        BankAccount bankAccountAllianz = bankAccountService.createBankAccount("Yapı Kredi", "TR330006100519786457841326", new BigDecimal(100000));

        InsuranceCompany insuranceCompanyAllianz = insuranceCompanyService.createInsuranceCompany("Allianz", "Çankaya","/Ankara", "1231r1231", new BigDecimal(0.07));
        Insurance insurance = insuranceService.createInsurance("Compulsary Traffic Insurance", InsuranceTypeEnum.COMPULSORY_TRAFFIC_INSURANCE);

        insuranceCompanyService.addInsurancesToInsuranceCompany(insuranceCompanyAllianz, insurance);

        insuranceCompanyService.addBankAccountToInsuranceCompany(insuranceCompanyAllianz, bankAccountAllianz);

        agencyService.addInsuranceCompanyToAgency(agencyMom, insuranceCompanyAllianz);
        System.out.println("---------------");
        System.out.println(agencyMom);

        Customer customerCuneyt = customerService.createCustomer("Cüneyt", CustomerTypeEnum.INDIVIDUAL);
        BankAccount bankAccountCuneyt = bankAccountService.createBankAccount("Ziraat", "TR76 0009 9012 3456 7800 1000 01", new BigDecimal(50000));
        customerService.addBankAccountToCustomer(customerCuneyt, bankAccountCuneyt);
        agencyService.addCustomerToTheAgency(agencyMom, customerCuneyt);
        System.out.println("--------------");
        System.out.println(agencyMom);

        Vehicle vehicleMustang = vehicleService.createVehicle("Ford", "Mustang", "01 MCO 73", "871263781", 1964, ColorTypeEnum.BLUE);

        customerService.addVehicleToCustomer(customerCuneyt, vehicleMustang);
        System.out.println("----Customer----");
        System.out.println(customerCuneyt);

        InsuranceRequest insuranceRequest = insuranceRequestService.createInsuranceRequest(vehicleMustang);

        customerService.addInsuranceRequestToCustomer(customerCuneyt, insuranceRequest);

        LocalDate startDate = LocalDate.of(2023, Month.JUNE, 18);
        LocalDate endDate = LocalDate.of(2025, Month.JUNE, 18);
        LocalDate expireDate = startDate.plusDays(3);
        Proposal proposal = proposalService.createProposal(insuranceCompanyAllianz, vehicleMustang, new BigDecimal(10000), startDate, endDate, expireDate, new BigDecimal(100));

        insuranceRequestService.addProposalToInsuranceRequest(insuranceRequest, proposal);
    }
}