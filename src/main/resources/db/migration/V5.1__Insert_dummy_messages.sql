INSERT INTO messages (id, `from`, `to`, topic, body, read) VALUES (1, 1, 2, 'Test message', 'This is a nice test message for demonstration only.', false);
INSERT INTO messages (id, `from`, `to`, topic, body, read) VALUES (2, 1, 2, 'Test message II', 'This is a nice already seen test message for demonstration only.', true);
INSERT INTO messages (id, `from`, `to`, topic, body, read) VALUES (3, NULL, 2, 'System message', 'These messages are sent by the system, thats why the sender is null.', false);