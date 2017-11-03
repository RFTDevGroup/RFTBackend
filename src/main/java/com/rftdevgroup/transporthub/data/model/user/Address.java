package com.rftdevgroup.transporthub.data.model.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

/**
 * Class representing a street address.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aid")
    private long id;
    private String country;
    private String zipcode;
    private String city;
    private String street;
    private String houseNo;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer()
                .append(country).append(", ")
                .append(zipcode).append(" ")
                .append(city).append(" ")
                .append(street).append(" ")
                .append(houseNo);
        return sb.toString();
    }
}
