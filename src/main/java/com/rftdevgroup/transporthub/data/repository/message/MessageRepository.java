package com.rftdevgroup.transporthub.data.repository.message;

import com.rftdevgroup.transporthub.data.model.message.Message;
import com.rftdevgroup.transporthub.data.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findAllBySender(User sender);
    List<Message> findAllByTo(User to);
    List<Message> findAllByToAndRead(User to, boolean read);
}
