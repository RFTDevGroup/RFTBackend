package com.rftdevgroup.transporthub.data.model.transport;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cid")
    private long id;
    private String name;
    private String description;
    private long weight;
    private double width;
    private double height;
    private double depth;
}
