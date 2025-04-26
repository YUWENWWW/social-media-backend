-- 建立 User 資料表
CREATE TABLE IF NOT EXISTS user (
                                    user_id INT AUTO_INCREMENT PRIMARY KEY,
                                    user_name VARCHAR(50) NOT NULL,
                                    phone VARCHAR(20) NOT NULL UNIQUE,   -- 手機號碼登入 (取代 email)
                                    password_hash VARCHAR(255) NOT NULL, -- 儲存經 Hash 加密後的密碼
                                    cover_image VARCHAR(255),
                                    biography TEXT,
                                    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 建立 Post 資料表
CREATE TABLE IF NOT EXISTS post (
                                    post_id INT AUTO_INCREMENT PRIMARY KEY,
                                    user_id INT NOT NULL,
                                    content TEXT NOT NULL,
                                    image VARCHAR(255),
                                    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                    FOREIGN KEY (user_id) REFERENCES user(user_id) ON DELETE CASCADE
);

-- 建立 Comment 資料表
CREATE TABLE IF NOT EXISTS comment (
                                       comment_id INT AUTO_INCREMENT PRIMARY KEY,
                                       post_id INT NOT NULL,
                                       user_id INT NOT NULL,
                                       content TEXT NOT NULL,
                                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                       FOREIGN KEY (post_id) REFERENCES post(post_id) ON DELETE CASCADE,
                                       FOREIGN KEY (user_id) REFERENCES user(user_id) ON DELETE CASCADE
);
