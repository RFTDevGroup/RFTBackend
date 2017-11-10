package com.rftdevgroup.transporthub.data.model.transport;

import com.rftdevgroup.transporthub.data.model.user.Address;
import com.rftdevgroup.transporthub.data.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Transport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "owner")
    private User owner;
    @ManyToOne
    @JoinColumn(name = "cargo")
    private Cargo cargo;

    //possible new class
    @ManyToOne
    @JoinColumn(name = "place_of_load")
    private Address placeOfLoad;
    private Date timeOfLoad;

    @ManyToOne
    @JoinColumn(name = "place_of_unload")
    private Address placeOfUnload;
    private Date timeOfUnload;

    private int startingPrice;
    private int currentPrice;
}
