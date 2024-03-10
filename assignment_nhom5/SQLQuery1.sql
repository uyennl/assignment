CREATE DATABASE pizza_store;

USE pizza_store;

CREATE TABLE dish (
    idDish INT IDENTITY(1,1) PRIMARY KEY,
    title NVARCHAR(255) NOT NULL,
    subTitle NVARCHAR(255),
    price FLOAT NOT NULL,
    image NVARCHAR(255),
    status BIT DEFAULT 1, -- Trường trạng thái kiểu BIT
    idCategory INT NOT NULL, -- Thêm cột idCategory
    FOREIGN KEY (idCategory) REFERENCES category(idCategory) -- Khóa ngoại tham chiếu đến bảng category
);

CREATE TABLE category(
    idCategory INT IDENTITY(1,1) PRIMARY KEY,
    cateName NVARCHAR(255) NOT NULL
);

-- Chèn một số mẫu dữ liệu vào bảng dish
INSERT INTO dish (title, subTitle, price, image,status,idCategory)
VALUES 
('Pizza Margherita', 'Classic Italian Pizza', 9.99, 'https://imagevars.gulfnews.com/2023/09/04/Magherita-pizza-_18a6007a47a_medium.jpg', 1,1),
('Pizza Pepperoni', 'Spicy Pepperoni Pizza', 10.99, 'https://www.cobsbread.com/us/wp-content//uploads/2022/09/Pepperoni-pizza-850x630-1.png', 1,2),
('Pizza Hawaiian', 'Ham and Pineapple Pizza', 11.99, 'https://recipes.net/wp-content/uploads/2020/03/dominos-copycat-hawaiian-pizza-recipe.jpg', 1,3),
('Pizza BBQ Chicken', 'BBQ Chicken Pizza', 12.99, 'https://staticcookist.akamaized.net/wp-content/uploads/sites/22/2022/02/bbq-chicken-pizza-1.jpg', 1,4);

insert into category(cateName)
values
('pizza ý'),
('pizza nhật'),
('pizza đức'),
('pizza Việt nam');
-- Xóa dữ liệu trong bảng dish
DELETE FROM dish;

-- Xóa bảng dish
DROP TABLE dish;
select *from dish;