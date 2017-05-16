-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: localhost    Database: foodexpiration
-- ------------------------------------------------------
-- Server version	5.7.10

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `category_id` int(12) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(25) NOT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Dairy'),(2,'Meat'),(3,'Fruit'),(4,'Vegetables');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item` (
  `item_id` int(14) NOT NULL AUTO_INCREMENT,
  `category_id` int(12) NOT NULL,
  `item_name` varchar(50) NOT NULL,
  `expiration_time` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`item_id`),
  KEY `fk_cat` (`category_id`),
  CONSTRAINT `item_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=123 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` VALUES (1,1,'Hard Cheese Parmesan, Asiago, Romano','3-6 Weeks'),(2,1,'Shredded Hard Cheese Parmesan, Asiago, Romano','3-4 Weeks'),(3,1,'Semi-Hard Cheese Cheddar, Swiss','3-6 Weeks'),(4,1,'Sliced Semi-Hard Cheese Cheddar, Swiss','2 Weeks'),(7,1,'Cottage Cheese','5-7 Days'),(8,1,'Ricotta Cheese','5-7 Days'),(9,1,'Cream Cheese, Neufchatel','1-2 Weeks'),(10,1,'Buttermilk','7-10 Days'),(11,1,'Liquid Creams','5-7 Days'),(12,1,'Cool Whip','7-10 Days'),(13,1,'Eggnog','5 Days'),(14,1,'Milk','5-7 Days'),(15,1,'Milk Alternatives Soy, Rice, Almond, Hemp','5-7 Days'),(16,1,'Pudding','1 Day'),(17,1,'Sour Cream','7-10 Days'),(18,1,'Butter','2 Weeks'),(19,1,'Butter with oil','2-3 Weeks'),(20,1,'Margarine','1-2 Months'),(21,1,'Yogurt','1 Week'),(22,1,'Eggs','3-4 Weeks'),(23,1,'Egg Substitutes','3-4 Days'),(24,1,'Egg Whites','2-4 Days'),(25,1,'Egg Yolks','1-2 Days'),(26,1,'Hard Boiled Eggs with shell','7 Days'),(27,1,'Hard Boiled Eggs without shell','5 Days'),(28,2,'Bacon','1 Week'),(29,2,'Beef','1-2 Days'),(30,2,'Ground Beef','1-2 Days'),(31,2,'Steak','1-2 Days'),(32,2,'Deli Meats','5-6 Days'),(33,2,'Packaged Lunch Meat','7-10 Days'),(34,2,'Bologna','1-2 Weeks'),(35,2,'Hard Salami','2-3 Weeks'),(36,2,'Pepperoni','2-3 Weeks'),(37,2,'Chicken','1-2 Days'),(38,2,'Salmon','1-2 Days'),(39,2,'Cod','1-2 Days'),(40,2,'Halibut','1-2 Days'),(41,2,'Tilapia','1-2 Days'),(42,2,'Catfish','1-2 Days'),(43,2,'Smoked Salmon','5-7 Days'),(44,2,'Shrimp Shelled','1-2 Days'),(45,2,'Shrimp Shell On','2-3 Days'),(46,2,'Ham','7-10 Days'),(47,2,'Pork Chops','1-2 Days'),(48,2,'Ground Pork','1-2 Days'),(49,2,'Pork Shoulder','1-2 Days'),(50,2,'Pork Loin','1-2 Days'),(51,2,'Pork Sausage','3-4 Days'),(52,2,'Turkey','1-2 Days'),(53,2,'Ground Turkey','1-2 Days'),(54,2,'Hot Dogs','1-2 Weeks'),(55,3,'Apples','1-2 Months'),(56,3,'Apples Cut','3-5 Days'),(57,3,'Applesauce','1-2 Weeks'),(58,3,'Avocados','7-10 Days'),(59,3,'Bananas','2-9 Days'),(60,3,'Blueberries','5-10 Days'),(61,3,'Cherries','5-10 Days'),(62,3,'Coconuts','1 Week'),(63,3,'Figs','5-7 Days'),(64,3,'Grapes','5-10 Days'),(65,3,'Lemons','1-2 Months'),(66,3,'Lemons Cut','2-3 Days'),(67,3,'Limes','1-2 Months'),(68,3,'Limes Cut','2-3 Days'),(69,3,'Olives','3-4 Months'),(70,3,'Oranges','1-2 Months'),(71,3,'Oranges Cut','1-2 Days'),(72,3,'Peaches','4-5 Days'),(73,3,'Pineapple Whole','4-5 Days'),(74,3,'Pineapple Cut','3-4 Days'),(75,3,'Pomegranates','3 Weeks'),(76,3,'Pomegranate Seeds','5-7 Days'),(77,3,'Pumpkins','3-5 Months'),(78,3,'Pumpkins Cut','2-3 Days'),(79,3,'Strawberries','5-7 Days'),(80,3,'Strawberries Cut','1-3 Days'),(81,3,'Watermelon Whole','2-3 Weeks'),(82,3,'Watermelon Cut','3-5 Days'),(83,4,'Asparagus','5-7 Days'),(84,4,'Bean Sprouts','3-4 Days'),(85,4,'Green Bell Peppers Whole','2-3 Weeks'),(86,4,'Red Bell Peppers Whole','1-2 Weeks'),(87,4,'Orange Bell Peppers','1-2 Weeks'),(88,4,'Yellow Bell Peppers Whole','1-2 Weeks'),(89,4,'Bell Peppers Cut','1-3 Days'),(90,4,'Broccoli','7-14 Days'),(91,4,'Carrots Whole','4-5 Weeks'),(92,4,'Baby Carrots','3-4 Weeks'),(93,4,'Cauliflower','7-21 Days'),(94,4,'Celery Whole','3-4 Weeks'),(95,4,'Corn','5-7 Days'),(96,4,'Cucumbers Whole','1 Week'),(97,4,'Cucumbers Sliced','1-2 Days'),(98,4,'Garlic Chopped','1 Week'),(99,4,'Green Beans','5-7 Days'),(100,4,'Kale','1-2 Weeks'),(101,4,'Mushrooms Whole','7-10 Days'),(102,4,'Mushrooms Sliced','5-7 Days'),(103,4,'Onions Whole','1-2 Months'),(104,4,'Onions Chopped','1 Week'),(105,4,'Scallions Whole','1-2 Weeks'),(106,4,'Parsnips','1 Month'),(107,4,'Pea Pods','3-5 Days'),(108,4,'Snap Peas','5-7 Days'),(109,4,'Russet or White Potatoes','3-4 Months'),(110,4,'Yukon Gold Potatoes','2-3 Months'),(111,4,'Red Potatoes','2-3 Months'),(112,4,'Fingerlings','2-3 Months'),(113,4,'Sweet Potatoes','2-3 Months'),(114,4,'Spinach','3-5 Days'),(115,4,'Squash','5-7 Days'),(116,4,'Yams','2-3 Months'),(117,4,'Iceberg Lettuce','7-10 Days'),(118,4,'Leaf Lettuce','5-7 Days'),(119,4,'Lettuce Chopped or Loose','3-5 Days'),(120,4,'Packaged Lettuce','3-5 Days'),(121,4,'Tomatoes','2 Weeks'),(122,4,'Zucchini','5-7 Days');
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-03-30 21:12:33
