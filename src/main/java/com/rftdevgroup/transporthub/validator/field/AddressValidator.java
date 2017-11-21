package com.rftdevgroup.transporthub.validator.field;

import com.rftdevgroup.transporthub.data.model.user.Address;
import com.rftdevgroup.transporthub.validator.ValidationErrors;
import org.springframework.stereotype.Component;

@Component
public class AddressValidator implements ObjectFieldValidator<Address> {
    public void validate(String fieldname, Address address, ValidationErrors errors) {
        if (address.getCity() == null || address.getCity().isEmpty()) errors.addFieldError(fieldname + ".city", "Field is empty");
        if (address.getCountry() == null || address.getCountry().isEmpty()) errors.addFieldError(fieldname + ".country", "Field is empty");
        if (address.getHouseNo() == null || address.getHouseNo().isEmpty()) errors.addFieldError(fieldname + ".houseNo", "Field is empty");
        if (address.getStreet() == null || address.getStreet().isEmpty()) errors.addFieldError(fieldname + ".street", "Field is empty");
        if (address.getZipcode() == null || address.getZipcode().isEmpty()) errors.addFieldError(fieldname + ".zipcode", "Field is empty");
    }
}
