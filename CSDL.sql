CREATE TABLE video (
    id INT PRIMARY KEY,
    title VARCHAR(255),
    poster VARCHAR(255),
    views INT,
    description TEXT,
    active CHAR(1) -- Sử dụng CHAR(1) thay vì BOOLEAN
);

CREATE TABLE so_thich (
    id INT PRIMARY KEY,
    userid INT,
    videoid INT,
    likedate DATE,
    FOREIGN KEY (userid) REFERENCES nguoi_dung(id),
    FOREIGN KEY (videoid) REFERENCES video(id)
);

CREATE TABLE chia_se (
    id INT PRIMARY KEY,
    userid INT,
    videoid INT,
    emails TEXT,
    sharedate DATE,
    FOREIGN KEY (userid) REFERENCES nguoi_dung(id),
    FOREIGN KEY (videoid) REFERENCES video(id)
);

CREATE TABLE nguoi_dung (
    id INT PRIMARY KEY,
    password VARCHAR(255),
    email VARCHAR(255),
    fullname VARCHAR(255),
    admin CHAR(1) -- Sử dụng CHAR(1) thay vì BOOLEAN
);
