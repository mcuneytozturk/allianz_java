package model;

import java.util.ArrayList;

public class InsuranceRequest {
    private ArrayList<Proposal> proposalList;
    private Vehicle vehicle;

    public InsuranceRequest() {
    }

    public ArrayList<Proposal> getProposalList() {
        return proposalList;
    }

    public void setProposalList(ArrayList<Proposal> proposalList) {
        this.proposalList = proposalList;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

}
