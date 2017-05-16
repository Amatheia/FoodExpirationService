Food Expiration Service

create table category (
  `category_id` int(12) NOT NULL auto_increment,
  `category_name` varchar(25) NOT NULL,
  PRIMARY KEY  (category_id)
);

create table item (
  `item_id` int(14) NOT NULL auto_increment primary key,
  `category_id` int(12) NOT NULL,
  `item_name` varchar(50) NOT NULL,
  `expiration_time` varchar(50),
  FOREIGN KEY fk_cat(category_id)
  REFERENCES category(category_id)
  ON UPDATE CASCADE
  ON DELETE RESTRICT
);


 