package com.rftdevgroup.transporthub.data.model.auction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.rftdevgroup.transporthub.data.model.transport.Transport;
import com.rftdevgroup.transporthub.data.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class Bid {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    @JoinColumn(name = "bidder")
    private User bidder;
    @OneToOne
    @JoinColumn(name = "transport")
    @JsonBackReference
    private Transport transport;
    private int amount;
}
