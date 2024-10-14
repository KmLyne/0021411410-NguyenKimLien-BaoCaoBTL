-- Bảng products
CREATE TABLE products (
    productID SERIAL PRIMARY KEY,
    productName VARCHAR(100),
    categoryID INT,
    animalID INT,
    description TEXT,
    price INT,
    stockQuantity INT,
    image VARCHAR(100),
    createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updateAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (categoryID) REFERENCES categories(categoryID),
    FOREIGN KEY (animalID) REFERENCES animals(animalID)
);

-- Bảng animals
CREATE TABLE animals(
    animalID SERIAL PRIMARY KEY,
    animalName VARCHAR(100)
);

-- Bảng categories
CREATE TABLE categories(
    categoryID SERIAL PRIMARY KEY,
    categoryName VARCHAR(100),
    createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Bảng orders
CREATE TABLE orders(
    orderID SERIAL PRIMARY KEY,
    customerID INT,
    orderDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    totalAmount INT,
    status VARCHAR(100),
    FOREIGN KEY (customerID) REFERENCES customers(customerID)
);

-- Bảng orderdetails
CREATE TABLE orderdetails(
    orderdetailID SERIAL PRIMARY KEY,
    orderID INT,
    productID INT,
    quantity INT,
    price INT,
    FOREIGN KEY (orderID) REFERENCES orders(orderID),
    FOREIGN KEY (productID) REFERENCES products(productID)
);

-- Bảng customers
CREATE TABLE customers(
    customerID SERIAL PRIMARY KEY,
    image VARCHAR(100),
    fullName VARCHAR(100),
    email VARCHAR(100),
    passwordHash VARCHAR(100),
    phoneNumber VARCHAR(15),
    address TEXT,
    roleID INT,
    registrationDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (roleID) REFERENCES roles(roleID)
);

-- Bảng roles
CREATE TABLE roles(
    roleID SERIAL PRIMARY KEY,
    roleName VARCHAR(100)
);



INSERT INTO roles (roleName) VALUES
('Quản trị viên'),
('Khách hàng')
;

--Bảng thanh toán
CREATE TABLE payments(
	paymentID SERIAL PRIMARY KEY,
	orderID INT,
	paymentMethod VARCHAR(100),
	paymentDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	paymentAmount INT,
	FOREIGN KEY (orderID) REFERENCES orders(orderID)
);

--Bảng vận chuyển 
CREATE TABLE shipphing(
	shippingID SERIAL PRIMARY KEY,
	orderID int,
	shippingMethod VARCHAR(100),
	shippingStatus varchar(100),
	trackingNumber VARCHAR(100),
	estimatedDeliveryDate DATE,
	FOREIGN KEY (orderID) REFERENCES orders(orderID)
);

--Bảng đánh giá 
CREATE TABLE reviews(
	reviewsID serial primary key,
	productID int,
	customerID int,
	rating int check(rating >=1 and rating <=5),
	comment text,
	reviewDate timestamp default current_timestamp,
	foreign key (productID) references products(productID),
	foreign key (customerID) references customers(customerID)
);

-- Bảng danh sách yêu thích
create table wishlists(
	wishlistID serial primary key,
	customerID int,
	productID int,
	createAt timestamp default current_timestamp,
	foreign key (customerID) references customers(customerID),
	foreign key (productID) references products(productID)
);

--Bảng khuyến mãi
create table promotions(
	promotionID serial primary key,
	promotionCode varchar(100),
	discountPercentage int check (discountPercentage > 0 and discountPercentage <= 100),
	startDate timestamp,
	endDate timestamp
);

--Bảng liên kết sản phẩm khuyến mãi
create table product_promotions(
	productID int,
	promotionID int,
	foreign key (productID) references products(productID),
	foreign key (promotionID) references promotions(promotionID),
	primary key (productID, promotionID)
);

INSERT INTO payments (orderID, paymentMethod, paymentDate, paymentAmount) VALUES
(1, 'Thẻ tín dụng', '2024-09-14 10:30:00', 500000),
(2, 'Ví điện tử', '2024-09-14 11:00:00', 350000),
(3, 'Chuyển khoản ngân hàng', '2024-09-14 12:15:00', 700000);

INSERT INTO shipphing (orderID, shippingMethod, shippingStatus, trackingNumber, estimatedDeliveryDate) VALUES
(1, 'Giao hàng nhanh', 'Đang giao', 'GHN123456', '2024-09-16'),
(2, 'Giao hàng tiêu chuẩn', 'Đã giao', 'GHTK789012', '2024-09-15'),
(3, 'Giao hàng nhanh', 'Đang giao', 'GHN654321', '2024-09-17');

INSERT INTO reviews (productID, customerID, rating, comment, reviewDate) VALUES
(1, 1, 5, 'Sản phẩm rất tốt, mình rất hài lòng!', '2024-09-14 09:45:00'),
(2, 2, 4, 'Chất lượng ổn, giá hợp lý', '2024-09-13 10:00:00'),
(3, 3, 3, 'Cũng được nhưng cần cải thiện', '2024-09-12 15:30:00');

INSERT INTO wishlists (customerID, productID, createdAt) VALUES
(1, 1, '2024-09-14 09:00:00'),
(2, 3, '2024-09-14 09:15:00'),
(3, 2, '2024-09-14 09:30:00');

INSERT INTO promotions (promotionCode, discountPercentage, startDate, endDate) VALUES
('SUMMER2024', 20, '2024-06-01 00:00:00', '2024-09-30 23:59:59'),
('NEWYEAR2025', 15, '2024-12-15 00:00:00', '2025-01-15 23:59:59');

INSERT INTO promotions (promotionCode, discountPercentage, startDate, endDate) VALUES
('SUMMER2024', 20, '2024-06-01 00:00:00', '2024-09-30 23:59:59'),
('NEWYEAR2025', 15, '2024-12-15 00:00:00', '2025-01-15 23:59:59');

INSERT INTO product_promotions (productID, promotionID) VALUES
(1, 1),
(2, 1),
(3, 2);



INSERT INTO customers (fullName, email, passwordHash, phoneNumber, address, roleID, image) VALUES
('Quản trị viên', 'admin@example.com', 'hashedpasswordadmin', '0123456789', '123 Đường Quản Trị, Thành phố', 1, 'admin_avatar.jpg'),  -- Quản trị viên
('Trần Thị B', 'tranthib@example.com', 'hashedpassword2', '0987654321', '456 Đường Chăm Sóc, Thị trấn', 2, 'customer_avatar_1.jpg'),  -- Khách hàng
('Lê Thị C', 'lethic@example.com', 'hashedpassword3', '0123894567', '789 Đường Thú Y, Làng', 2, 'customer_avatar_2.jpg'),            -- Khách hàng
('Phạm Văn D', 'phamvand@example.com', 'hashedpassword4', '0112233445', '321 Đường Chó, Ngoại ô', 2, 'consultant_avatar.jpg'),       
('Vũ Thị E', 'vuthie@example.com', 'hashedpassword5', '0192837465', '654 Đường Mèo, Khu đô thị', 2, 'seller_avatar.jpg');            

INSERT INTO categories (categoryName) VALUES
('Thức ăn'),
('Đồ chơi'),
('Quần áo'),
('Phụ kiện'),
('Chăm sóc sức khỏe');

INSERT INTO animals (animalName) VALUES
('Chó'),
('Mèo');

INSERT INTO products (productName, categoryID, animalID, description, price, stockQuantity, image) VALUES
('Thức ăn cho chó - Vị gà', 1, 1, 'Thức ăn cao cấp vị gà dành cho chó', 150000, 50, 'thuc_an_cho_cho_ga.jpg'),
('Đồ chơi cho mèo - Lông vũ', 2, 2, 'Đồ chơi lông vũ tương tác cho mèo', 50000, 100, 'do_choi_meo_long_vu.jpg'),
('Thức ăn cho chó - Vị bò', 1, 1, 'Thức ăn dinh dưỡng vị bò dành cho chó', 180000, 40, 'thuc_an_cho_cho_bo.jpg'),
('Đồ chơi cho chó - Bóng cao su', 2, 1, 'Bóng cao su bền cho chó chơi', 60000, 70, 'do_choi_cho_bong_cao_su.jpg'),
('Thức ăn cho mèo - Cá hồi', 1, 2, 'Thức ăn dinh dưỡng vị cá hồi dành cho mèo', 120000, 80, 'thuc_an_cho_meo_ca_hoi.jpg');

INSERT INTO orders (customerID, totalAmount, status) VALUES
(1, 500000, 'Chờ xử lý'),
(2, 750000, 'Đã xác nhận'),
(3, 300000, 'Hoàn thành'),
(4, 200000, 'Đã hủy'),
(5, 450000, 'Đang giao hàng');

INSERT INTO orderdetails (orderID, productID, quantity, price) VALUES
(1, 1, 2, 300000),
(1, 2, 1, 50000),
(2, 3, 1, 75000),
(3, 4, 1, 200000),
(4, 5, 1, 100000);

