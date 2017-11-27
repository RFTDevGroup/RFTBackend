package com.rftdevgroup.transporthub.service.impl;

import com.rftdevgroup.transporthub.data.dto.message.MessageViewDTO;
import com.rftdevgroup.transporthub.data.model.message.Message;
import com.rftdevgroup.transporthub.data.model.user.User;
import com.rftdevgroup.transporthub.data.repository.message.MessageRepository;
import com.rftdevgroup.transporthub.data.repository.user.UserRepository;
import com.rftdevgroup.transporthub.service.MessageService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepository userRepository;

    @Override
    public <T> Optional<T> findAndMapMessage(long id, Class<T> mapTo) {
        Message message = messageRepository.findOne(id);
        return message == null ? Optional.empty() : Optional.of(modelMapper.map(message, mapTo));
    }

    @Override
    public List<MessageViewDTO> findMessagesFor(String username) {
        Optional<User> user = userRepository.findUserByUserName(username);
        if (!user.isPresent()) {
            return null;
        }
        List<Message> messages = messageRepository.findAllByTo(user.get());
        return messages.stream().map(m -> modelMapper.map(m, MessageViewDTO.class)).collect(Collectors.toList());
    }
}
