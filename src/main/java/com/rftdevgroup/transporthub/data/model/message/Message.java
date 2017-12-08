package com.rftdevgroup.transporthub.data.model.message;

import com.rftdevgroup.transporthub.data.model.user.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    @JoinColumn(name = "sender")
    private User sender;
    @OneToOne
    @JoinColumn(name = "to")
    private User to;
    private String topic;
    @Lob
    @Column(columnDefinition = "TEXT")
    private String body;
    private boolean read;
}
