-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jul 31, 2018 at 02:53 PM
-- Server version: 5.7.19
-- PHP Version: 7.1.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `library`
--

-- --------------------------------------------------------

--
-- Table structure for table `tblbook`
--

DROP TABLE IF EXISTS `tblbook`;
CREATE TABLE IF NOT EXISTS `tblbook` (
  `id` varchar(15) NOT NULL,
  `title` varchar(15) NOT NULL,
  `publisher` varchar(15) NOT NULL,
  `yearPublished` varchar(15) NOT NULL,
  `ISBN` varchar(15) NOT NULL,
  `price` double NOT NULL,
  `author` varchar(15) NOT NULL,
  `edition` int(11) NOT NULL,
  `status` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tblbook`
--

INSERT INTO `tblbook` (`id`, `title`, `publisher`, `yearPublished`, `ISBN`, `price`, `author`, `edition`, `status`) VALUES
('1', '1', '1', '1', '1', 1, '1', 1, 0),
('10', '1', '1', '1', '1', 1, '11', 1, 0),
('11', '1', '1', '1', '1', 1, '1', 1, 0),
('12', '1', '1', '1', '1', 1, '1', 1, 0),
('13', '1', '1', '1', '1', 1, '1', 1, 0),
('14', '1', '1', '1', '1', 1, '1', 1, 0),
('16', '1', '1', '1', '1', 1, '1', 1, 1),
('2', '2', '2', '2', '2', 2, '2', 2, 0),
('3', '3', '3', '3', '3', 3, '3', 3, 0),
('4', '3', '3', '3', '3', 3, '3', 3, 0),
('5', '1', '1', '1', '1', 1, '1', 1, 0),
('6', '1', '1', '1', '1', 1, '1', 1, 0),
('7', '1', '1', '1', '1', 1, '1', 1, 0),
('8', '1', '1', '1', '1', 1, '1', 1, 0),
('9', '1', '1', '1', '1', 1, '1', 1, 0);

-- --------------------------------------------------------

--
-- Table structure for table `tblborrow`
--

DROP TABLE IF EXISTS `tblborrow`;
CREATE TABLE IF NOT EXISTS `tblborrow` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `member` varchar(15) NOT NULL,
  `book` varchar(15) NOT NULL,
  `issue` varchar(15) NOT NULL,
  `due` varchar(15) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tblmember`
--

DROP TABLE IF EXISTS `tblmember`;
CREATE TABLE IF NOT EXISTS `tblmember` (
  `id` varchar(30) NOT NULL,
  `name` varchar(30) NOT NULL,
  `address` varchar(50) NOT NULL,
  `dom` varchar(15) NOT NULL,
  `tom` varchar(15) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tblmember`
--

INSERT INTO `tblmember` (`id`, `name`, `address`, `dom`, `tom`) VALUES
('1', '1', '1', '1', '1'),
('2', '2', '2', '2', '2'),
('2', '2', '2', '2', '2'),
('1', '1', '1', '1', '1');

-- --------------------------------------------------------

--
-- Table structure for table `tblthesis`
--

DROP TABLE IF EXISTS `tblthesis`;
CREATE TABLE IF NOT EXISTS `tblthesis` (
  `id` varchar(15) NOT NULL,
  `title` varchar(15) NOT NULL,
  `publisher` varchar(15) NOT NULL,
  `yearPublished` varchar(15) NOT NULL,
  `writer` varchar(15) NOT NULL,
  `type` varchar(15) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tblthesis`
--

INSERT INTO `tblthesis` (`id`, `title`, `publisher`, `yearPublished`, `writer`, `type`) VALUES
('1', '1', '1', '1', '1', '1');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
