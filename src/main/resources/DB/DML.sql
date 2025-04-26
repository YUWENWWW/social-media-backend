-- 插入範例使用者
INSERT INTO user (user_name, phone, password_hash, cover_image, biography) VALUES
('Alice', '123456890', 'hashedpassword123', NULL, 'Hi, I am Alice!'),
('Bob', '234567890', 'hashedpassword456', NULL, 'Hi, I am Bob!');

-- 插入範例貼文
INSERT INTO post (user_id, content, image) VALUES
(1, 'Hello, this is Alice''s first post!', NULL),
(2, 'Excited to join this platform!', NULL);

-- 插入範例留言
INSERT INTO comment (post_id, user_id, content) VALUES
(1, 2, 'Nice to meet you, Alice!'),
(2, 1, 'Welcome Bob!');