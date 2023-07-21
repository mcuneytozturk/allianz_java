package service;

import model.InsuranceCompany;
import model.Proposal;
import model.Vehicle;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ProposalService {

    VehicleService vehicleService = new VehicleService();

    public Proposal createProposal(InsuranceCompany insuranceCompany, Vehicle vehicle, BigDecimal offerPrice, LocalDate startDate, LocalDate endDate, LocalDate expireDate, BigDecimal discountPrice) {
        Proposal proposal = new Proposal();
        proposal.setCompany(insuranceCompany);
        proposal.setEndDate(endDate);
        proposal.setStartDate(startDate);
        proposal.setVehicle(vehicle);
        proposal.setExpireDate(expireDate);
        proposal.setOfferPrice(offerPrice);
        proposal.setDiscountPrice(discountPrice);
        proposal.setOfferPrice(calculateAccordingToAccidentOfferPrice(offerPrice, vehicle));

        return proposal;
    }

    public BigDecimal calculateDiscountedPrice(Proposal proposal) {
        if (proposal.getDiscountPrice() != null) {
            return proposal.getOfferPrice().subtract(proposal.getDiscountPrice());
        } else {
            return proposal.getOfferPrice();
        }
    }

    public BigDecimal calculateAccordingToAccidentOfferPrice(BigDecimal offerPrice, Vehicle vehicle) {
        BigDecimal totalOfferPrice = BigDecimal.ZERO;

        BigDecimal totalDamagePrice = vehicleService.totalOfAccidentDamagePrice(vehicle);
        if (totalDamagePrice.equals(BigDecimal.ZERO)) {
            totalOfferPrice = offerPrice;
        } else if (totalDamagePrice.compareTo(BigDecimal.ZERO) > 0 && totalDamagePrice.compareTo(new BigDecimal(4000)) <= 0) {
            totalOfferPrice = offerPrice.add(offerPrice.multiply(new BigDecimal(0.1)));
        } else if (totalDamagePrice.compareTo(new BigDecimal(4000)) > 0 && totalDamagePrice.compareTo(new BigDecimal(8000)) <= 0) {
            totalOfferPrice = offerPrice.add(offerPrice.multiply(new BigDecimal(0.25)));
        } else if (totalDamagePrice.compareTo(new BigDecimal(8000)) > 0 && totalDamagePrice.compareTo(new BigDecimal(12000)) <= 0) {
            totalOfferPrice = offerPrice.add(offerPrice.multiply(new BigDecimal(0.40)));
        } else {
            totalOfferPrice = offerPrice.add(offerPrice.multiply(new BigDecimal(0.80)));
        }
        return totalOfferPrice;
    }
}
