package com.rftdevgroup.transporthub.service;

import com.rftdevgroup.transporthub.data.dto.message.MessageViewDTO;
import com.rftdevgroup.transporthub.data.model.user.User;
import java.util.List;
import java.util.Optional;

public interface MessageService {
    <T> Optional<T> findAndMapMessage(long id, Class<T> mapTo);
    List<MessageViewDTO> findMessagesFor(String username);
    void sendSystemMessage(User to, String messageTopic, String messageBody);
}
