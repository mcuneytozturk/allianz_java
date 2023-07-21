package service;

import model.Agency;
import model.InsuranceRequest;
import model.Proposal;
import model.Vehicle;

import java.util.ArrayList;

public class InsuranceRequestService {
    public InsuranceRequest createInsuranceRequest(Vehicle vehicle){
        InsuranceRequest insuranceRequest = new InsuranceRequest();
        insuranceRequest.setVehicle(vehicle);
        return insuranceRequest;
    }

    public void addProposalToInsuranceRequest(InsuranceRequest insuranceRequest, Proposal proposal){
        if(insuranceRequest.getProposalList() != null){
            insuranceRequest.getProposalList().add(proposal);
        } else{
            ArrayList<Proposal> proposals = new ArrayList<>();
            proposals.add(proposal);
            insuranceRequest.setProposalList(proposals);
        }
    }
}
